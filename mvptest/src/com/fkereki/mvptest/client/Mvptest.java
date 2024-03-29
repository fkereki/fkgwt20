package com.fkereki.mvptest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class Mvptest implements EntryPoint,
    ValueChangeHandler<String> {

  Environment environment;


  public static native String getUserAgent() /*-{
    return navigator.userAgent.toLowerCase();
  }-*/;



  public void onModuleLoad() {
    // HelloBrowser hb = new HelloBrowser();
    // hb.salute();
    //
    // Window.alert(getUserAgent());

    DOM.removeChild(RootPanel.getBodyElement(), DOM
      .getElementById("loading"));

    environment = new Environment(new Model(), History
      .getToken());

    /*
     * Set up the history management, and start by showing
     * the login form.
     */
    History.addValueChangeHandler(this);
    environment.launch(LoginFormPresenter.PLACE);
  }


  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    environment.launch(event.getValue());
  }
}