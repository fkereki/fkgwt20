package com.fkereki.mvpproject.client.citiesUpdater;

import java.util.HashMap;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.ClientCityData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

public class CitiesUpdaterPresenter
    extends Presenter<CitiesUpdaterDisplay> {

  public static String PLACE = "cityupdate";

  HashMap<Integer, ClientCityData> cityList = new HashMap<Integer, ClientCityData>();

  public CitiesUpdaterPresenter(
      final String params, final CitiesUpdaterDisplay citiesUpdaterDisplay,
      final Environment environment) {

    super(params, citiesUpdaterDisplay, environment);

    getDisplay().setOnGetCitiesClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        clearCities();

        /*
         * The HostPageBaseURL looks like http://yourServer:8888/somePath and we
         * want to rebuild it into http://yourServer:80/otherPath
         */
        String baseUrl = "http:" + GWT.getHostPageBaseURL().split(":")[1];
        final RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, URL
            .encode(baseUrl + ":80/bookphp/getcities1.php?city="
                + getDisplay().getCityNameStart()));
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
        } catch (Exception e) {
          Window.alert(e.getMessage());
        }
      }
    });

    getDisplay().setOnUpdateCitiesClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object dummy) {

        // initialize XML object
        boolean somethingToUpdate = false;
        String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

        result += "<cities>\n";
        for (int i = 0; i < cityList.size(); i++) {
          int gridPop = getDisplay().getCityPopulation(i + 1);
          ClientCityData thisCity = cityList.get(i + 1);

          if (thisCity.population != gridPop) {
            somethingToUpdate = true;

            /*
             * In truth, putting latitude and longitude in the XML string isn't
             * needed; let's do it just for showing how it's done.
             */
            result += "<city>\n";
            result += " <city name=\"" + thisCity.cityName + "\">\n";
            result += "  <country code=\"" + thisCity.countryCode + "\"/>\n";
            result += "  <state code=\"" + thisCity.stateCode + "\"/>\n";
            result += "  <pop>" + gridPop + "</pop>\n";
            result += "  <coords>\n";
            result += "   <lat>" + thisCity.latitude + "</lat>\n";
            result += "   <lon>" + thisCity.longitude + "</lon>\n";
            result += "  </coords>\n";
            result += "</city>\n";
          }
        }
        result += "</cities>\n";

        if (somethingToUpdate) {
          Window.alert(result);
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

  String citiesToXml1() {
    for (int i : cityList.keySet()) {

    }
    return "";
  }

  String citiesToXml2() {
    return "";
  }

  void clearCities() {
    cityList.clear();
    getDisplay().clearAllCities();
  }

  void loadCities(String xmlCities) {
    cityList.clear();

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
        String countryCode = country.getAttributeNode("code").getValue();
        String countryName = country.getAttributeNode("name").getValue();

        final Element state = (Element) city.getElementsByTagName("state")
            .item(0);
        String stateCode = state.getAttributeNode("code").getValue();
        String stateName = state.getAttributeNode("name").getValue();

        int population = 0;
        Element popElem = (Element) city.getElementsByTagName("pop").item(0);
        if (popElem != null) {
          population = Integer.parseInt(popElem.getFirstChild().getNodeValue());
        }

        Element coords = (Element) city.getElementsByTagName("coords").item(0);
        Element lat = (Element) coords.getElementsByTagName("lat").item(0);
        Element lon = (Element) coords.getElementsByTagName("lon").item(0);
        float latitude = Float.parseFloat(lat.getFirstChild().getNodeValue());
        float longitude = Float.parseFloat(lon.getFirstChild().getNodeValue());

        getDisplay().setCityData(i + 1, cityName, countryName, stateName,
            population);

        /*
         * Given the usage of cityList, we could have set latitude and longitude
         * to 0.0
         */
        cityList.put(i + 1, new ClientCityData(countryCode, stateCode,
            cityName, "", population, latitude, longitude));
      }
    }
  }
}