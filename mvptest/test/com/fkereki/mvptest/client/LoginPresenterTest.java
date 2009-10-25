package com.fkereki.mvptest.client;


import static org.easymock.classextension.EasyMock.createMock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginPresenterTest {

  private LoginView loginViewMock;
  private LoginPresenter loginPresenter;

  @Before
  public void setUp() throws Exception {
    loginViewMock = createMock(LoginView.class);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testLoginPresenter1() {
    loginViewMock.setName("federico");
    loginViewMock.setPassword("eduardo");
    loginPresenter = new LoginPresenter(loginViewMock, null);
  }
}
