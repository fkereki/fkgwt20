package com.fkereki.mvptest.client;


public class DummyTwoPresenter extends Presenter {


  static String PLACE = "baz";


  public DummyTwoPresenter(String params,
    DummyTwoPresenterDisplay dummyTwoDisplay, Model model) {

    super(params, dummyTwoDisplay, model);
  }


  public interface DummyTwoPresenterDisplay extends Display {
  }
}
