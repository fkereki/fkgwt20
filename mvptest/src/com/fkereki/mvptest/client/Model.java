package com.fkereki.mvptest.client;

import com.google.gwt.core.client.GWT;

public class Model {
  /**
   * Provide a remote login service handle;
   * 
   * @return
   */
  public LoginServiceAsync getRemoteLoginService() {
    return (GWT.create(LoginService.class));
  }
}
