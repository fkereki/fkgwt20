package com.fkereki.mvptest.client;

import com.google.gwt.core.client.GWT;

public class HelloBrowser {

  public void salute() {
    HelloBrowserStdImpl testImpl = GWT
      .create(HelloBrowserStdImpl.class);
    testImpl.sayHello();
  }
}
