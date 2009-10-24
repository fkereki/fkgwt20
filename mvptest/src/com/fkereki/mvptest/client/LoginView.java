package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class LoginView extends
    com.fkereki.mvptest.client.View implements
    LoginPresenter.Display {
  AsyncCallback<Object> loginCallback;
  TextBox nameTextBox;
  TextBox passwordTextBox;
  Button loginButton;
  FlexTable flexTable;

  public LoginView() {
    flexTable = new FlexTable();
    nameTextBox = new TextBox();
    passwordTextBox = new PasswordTextBox();

    loginButton = new Button("Log in");
    loginButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        loginCallback.onSuccess(null);
      }
    });

    flexTable.setWidget(0, 0, new Label("User name:"));
    flexTable.setWidget(0, 1, nameTextBox);
    flexTable.setWidget(1, 0, new Label("Password:"));
    flexTable.setWidget(1, 1, passwordTextBox);
    flexTable.setWidget(2, 1, loginButton);

    initWidget(flexTable);
  }

  @Override
  public String getName() {
    return nameTextBox.getValue();
  }

  @Override
  public String getPassword() {
    return passwordTextBox.getValue();
  }

  @Override
  public void setName(String s) {
    nameTextBox.setValue(s);
  }

  @Override
  public void setPassword(String s) {
    passwordTextBox.setValue(s);
  }

  @Override
  public void setLoginCallback(SimpleCallback<Object> acb) {
    loginCallback = acb;
  }
}
