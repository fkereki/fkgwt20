package com.fkereki.mvpproject.client;



public class ClientDataPresenter extends Presenter<ClientDataDisplay> {

  static String PLACE = "client";


  public ClientDataPresenter(String params, ClientDataDisplay clientDisplay,
    Environment environment) {

    super(params, clientDisplay, environment);

    clientDisplay.setSearchClickCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(Object result) {
        ((ClientDataDisplay) (ClientDataPresenter.this.getDisplay())).showPopupPanel();
        ClientDataPresenter.this.getEnvironment().launch(ClientSearchPresenter.PLACE,
          ((ClientDataDisplay) (ClientDataPresenter.this.getDisplay())).getPopupPanel());
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
