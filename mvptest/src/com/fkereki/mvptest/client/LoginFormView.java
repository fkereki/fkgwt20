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

/**
 * Defines a Login Form.
 */
public class LoginFormView extends View implements
    LoginFormPresenter.PresenterDisplay {

  protected AsyncCallback<Object> loginCallback;
  protected final TextBox nameTextBox = new TextBox();
  protected final TextBox passwordTextBox = new PasswordTextBox();
  protected final Button loginButton = new Button("Log in");
  protected final FlexTable flex = new FlexTable();
  protected final DockPanel dock = new DockPanel();


  /**
   * Defines the view for the Login Form. Since this will be
   * shown in the main screen, we take care of centering the
   * fields (by using a DockPanel) so it will look nicer.
   */
  public LoginFormView() {
    loginButton.addClickHandler(new ClickHandler() {
      public void onClick(final ClickEvent event) {
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
  public final String getName() {
    return nameTextBox.getValue();
  }


  @Override
  public final String getPassword() {
    return passwordTextBox.getValue();
  }


  @Override
  public final void setName(final String s) {
    nameTextBox.setValue(s);
  }


  @Override
  public final void setPassword(final String s) {
    passwordTextBox.setValue(s);
  }


  @Override
  public final void setLoginCallback(
    final SimpleCallback<Object> acb) {
    loginCallback = acb;
  }


  @Override
  public final Widget asWidget() {
    return LoginFormView.this;
  }
}
