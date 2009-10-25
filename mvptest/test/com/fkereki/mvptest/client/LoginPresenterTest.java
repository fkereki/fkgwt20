package com.fkereki.mvptest.client;


import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertTrue;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gwt.junit.GWTMockUtilities;

public class LoginPresenterTest {

  private LoginView loginViewMock;

  // private LoginPresenter loginPresenter;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testLoginPresenter1() {
    GWTMockUtilities.disarm();
    loginViewMock = createMock(LoginView.class);
    GWTMockUtilities.restore();

    assertTrue(loginViewMock != null);

    loginViewMock.setName("federico");
    loginViewMock.setPassword("eduardo");

    Capture<SimpleCallback<Object>> callbackCapture = new Capture<SimpleCallback<Object>>();
    loginViewMock.setLoginCallback(EasyMock
      .capture(callbackCapture));

    expect(loginViewMock.getName()).andReturn("federico");
    expect(loginViewMock.getPassword())
      .andReturn("eduardo");
    replay(loginViewMock);

    GWTMockUtilities.disarm();
    LoginPresenter lp = new LoginPresenter(loginViewMock,
      null);
    GWTMockUtilities.restore();

    callbackCapture.getValue().goBack("");
  }
}
