package com.fkereki.mvptest.client;




public class Presenter<T> {
  View view;
  SimpleCallback<T> callback;

  public Presenter() {
  }

  public Presenter(View aView, SimpleCallback<T> aCallback) {
    view = aView;
    callback = aCallback;
  }

  public View getView() {
    return view;
  }
}
