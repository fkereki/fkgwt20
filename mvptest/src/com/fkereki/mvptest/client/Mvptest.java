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


  public void onModuleLoad() {
    DOM.removeChild(RootPanel.getBodyElement(), DOM
      .getElementById("loading"));

    environment = new Environment(new Model(), History
      .getToken());

    /*
     * Set up the history management, and start by showing
     * the login form.
     */
    History.addValueChangeHandler(this);
    History.newItem(LoginPresenter.PLACE, true);
  }


  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    environment.executeInPanel(event.getValue());
  }
}