package com.fkereki.mvptest.client;

import java.util.HashMap;

public class KeyValueMap extends HashMap<String, String> {
  /**
   * KeyValueMap: a short way of specifying a class that
   * will be used to pass parameters to forms.
   */
  private static final long serialVersionUID = 5225712868559413562L;

  public KeyValueMap() {
    this("");
  }

  public KeyValueMap(final String params) {
    initializeWithString(params);
  }

  public void initializeWithString(String params) {
    clear();
    if ((params != null) && !params.isEmpty()) {
      String[] args = params.split("&");
      for (String element : args) {
        int equalIndex = element.indexOf("=");
        if (equalIndex == -1) {
          put(element, "");
        } else {
          put(element.substring(0, equalIndex), element
            .substring(equalIndex + 1));
        }
      }
    }
  }

  @Override
  public String toString() {
    String result = "";
    String separator = "";
    for (String key : keySet()) {
      result += separator + key + "=" + get(key);
      separator = "\n";
    }
    return result;
  }
}
