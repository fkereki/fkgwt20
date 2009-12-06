package com.fkereki.mvpproject.client;



public class DummyTwoPresenter extends Presenter<DummyTwoDisplay> {


  static String PLACE = "baz";


  public DummyTwoPresenter(String params, DummyTwoDisplay dummyTwoDisplay,
    Environment environment) {

    super(params, dummyTwoDisplay, environment);
  }
}
