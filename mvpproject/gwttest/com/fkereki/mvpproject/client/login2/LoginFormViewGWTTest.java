package com.fkereki.mvpproject.client.login2;

import org.junit.Test;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.junit.client.GWTTestCase;

public class LoginFormViewGWTTest
    extends GWTTestCase {

  boolean loginWasCalled;
  boolean blurWasCalled;

  @Override
  public String getModuleName() {
    return "com.fkereki.mvpproject.Mvpproject";
  }

  @Test
  public void testLoginView() {
    final LoginFormView lv = new LoginFormView();

    final SimpleCallback<Object> blurCB = new SimpleCallback<Object>() {

      @Override
      public void goBack(final Object result) {
        blurWasCalled = true;
      }
    };

    lv.setNameBlurCallback(blurCB);
    lv.setPasswordBlurCallback(blurCB);

    lv.setLoginCallback(new SimpleCallback<Object>() {

      @Override
      public void goBack(final Object result) {
        loginWasCalled = true;
      }
    });

    lv.nameTextBox.setValue("urk");
    lv.passwordTextBox.setValue("ork");
    assertEquals("urk", lv.getName());
    assertEquals("ork", lv.getPassword());

    lv.setName("federico");
    lv.setPassword("");
    assertEquals("federico", lv.getName());
    assertEquals("", lv.getPassword());

    /*
     * Let's test the blur handlers
     */
    final Document doc = com.google.gwt.dom.client.Document.get();
    final NativeEvent evt1 = doc.createBlurEvent();
    DomEvent.fireNativeEvent(evt1, lv.nameTextBox);
    assertTrue(blurWasCalled);

    blurWasCalled = false;
    DomEvent.fireNativeEvent(evt1, lv.passwordTextBox);
    assertTrue(blurWasCalled);

    /*
     * Let's test whether the click handler is wired right
     */
    final NativeEvent evt2 = doc.createClickEvent(0, 0, 0, 0, 0, false,
        false, false, false);
    DomEvent.fireNativeEvent(evt2, lv.loginButton);
    assertTrue(loginWasCalled);
  }
}
