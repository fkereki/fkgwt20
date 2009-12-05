package com.fkereki.mvpproject.client;


public class DummyTwoPresenter extends Presenter {


  static String PLACE = "baz";


  public DummyTwoPresenter(String params,
    DummyTwoPresenterDisplay dummyTwoDisplay,
    Environment environment) {

    super(params, dummyTwoDisplay, environment);
  }


  public interface DummyTwoPresenterDisplay extends Display {
  }
}
