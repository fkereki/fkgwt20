package com.fkereki.mvptest.client;


public class Presenter {
  View view;

  public Presenter() {
  }

  public Presenter(View aView) {
    view = aView;
  }

  public View getView() {
    return view;
  }
}
