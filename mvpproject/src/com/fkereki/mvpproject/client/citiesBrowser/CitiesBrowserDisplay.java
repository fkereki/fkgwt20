/**
 * 
 */
package com.fkereki.mvpproject.client.citiesBrowser;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

/**
 * @author fkereki
 * 
 */
public interface CitiesBrowserDisplay extends Display {
  String getCountry();

  String getState();

  void setCityLatitude(final int i, final String n);

  void setCityLongitude(final int i, final String n);

  void setCityName(final int i, final String n);

  void setCityPopulation(final int i, final String n);

  void setCountryList(LinkedHashMap<String, String> cl);

  void setOnCountryChangeCallback(SimpleCallback<Object> acb);

  void setOnFirstClickCallback(SimpleCallback<Object> acb);

  void setOnNextClickCallback(SimpleCallback<Object> acb);

  void setOnPreviousClickCallback(SimpleCallback<Object> acb);

  void setStateList(LinkedHashMap<String, String> sl);
}
