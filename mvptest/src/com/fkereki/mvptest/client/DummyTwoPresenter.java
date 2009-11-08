package com.fkereki.mvptest.client;


public class DummyTwoPresenter extends Presenter {


  static String PLACE = "baz";


  public DummyTwoPresenter(String params,
    DummyTwoPresenterDisplay dummyTwoDisplay, Model model,
    Environment environment) {

    super(params, dummyTwoDisplay, model, environment);
  }


  public interface DummyTwoPresenterDisplay extends Display {
  }
}
