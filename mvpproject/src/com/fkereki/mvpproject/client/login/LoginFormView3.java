package com.fkereki.mvpproject.client.login;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Defines a Login Form.
 */
public class LoginFormView3 extends View implements LoginFormDisplay2 {
  @UiTemplate("LoginFormView3.ui.xml")
  interface Binder extends UiBinder<HTMLPanel, LoginFormView3> {
  }

  AsyncCallback<Object> loginCallback;
  AsyncCallback<Object> nameBlurCallback;
  AsyncCallback<Object> passwordBlurCallback;

  @UiField
  TextBox nameTextBox;
  @UiField
  PasswordTextBox passwordTextBox;
  @UiField
  Button loginButton;

  private static final Binder binder = GWT.create(Binder.class);

  public LoginFormView3() {
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }

  @Override
  public final Widget asWidget() {
    return LoginFormView3.this;
  }

  @Override
  public void enableLoginButton(final boolean b) {
    loginButton.setEnabled(b);
  }

  @Override
  public final String getName() {
    return nameTextBox.getValue();
  }

  @Override
  public final String getPassword() {
    return passwordTextBox.getValue();
  }

  @Override
  public final void setLoginCallback(final SimpleCallback<Object> acb) {
    loginCallback = acb;
  }

  @Override
  public final void setName(final String s) {
    nameTextBox.setValue(s);
  }

  @Override
  public void setNameBlurCallback(final SimpleCallback<Object> acb) {
    nameBlurCallback = acb;
  }

  @Override
  public final void setPassword(final String s) {
    passwordTextBox.setValue(s);
  }

  @Override
  public void setPasswordBlurCallback(final SimpleCallback<Object> acb) {
    passwordBlurCallback = acb;
  }

  @UiHandler("nameTextBox")
  void uiOnBlurName(BlurEvent event) {
    nameBlurCallback.onSuccess(null);
  }

  @UiHandler("passwordTextBox")
  void uiOnBlurPassword(BlurEvent event) {
    passwordBlurCallback.onSuccess(null);
  }

  @UiHandler("loginButton")
  void uiOnLoginButton(ClickEvent event) {
    loginCallback.onSuccess(null);
  }
}
