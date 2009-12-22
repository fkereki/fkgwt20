package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService
    extends RemoteService {
  String getSomething(
      String name, String pass);
}