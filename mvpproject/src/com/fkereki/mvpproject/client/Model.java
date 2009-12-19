package com.fkereki.mvpproject.client;

import java.util.LinkedHashMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author fkereki
 */
public class Model {
  private LoginServiceAsync loginService;
  private WorldServiceAsync worldService;

  public void getCities(final String country, final String state,
      final int pStart, final int pCount,
      final AsyncCallback<LinkedHashMap<String, ClientCityData>> cb) {
    /*
     * If we call "loadCities(...)" without having selected a country and
     * region, it won't do anything, and just exit gracefully.
     */
    if (!country.isEmpty() && !state.isEmpty()) {
      // displayEmptyCities(0, "Loading...");

      getRemoteWorldService().getCities(country, state, pStart, pCount,
          new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {
            public void onFailure(final Throwable caught) {
              Window.alert("Failure getting cities: " + caught.getMessage());
            }

            public void onSuccess(
                final LinkedHashMap<String, ClientCityData> result) {
              cb.onSuccess(result);
            }
          });
    }
  }

  public void getCountries(final AsyncCallback<LinkedHashMap<String, String>> cb) {
    getRemoteWorldService().getCountries(
        new AsyncCallback<LinkedHashMap<String, String>>() {
          @Override
          public void onFailure(Throwable caught) {
            // ...failure...
          }

          @Override
          public void onSuccess(LinkedHashMap<String, String> result) {
            cb.onSuccess(result);
          }
        });
  }

  /**
   * Provide a remote login service handle; Use lazy evaluation for extra speed.
   * 
   * @return
   */
  public LoginServiceAsync getRemoteLoginService() {
    if (loginService == null) {
      loginService = GWT.create(LoginService.class);
    }
    return loginService;
  }

  /**
   * Provide a remote world service handle; Use lazy evaluation for extra speed.
   * 
   * @return
   */
  public WorldServiceAsync getRemoteWorldService() {
    if (worldService == null) {
      worldService = GWT.create(WorldService.class);
    }
    return worldService;
  }

  public void getStates(final String country,
      final AsyncCallback<LinkedHashMap<String, String>> cb) {

    getRemoteWorldService().getStates(country,
        new AsyncCallback<LinkedHashMap<String, String>>() {
          @Override
          public void onFailure(Throwable caught) {
            // ...failure...
          }

          @Override
          public void onSuccess(LinkedHashMap<String, String> result) {
            cb.onSuccess(result);
          }
        });
  }
}
