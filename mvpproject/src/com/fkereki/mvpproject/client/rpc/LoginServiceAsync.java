package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginServiceAsync {
  void getSessionKey(
      String name,
      String nonce,
      String passHash,
      AsyncCallback<String> callback);

  void getSomething(
      String name,
      String pass,
      AsyncCallback<String> callback);
}