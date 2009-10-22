package com.fkereki.mvptest.client;

import com.google.gwt.core.client.GWT;
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

        @Override
        public void onClick(ClickEvent event) {
          LoginServiceAsync loginService = GWT
            .create(LoginService.class);

          String name = ((LoginView) LoginPresenter.this.view)
            .getNameField().getValue();
          String pass = ((LoginView) LoginPresenter.this.view)
            .getPasswordField().getValue();

          loginService.getSomething(name, pass,
            new AsyncCallback<String>() {

              @Override
              public void onFailure(Throwable caught) {
                LoginPresenter.this.callback
                  .onFailure(new Throwable());
              }

              @Override
              public void onSuccess(String result) {
                LoginPresenter.this.callback
                  .onSuccess(result);
              }
            });
        }
      });
  }

  public interface Display {
    public HasValue<String> getNameField();

    public HasValue<String> getPasswordField();

    public HasClickHandlers getLoginButton();
  }
}
