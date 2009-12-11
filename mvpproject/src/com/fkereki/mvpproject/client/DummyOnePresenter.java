package com.fkereki.mvpproject.client;

public class DummyOnePresenter
    extends Presenter<DummyOneDisplay> {
  static String PLACE= "foo";

  public DummyOnePresenter(String params,
      DummyOneDisplay dummyOneDisplay, Environment environment) {

    super(params, dummyOneDisplay, environment);
    dummyOneDisplay.setPepeValue(getKvm().get("pepe"));
    dummyOneDisplay
        .setClickCallback(new SimpleCallback<Object>() {

          @Override
          public void goBack(Object result) {
            (DummyOnePresenter.this.getDisplay())
                .showPopupPanel();
            DummyOnePresenter.this.getEnvironment().launch(
                "baz",
                (DummyOnePresenter.this.getDisplay())
                    .getPopupPanel());
          }
        });
  }
}
