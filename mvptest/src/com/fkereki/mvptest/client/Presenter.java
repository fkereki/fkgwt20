package com.fkereki.mvptest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public class Presenter<T> {
  View view;
  AsyncCallback<T> callback;

  public Presenter() {
  }

  public Presenter(View aView, AsyncCallback<T> aCallback) {
    view = aView;
    callback = aCallback;
  }

  public View getView() {
    return view;
  }
}
