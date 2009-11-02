package com.fkereki.mvptest.client;

import com.google.gwt.junit.client.GWTTestCase;

public class LoginViewGwtTest extends GWTTestCase {
  boolean wasCalled;

  @Override
  public String getModuleName() {
    return "com.fkereki.mvptest.Mvptest";
  }

  public void testLoginView() {
    LoginView lv = new LoginView();
    lv.setName("unga");
    lv.setPassword("bunga");
    lv.setLoginCallback(new SimpleCallback<Object>() {

      @Override
      public void goBack(Object result) {
        System.out.print("1");
        assertNull(result);
        wasCalled = true;
      }
    });

    assertEquals("unga", lv.getName());
    assertEquals("bunga", lv.getPassword());
    assertEquals(lv, lv.asWidget());

    assertEquals("unga", lv.nameTextBox.getValue());
    assertEquals("bunga", lv.passwordTextBox.getValue());

    lv.nameTextBox.setValue("urk");
    lv.passwordTextBox.setValue("ork");
    assertEquals("urk", lv.getName());
    assertEquals("ork", lv.getPassword());

    assertEquals(lv.loginButton.getText(), "Log in");

    // System.out.print("try callback...");
    // lv.loginCallback.onSuccess(null);
    // assertTrue(wasCalled);

    System.out.print("0");
    lv.loginButton.click();
    System.out.print("2");
    delayTestFinish(1000);
    assertTrue(wasCalled);
  }
}
