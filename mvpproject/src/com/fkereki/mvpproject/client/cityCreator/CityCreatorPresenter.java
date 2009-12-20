package com.fkereki.mvpproject.client.cityCreator;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.user.client.Window;

public class CityCreatorPresenter extends Presenter<CityCreatorDisplay> {
  public static String PLACE = "citycreate";

  public CityCreatorPresenter(final String params,
      final CityCreatorDisplay cityCreatorDisplay, final Environment environment) {

    super(params, cityCreatorDisplay, environment);

    getDisplay().setOnCountryChangeCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        getDisplay().setStateList(null);

        /*
         * If a country was selected, get and load its states
         */
        if (!getDisplay().getCountry().isEmpty()) {
          getEnvironment().getModel().getStates(getDisplay().getCountry(),
              new SimpleCallback<LinkedHashMap<String, String>>() {
                @Override
                public void goBack(LinkedHashMap<String, String> result) {
                  getDisplay().setStateList(result);
                }
              });
        }
      }
    });

    getDisplay().setOnAddClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        Window.alert("clickety!");
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
        new SimpleCallback<LinkedHashMap<String, String>>() {
          @Override
          public void goBack(LinkedHashMap<String, String> result) {
            getDisplay().setCountryList(result);
          }
        });
  }
}