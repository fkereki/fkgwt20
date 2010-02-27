package com.fkereki.mvpproject.client.login2;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easymock.Capture;
import org.easymock.classextension.EasyMock;
import org.junit.Test;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Model;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.dtos.SessionKeyServiceReturnDto;
import com.fkereki.mvpproject.client.rpc.LoginServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter2Test {
  boolean didReturn = false;
  boolean wasCalled = false;
  String calledName = "";
  String calledPass = "";

  @Test
  public void testLoginPresenter1() {
    // GWTMockUtilities.disarm();
    // GWTMockUtilities.restore();

    final Environment environmentMock = createMock(Environment.class);

    final Model modelMock = createMock(Model.class);
    final LoginFormDisplay loginViewMock = createMock(LoginFormDisplay.class);
    final LoginServiceAsync loginServiceMock = new LoginServiceAsync() {
      @Override
      public void changePassword(
          final String name,
          final String encryptedNewPassword,
          final String nonce,
          final String parametersHash,
          final AsyncCallback<Void> callback) {

        // fail(); // this shouldn't be called!
      }

      @Override
      public void getSessionKey(
          final String name,
          final String nonce,
          final String passHash,
          final AsyncCallback<SessionKeyServiceReturnDto> callback) {

        // fail(); // this shouldn't be called!
      }

      @Override
      public void getSomething(
          final String name,
          final String pass,
          final AsyncCallback<String> callback) {

        if (wasCalled) {
          // fail();
        } else {
          wasCalled = true;
          calledName = name;
          calledPass = pass;
        }
      }
    };

    expect(environmentMock.getModel()).andReturn(modelMock);
    expect(modelMock.getRemoteLoginService()).andReturn(
        loginServiceMock);

    /*
     * The following calls are to be expected... We need capture the callback
     * for later using it.
     */
    final Capture<SimpleCallback<Object>> nameBlurCapture = new Capture<SimpleCallback<Object>>();
    final Capture<SimpleCallback<Object>> passwordBlurCapture = new Capture<SimpleCallback<Object>>();
    final Capture<SimpleCallback<Object>> callbackCapture = new Capture<SimpleCallback<Object>>();

    loginViewMock
        .setNameBlurCallback(EasyMock.capture(nameBlurCapture));
    loginViewMock.setPasswordBlurCallback(EasyMock
        .capture(passwordBlurCapture));
    loginViewMock.setPassword("");
    loginViewMock.setName("federico");
    expect(loginViewMock.getName()).andReturn("federico");
    expect(loginViewMock.getPassword()).andReturn("");
    loginViewMock.enableLoginButton(false);
    loginViewMock.setLoginCallback(EasyMock.capture(callbackCapture));

    final SimpleCallback<String> callbackMock = new SimpleCallback<String>() {
      @Override
      public void goBack(final String result) {
        assertFalse(didReturn);
        didReturn = true;
      }
    };

    /*
     * We'll simulate a blur
     */
    expect(loginViewMock.getName()).andReturn("federico");
    expect(loginViewMock.getPassword()).andReturn("eduardo");
    loginViewMock.enableLoginButton(true);

    EasyMock.replay(modelMock);
    EasyMock.replay(loginViewMock);
    EasyMock.replay(environmentMock);

    final LoginFormPresenter lp = new LoginFormPresenter("",
        loginViewMock, environmentMock, callbackMock);

    assertTrue(callbackCapture.getValue() != null);
    assertTrue(lp.loginService != null);
    assertTrue(lp.loginService == loginServiceMock);

    /*
     * Now let's simulate the password changes, so the blur is called
     */
    passwordBlurCapture.getValue().goBack(null);

    /*
     * And now, a click on the login button
     */
    callbackCapture.getValue().goBack(null);

    assertTrue(didReturn);
    assertTrue(wasCalled);
    assertEquals(calledName, "federico");
    assertEquals(calledPass, "eduardo");
  }
}
