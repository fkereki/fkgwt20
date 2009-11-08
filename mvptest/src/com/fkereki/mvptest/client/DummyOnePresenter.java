package com.fkereki.mvptest.client;

import com.google.gwt.user.client.ui.PopupPanel;


public class DummyOnePresenter extends Presenter {

  static String PLACE = "foo";


  public DummyOnePresenter(String params,
    DummyOneDisplay dummyOneDisplay, Model model,
    Environment environment) {

    super(params, dummyOneDisplay, model, environment);
    dummyOneDisplay.setPepeValue(getKvm().get("pepe"));
    dummyOneDisplay
      .setClickCallback(new SimpleCallback<Object>() {

        @Override
        public void goBack(Object result) {
          ((DummyOneDisplay) DummyOnePresenter.this
            .getDisplay()).showPopupPanel();
          DummyOnePresenter.this.environment
            .executeInPanel("baz",
              ((DummyOneDisplay) DummyOnePresenter.this
                .getDisplay()).getPopupPanel());
        }
      });
  }


  public interface DummyOneDisplay extends Display {
    public void setPepeValue(String s);


    public PopupPanel getPopupPanel();


    public void showPopupPanel();


    public void setClickCallback(SimpleCallback<Object> scb);
  }
}
