package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.ui.PopupPanel;


public class ClientDataPresenter extends Presenter {

  static String PLACE = "client";


  public ClientDataPresenter(String params,
    ClientDisplay clientDisplay, Environment environment) {

    super(params, clientDisplay, environment);

    clientDisplay
      .setSearchClickCallback(new SimpleCallback<Object>() {
        @Override
        public void goBack(Object result) {
          ((ClientDisplay) (ClientDataPresenter.this
            .getDisplay())).showPopupPanel();
          ClientDataPresenter.this.getEnvironment().launch(
            ClientSearchPresenter.PLACE,
            ((ClientDisplay) (ClientDataPresenter.this
              .getDisplay())).getPopupPanel());
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


  public interface ClientDisplay extends Display {
    public void setClient(String s);


    public void setSalute(String s);


    public void setName(String s);


    public void setAddress(String s);


    public void setCity(String s);


    public void setZip(String s);


    public void setState(String s);


    public String getClient();


    public String getSalute();


    public String getName();


    public String getAddress();


    public String getCity();


    public String getZip();


    public String getState();


    public PopupPanel getPopupPanel();


    public void hidePopupPanel();


    public void showPopupPanel();


    public void setSearchClickCallback(
      SimpleCallback<Object> scb);
  }
}
