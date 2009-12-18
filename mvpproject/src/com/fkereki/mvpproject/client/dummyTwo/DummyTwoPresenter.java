package com.fkereki.mvpproject.client.dummyTwo;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;

public class DummyTwoPresenter extends Presenter<DummyTwoDisplay> {

  public static String PLACE = "baz";

  public DummyTwoPresenter(String params, DummyTwoDisplay dummyTwoDisplay,
      Environment environment) {

    super(params, dummyTwoDisplay, environment);
  }
}
