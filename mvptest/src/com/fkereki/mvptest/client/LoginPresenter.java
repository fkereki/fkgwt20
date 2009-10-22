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
      new ClickHandler() {
        public void onClick(ClickEvent event) {
          String name = ((LoginView) LoginPresenter.this.view)
            .getNameField().getValue();
          if (name.isEmpty()) {
            LoginPresenter.this.callback
              .onFailure(new Throwable());
          } else {
            LoginPresenter.this.callback.onSuccess(name);
          }
        }
      });
  }

  public interface Display {
    public HasValue<String> getNameField();

    public HasValue<String> getPasswordField();

    public HasClickHandlers getLoginButton();
  }
}
