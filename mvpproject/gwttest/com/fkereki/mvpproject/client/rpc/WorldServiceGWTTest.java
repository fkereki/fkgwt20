package com.fkereki.mvpproject.client.rpc;

import java.util.LinkedHashMap;

import org.junit.Test;

import com.fkereki.mvpproject.client.Model;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.junit.client.GWTTestCase;

public class WorldServiceGWTTest
    extends GWTTestCase {

  final Model model = new Model();

  @Override
  public String getModuleName() {
    return "com.fkereki.mvpproject.Mvpproject";
  }

  @Test
  public void testGetCities() {
    model.getCities("UY", "17", 0, 1000,
        new SimpleCallback<LinkedHashMap<String, ClientCityData>>() {
          @Override
          public void goBack(
              final LinkedHashMap<String, ClientCityData> result) {

            assertTrue(result.size() > 0);
            assertEquals("Darwin",
                result.get("darwin").cityAccentedName);
            finishTest();
          }
        });

    delayTestFinish(5000);
  }

  @Test
  public void testGetCountries() {
    model
        .getCountries(new SimpleCallback<LinkedHashMap<String, String>>() {
          @Override
          public void goBack(final LinkedHashMap<String, String> result) {

            assertTrue(result.size() > 0);
            assertTrue(result.containsKey("UY"));
            finishTest();
          }
        });

    delayTestFinish(5000);
  }
}
