package com.fkereki.mvpproject.client.citiesBrowser2;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

public interface CountryStateDisplay extends Display {
  String getCountry();

  String getState();

  void setCountryList(LinkedHashMap<String, String> cl);

  void setOnCountryChangeCallback(SimpleCallback<Object> acb);

  void setOnStateChangeCallback(SimpleCallback<Object> acb);

  void setStateList(LinkedHashMap<String, String> sl);
}
