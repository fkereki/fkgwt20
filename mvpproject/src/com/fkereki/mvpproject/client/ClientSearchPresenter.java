package com.fkereki.mvpproject.client;



public class ClientSearchPresenter extends Presenter {

  static String PLACE = "clientsearch";


  public ClientSearchPresenter(String params,
    ClientSearchDisplay clientSearchDisplay,
    Environment environment) {

    super(params, clientSearchDisplay, environment);

    // clientSearchDisplay
    // .setSearchClickCallback(new SimpleCallback<Object>()
    // {
    // @Override
    // public void goBack(Object result) {
    // Window.alert("search");
    // ((ClientDisplay) (ClientSearchPresenter.this
    // .getDisplay())).showPopupPanel();
    // }
    // });

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


  public interface ClientSearchDisplay extends Display {

  }
}