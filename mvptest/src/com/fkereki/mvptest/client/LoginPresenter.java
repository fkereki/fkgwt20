package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;

public class LoginPresenter extends Presenter<String> {

  public LoginPresenter(LoginView loginView,
    AsyncCallback<String> callback) {
    super(loginView, callback);
    loginView.getLoginButton().addClickHandler(
      new LoginClickHandler(loginView, callback));
  }

  private class LoginClickHandler implements ClickHandler {
    LoginView myView;
    AsyncCallback<String> myCallback;

    public LoginClickHandler(LoginView aView,
      AsyncCallback<String> aCallback) {
      myView = aView;
      myCallback = aCallback;
    }

    public void onClick(ClickEvent event) {
      String name = myView.getNameField().getValue();
      if (name.isEmpty()) {
        myCallback.onFailure(new Throwable());
      } else {
        myCallback.onSuccess(myView.getNameField()
          .getValue());
      }
    }
  }

  public interface Display {
    public HasValue<String> getNameField();

    public HasValue<String> getPasswordField();

    public HasClickHandlers getLoginButton();
  }
}
