package com.fkereki.mvpproject.client;

import java.util.LinkedHashMap;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("world")
public interface WorldServiceAsync {
  void addCity(ClientCityData cd, AsyncCallback<String> ac);

  void cityExists(String pCountry, String pRegion, String pCity,
      AsyncCallback<Boolean> ac);

  void getCities(String pCountry, String pRegion, int pFrom, int pQuantity,
      AsyncCallback<LinkedHashMap<String, ClientCityData>> ac);

  void getCitiesStartingWith(String pCountry, String pRegion, String pStart,
      AsyncCallback<LinkedHashMap<String, ClientCityData>> callback);

  void getCountries(AsyncCallback<LinkedHashMap<String, String>> ac);

  void getStates(java.lang.String country,
      AsyncCallback<LinkedHashMap<String, String>> ac);
}