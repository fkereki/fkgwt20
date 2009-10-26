package com.fkereki.mvptest.client;



public class Presenter<T> {
  View view;
  Model model;
  SimpleCallback<T> callback;

  public Presenter() {
  }

  public Presenter(View aView, Model aModel,
    SimpleCallback<T> aCallback) {
    view = aView;
    model = aModel;
    callback = aCallback;
  }

  public View getView() {
    return view;
  }
}
