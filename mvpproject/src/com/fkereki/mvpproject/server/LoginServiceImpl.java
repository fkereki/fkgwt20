package com.fkereki.mvpproject.server;

import com.fkereki.mvpproject.client.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet
    implements LoginService {

  public String getSomething(String name, String pass) {
    return name + " " + pass;
  }
}
