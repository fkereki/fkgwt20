package com.fkereki.mvpproject.client;

public class DtoUserPassKey {
  public String user;
  public String pass;
  public String key;

  public DtoUserPassKey() {
  }

  public DtoUserPassKey(final String u, final String p, final String k) {
    user = u;
    pass = p;
    key = k;
  }
}
