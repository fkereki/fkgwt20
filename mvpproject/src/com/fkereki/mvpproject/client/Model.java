package com.fkereki.mvpproject.client;

import com.google.gwt.core.client.GWT;

/**
 * @author fkereki
 */
public class Model {
  private LoginServiceAsync loginService;
  private WorldServiceAsync worldService;

  /**
   * Provide a remote login service handle;
   * 
   * @return
   */
  public LoginServiceAsync getRemoteLoginService() {
    if (loginService == null) {
      loginService = GWT.create(LoginService.class);
    }
    return loginService;
  }

  public WorldServiceAsync getRemoteWorldService() {
    if (worldService == null) {
      worldService = GWT.create(WorldService.class);
    }
    return worldService;
  }

  // WorldServiceAsync ws = GWT.create(WorldService.class);
  //
  // ws.getCountries(new AsyncCallback<LinkedHashMap<String, String>>() {
  //
  // @Override
  // public void onFailure(Throwable caught) {
  // Window.alert("failed...");
  // }
  //
  // @Override
  // public void onSuccess(LinkedHashMap<String, String> result) {
  // countries = result;
  // Window.alert("succeeded!!! " + result.get("UY"));
  // }
  // });

}
