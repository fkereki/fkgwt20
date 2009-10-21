package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class LoginView extends View implements
    LoginPresenter.Display {

  TextBox nameTextBox;
  TextBox passwordTextBox;
  Button loginButton;
  FlexTable flexTable;

  public LoginView() {
    flexTable = new FlexTable();
    nameTextBox = new TextBox();
    passwordTextBox = new PasswordTextBox();
    loginButton = new Button("Log in");

    flexTable.setWidget(0, 0, new Label("User name:"));
    flexTable.setWidget(0, 1, nameTextBox);
    flexTable.setWidget(1, 0, new Label("Password:"));
    flexTable.setWidget(1, 1, passwordTextBox);
    flexTable.setWidget(2, 1, loginButton);

    initWidget(flexTable);
  }

  @Override
  public HasValue<String> getNameField() {
    return nameTextBox;
  }

  @Override
  public HasValue<String> getPasswordField() {
    return passwordTextBox;
  }

  @Override
  public HasClickHandlers getLoginButton() {
    return loginButton;
  }
}
