package com.fkereki.mvpproject.client.cityCreator;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

public interface CityCreatorDisplay extends Display {
  String getAccentedCityName();

  String getCityName();

  String getCountry();

  float getLatitude();

  float getLongitude();

  int getPopulation();

  String getState();

  void setCountryList(LinkedHashMap<String, String> cl);

  void setOnAddClickCallback(SimpleCallback<Object> acb);

  void setOnCountryChangeCallback(SimpleCallback<Object> acb);

  void setStateList(LinkedHashMap<String, String> sl);
}
