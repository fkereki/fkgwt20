package com.fkereki.mvpproject.client;

import com.google.gwt.core.client.GWT;

/**
 * @author fkereki
 */
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
