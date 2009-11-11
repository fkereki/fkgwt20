package com.fkereki.mvptest.client;

import com.google.gwt.user.client.Window;

public class HelloBrowserIEImpl extends HelloBrowserStdImpl {
  @Override
  public void sayHello() {
    Window.alert("Special IE hello");
  }
}
