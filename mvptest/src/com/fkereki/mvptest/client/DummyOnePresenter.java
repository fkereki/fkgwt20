package com.fkereki.mvptest.client;


public class DummyOnePresenter extends Presenter {

  static String PLACE = "foo";

  public DummyOnePresenter(String params,
    DummyOneDisplay dummyOneDisplay, Model model) {

    super(params, dummyOneDisplay, model);
    dummyOneDisplay.setPepeValue(getKvm().get("pepe"));
  }

  public interface DummyOneDisplay extends Display {
    public void setPepeValue(String s);
  }
}
