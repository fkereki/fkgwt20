package com.fkereki.mvpproject.client.clientData;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.clientSearch.ClientSearchPresenter;

public class ClientDataPresenter
    extends Presenter<ClientDataDisplay> {

  public static String PLACE = "client";

  public ClientDataPresenter(
      String params, ClientDataDisplay clientDisplay, Environment environment) {

    super(params, clientDisplay, environment);

    clientDisplay.setSearchClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        (ClientDataPresenter.this.getDisplay()).showPopupPanel();
        ClientDataPresenter.this.getEnvironment().launch(
            ClientSearchPresenter.PLACE,
            (ClientDataPresenter.this.getDisplay()).getPopupPanel());
      }
    });

    // dummyOneDisplay.setPepeValue(getKvm().get("pepe"));
    // dummyOneDisplay
    // .setClickCallback(new SimpleCallback<Object>() {
    //
    // @Override
    // public void goBack(Object result) {
    // ((DummyOneDisplay) ClientPresenter.this
    // .getDisplay()).showPopupPanel();
    // ClientPresenter.this.environment.launch("baz",
    // ((DummyOneDisplay) ClientPresenter.this
    // .getDisplay()).getPopupPanel());
    // }
    // });
  }
}
