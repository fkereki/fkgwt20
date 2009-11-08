package com.fkereki.mvptest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginServiceAsync {
  void getSomething(String name, String pass,
    AsyncCallback<String> callback);
}