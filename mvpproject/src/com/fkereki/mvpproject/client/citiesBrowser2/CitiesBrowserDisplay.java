/**
 * 
 */
package com.fkereki.mvpproject.client.citiesBrowser2;

import com.fkereki.mvpproject.client.Display;
import com.fkereki.mvpproject.client.SimpleCallback;

/**
 * @author fkereki
 * 
 */
public interface CitiesBrowserDisplay extends Display {
  CountryStateView getCountryState();

  void setCityData(final int i, final String name, final String pop,
      final String lat, final String lon);

  void setOnCountryStateChangeCallback(SimpleCallback<Object> acb);

  void setOnFirstClickCallback(SimpleCallback<Object> acb);

  void setOnNextClickCallback(SimpleCallback<Object> acb);

  void setOnPreviousClickCallback(SimpleCallback<Object> acb);
}