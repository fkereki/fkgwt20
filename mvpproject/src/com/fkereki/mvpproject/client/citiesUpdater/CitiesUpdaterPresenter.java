package com.fkereki.mvpproject.client.citiesUpdater;

import java.util.ArrayList;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

public class CitiesUpdaterPresenter
    extends Presenter<CitiesUpdaterDisplay> {

  public static String PLACE = "cityupdate";

  ArrayList<ClientCityData> cityList;

  public CitiesUpdaterPresenter(
      final String params, final CitiesUpdaterDisplay citiesUpdaterDisplay,
      final Environment environment) {

    super(params, citiesUpdaterDisplay, environment);

    getDisplay().setOnGetCitiesClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        clearCities();

        final RequestBuilder rb = new RequestBuilder(RequestBuilder.GET,
            "http://localhost/xml_php/getcities1.php?city="
                + getDisplay().getCityNameStart());
        try {
          rb.sendRequest(null, new RequestCallback() {

            @Override
            public void onError(Request request, Throwable exception) {
              getEnvironment().showAlert(exception.getMessage());
            }

            @Override
            public void onResponseReceived(Request request, Response response) {
              loadCities(response.getText());
            }
          });
        } catch (final Exception e) {
          Window.alert(e.getMessage());
        }
      }
    });

    getDisplay().setOnUpdateCitiesClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        // initialize XML object
        boolean somethingToUpdate = false;
        if (cityList != null) {
          for (int i = 0; i < cityList.size(); i++) {
            int gridPop = getDisplay().getCityPopulation(i);
            if (cityList.get(i).population != gridPop) {
              somethingToUpdate = true;
              // add this city to the XML
            }
          }
        }

        if (somethingToUpdate) {
          // if XML object isn't empty
          // use service to update cities
        }
      }
    });

    getDisplay().setOnCityNameStartChangeCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        clearCities();
      }
    });
  }

  void clearCities() {
    cityList = null;
    getDisplay().clearAllCities();
  }

  void loadCities(String xmlCities) {
    if (!xmlCities.isEmpty()) {
      final Document xmlDoc = XMLParser.parse(xmlCities);
      final Element root = xmlDoc.getDocumentElement();
      XMLParser.removeWhitespace(xmlDoc);

      final NodeList cities = root.getElementsByTagName("city");
      for (int i = 0; i < cities.getLength(); i++) {

        final Element city = (Element) cities.item(i);
        String cityName = city.getAttributeNode("name").getValue();

        final Element country = (Element) city.getElementsByTagName("country")
            .item(0);
        String countryName = country.getAttributeNode("name").getValue();

        final Element state = (Element) city.getElementsByTagName("state")
            .item(0);
        String stateName = state.getAttributeNode("name").getValue();

        String population = "0";
        Element popElem = (Element) city.getElementsByTagName("pop").item(0);
        if (popElem != null) {
          population = popElem.getFirstChild().getNodeValue();
        }
        getDisplay().setCityData(i + 1, cityName, countryName, stateName,
            Integer.parseInt(population));

        /*
         * We are not using the country and state code, nor latitude and
         * longitude, but's let's get them anyway, just to see how it's done.
         */
        String countryCode = country.getAttributeNode("code").getValue();
        String stateCode = state.getAttributeNode("code").getValue();
        Element coords = (Element) city.getElementsByTagName("coords").item(0);
        Element lat = (Element) coords.getElementsByTagName("lat").item(0);
        Element lon = (Element) coords.getElementsByTagName("lon").item(0);
        String latitudeAsString = lat.getFirstChild().getNodeValue();
        String longitudeAsString = lon.getFirstChild().getNodeValue();
      }
    }
  }
}