package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;

public class LoginPresenter extends Presenter {

  public LoginPresenter(LoginView loginView) {
    super(loginView);
  }

  public interface Display {
    public HasValue<String> getNameField();

    public HasValue<String> getPasswordField();

    public HasClickHandlers getLoginButton();
  }
}
