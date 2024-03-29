package com.fkereki.mvptest.client;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.junit.Assert.assertTrue;

import org.easymock.Capture;
import org.easymock.classextension.EasyMock;
import org.junit.Test;

import com.google.gwt.junit.GWTMockUtilities;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginPresenterTest {

  @Test
  public void testLoginPresenter1() {
    GWTMockUtilities.disarm();
    Environment environmentMock = createMock(Environment.class);

    Model modelMock = createMock(Model.class);
    LoginFormPresenter.PresenterDisplay loginViewMock = createMock(LoginFormPresenter.PresenterDisplay.class);
    LoginServiceAsync loginServiceMock = new LoginServiceAsync() {
      @Override
      public void getSomething(String name, String pass,
        AsyncCallback<String> callback) {
        System.out.print("name=" + name + " pass=" + pass);
      }
    };

    /*
     * The following calls are to be expected... We need
     * capture the callback for later using it.
     */
    loginViewMock.setName("federico");
    loginViewMock.setPassword("eduardo");
    Capture<SimpleCallback<Object>> callbackCapture = new Capture<SimpleCallback<Object>>();
    loginViewMock.setLoginCallback(EasyMock
      .capture(callbackCapture));
    expect(loginViewMock.getName()).andReturn("federico");
    expect(loginViewMock.getPassword())
      .andReturn("eduardo");

    expect(environmentMock.getModel()).andReturn(modelMock);

    expect(modelMock.getRemoteLoginService()).andReturn(
      loginServiceMock);


    SimpleCallback<String> callbackMock = new SimpleCallback<String>() {
      @Override
      public void goBack(String result) {
        System.out.print("result " + result);
      }
    };

    assertTrue(modelMock != null);
    assertTrue(loginViewMock != null);
    assertTrue(loginServiceMock != null);

    EasyMock.replay(modelMock);
    EasyMock.replay(loginViewMock);
    EasyMock.replay(environmentMock);

    LoginFormPresenter lp = new LoginFormPresenter("",
      loginViewMock, environmentMock, callbackMock);

    assertTrue(callbackCapture.getValue() != null);
    assertTrue(lp.loginService != null);
    assertTrue(lp.loginService == loginServiceMock);

    callbackCapture.getValue().goBack("");
    GWTMockUtilities.restore();
  }
}
