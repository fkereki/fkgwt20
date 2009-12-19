package com.fkereki.mvpproject.client.citiesBrowser;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.ClientCityData;
import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CitiesBrowserPresenter extends Presenter<CitiesBrowserDisplay> {
  public static String PLACE = "citybrowse";

  String country = "";
  String state = "";
  int currentStart = 0;

  public CitiesBrowserPresenter(final String params,
      final CitiesBrowserDisplay citiesBrowserDisplay,
      final Environment environment) {

    super(params, citiesBrowserDisplay, environment);

    getDisplay().setOnFirstClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        if (checkCountryAndState()) {
          currentStart = 0;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnPreviousClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        if (checkCountryAndState()) {
          currentStart -= CitiesBrowserView.CITIES_PAGE_SIZE;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnNextClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        if (checkCountryAndState()) {
          currentStart += CitiesBrowserView.CITIES_PAGE_SIZE;
          getAndDisplayCities();
        }
      }
    });

    getDisplay().setOnCountryChangeCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        currentStart = 0;
        String country = getDisplay().getCountry();
        if (country.isEmpty()) {
          LinkedHashMap<String, String> emptyStatesList = new LinkedHashMap<String, String>();
          emptyStatesList.put("", "Loading...");
          getDisplay().setStateList(emptyStatesList);
        } else {

          getEnvironment().getModel().getStates(country,
              new AsyncCallback<LinkedHashMap<String, String>>() {
                @Override
                public void onFailure(Throwable caught) {
                  // ...no countries?...
                }

                @Override
                public void onSuccess(LinkedHashMap<String, String> result) {
                  getDisplay().setStateList(result);
                }
              });
        }
      }
    });

    /*
     * Display "Loading..." in lieu of the list of countries, at least until the
     * actual list comes from the server.
     */
    LinkedHashMap<String, String> emptyCountriesList = new LinkedHashMap<String, String>();
    emptyCountriesList.put("", "Loading...");
    getDisplay().setCountryList(emptyCountriesList);
    getEnvironment().getModel().getCountries(
        new AsyncCallback<LinkedHashMap<String, String>>() {
          @Override
          public void onFailure(Throwable caught) {
            // ...no countries?...
          }

          @Override
          public void onSuccess(LinkedHashMap<String, String> result) {
            getDisplay().setCountryList(result);
          }
        });
  }

  boolean checkCountryAndState() {
    country = getDisplay().getCountry();
    if (!country.isEmpty()) {
      state = getDisplay().getState();
      if (!state.isEmpty()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Display all cities in citiesList in the grid. If there aren't enough cities
   * to fill out the grid, empty the extra rows.
   * 
   * @param pCitiesList
   *          Hash map ordered alphabetically by city name, with up to
   *          CITIES_PAGE_SIZE cities.
   */
  void displayCities(final LinkedHashMap<String, ClientCityData> pCitiesList) {
    final NumberFormat nf = NumberFormat.getDecimalFormat();

    int i = 0;
    for (final String it : pCitiesList.keySet()) {
      i++;
      final ClientCityData cd = pCitiesList.get(it);
      getDisplay().setCityName(i, cd.cityName);
      getDisplay().setCityPopulation(i, nf.format(cd.population));
      getDisplay().setCityLatitude(i, nf.format(cd.latitude));
      getDisplay().setCityLongitude(i, nf.format(cd.longitude));
    }

    displayEmptyCities(i, "");
  }

  /**
   * Blank out all lines in the cities grid, from the line pSince up to the end.
   * 
   * @param pSince
   *          First line to blank
   * 
   * @param pDisplayText
   *          Text to display in the first column; may be "Loading..." or ""
   */
  void displayEmptyCities(int pSince, final String pDisplayText) {
    while (pSince < CitiesBrowserView.CITIES_PAGE_SIZE) {
      pSince++;
      getDisplay().setCityName(pSince, pDisplayText);
      getDisplay().setCityPopulation(pSince, "");
      getDisplay().setCityLatitude(pSince, "");
      getDisplay().setCityLongitude(pSince, "");
    }
  }

  void getAndDisplayCities() {
    if (currentStart < 0) {
      currentStart = 0;
    }

    getEnvironment().getModel().getCities(country, state, currentStart,
        CitiesBrowserView.CITIES_PAGE_SIZE,
        new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {

          @Override
          public void onFailure(Throwable caught) {
            Window.alert("...failure getting cities...");
          }

          @Override
          public void onSuccess(LinkedHashMap<String, ClientCityData> result) {
            // TODO Auto-generated method stub
            displayCities(result);
          }
        });

  }

}