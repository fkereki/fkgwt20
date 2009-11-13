package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginFormView extends View implements
    LoginFormPresenter.PresenterDisplay {

  protected AsyncCallback<Object> loginCallback;
  final protected TextBox nameTextBox = new TextBox();
  final protected TextBox passwordTextBox = new PasswordTextBox();
  final protected Button loginButton = new Button("Log in");
  final protected FlexTable flex = new FlexTable();
  final protected DockPanel dock = new DockPanel();


  public LoginFormView() {
    loginButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        loginCallback.onSuccess(null);
      }
    });

    flex.setWidget(0, 0, new Label("User name:"));
    flex.setWidget(0, 1, nameTextBox);
    flex.setWidget(1, 0, new Label("Password:"));
    flex.setWidget(1, 1, passwordTextBox);
    flex.setWidget(2, 1, loginButton);

    dock.setWidth("100%");
    dock.setHeight("100%");
    dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
    dock.setVerticalAlignment(DockPanel.ALIGN_MIDDLE);
    dock.add(flex, DockPanel.CENTER);

    initWidget(dock);
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


  @Override
  public Widget asWidget() {
    return LoginFormView.this;
  }
}
