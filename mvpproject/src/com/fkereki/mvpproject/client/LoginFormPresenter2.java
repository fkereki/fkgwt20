package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter2 extends Presenter<LoginFormDisplay2> {
  static String PLACE = "login";

  LoginServiceAsync loginService;
  SimpleCallback<String> loginSuccessCallback;


  public LoginFormPresenter2(final String params, final LoginFormDisplay2 loginDisplay,
    final Environment environment, final SimpleCallback<String> callback) {

    super(params, loginDisplay, environment);
    loginSuccessCallback = callback;
    loginService = getEnvironment().getModel().getRemoteLoginService();

    final SimpleCallback<Object> commonBlurHandler = new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        final String name = LoginFormPresenter2.this.getDisplay().getName();
        final String pass = LoginFormPresenter2.this.getDisplay().getPassword();
        final boolean canLogin = !(name.isEmpty()) & !(pass.isEmpty());
        (LoginFormPresenter2.this.getDisplay()).enableLoginButton(canLogin);
      }
    };
    loginDisplay.setNameBlurCallback(commonBlurHandler);
    loginDisplay.setPasswordBlurCallback(commonBlurHandler);

    loginDisplay.setName("federico");
    loginDisplay.setPassword("");
    commonBlurHandler.goBack(null);

    loginDisplay.setLoginCallback(new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        final String name = LoginFormPresenter2.this.getDisplay().getName();
        final String pass = LoginFormPresenter2.this.getDisplay().getPassword();

        LoginFormPresenter2.this.getDisplay().enableLoginButton(false);

        loginService.getSomething(name, pass, new AsyncCallback<String>() {
          public void onFailure(final Throwable caught) {
            LoginFormPresenter2.this.getEnvironment().showAlert("Failed login");

            LoginFormPresenter2.this.getDisplay().enableLoginButton(true);
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
