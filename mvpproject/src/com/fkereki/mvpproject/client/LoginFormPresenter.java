package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter extends Presenter<LoginFormDisplay> {
  static String PLACE = "login";

  LoginServiceAsync loginService;
  SimpleCallback<String> loginSuccessCallback;


  public LoginFormPresenter(final String params, final LoginFormDisplay loginDisplay,
    final Environment environment, final SimpleCallback<String> callback) {

    super(params, loginDisplay, environment);
    loginSuccessCallback = callback;
    loginService = getEnvironment().getModel().getRemoteLoginService();

    loginDisplay.setName("federico");
    loginDisplay.setPassword("");
    loginDisplay.setLoginCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        final String name = LoginFormPresenter.this.getDisplay().getName();
        final String pass = LoginFormPresenter.this.getDisplay().getPassword();

        loginService.getSomething(name, pass, new AsyncCallback<String>() {
          public void onFailure(final Throwable caught) {
            LoginFormPresenter.this.getEnvironment().showAlert("Failed login");
            loginSuccessCallback.onFailure(new Throwable());
          }


          public void onSuccess(final String result) {
            loginSuccessCallback.goBack(result);
          }
        });
      }
    });
  }
}
