package com.fkereki.mvpproject.client.login5;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.Security;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.rpc.LoginServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter
    extends Presenter<LoginFormDisplay> {
  public static String PLACE = "login";

  LoginServiceAsync loginService;

  SimpleCallback<String> loginSuccessCallback;

  public LoginFormPresenter(
      final String params, final LoginFormDisplay loginDisplay,
      final Environment environment,
      final SimpleCallback<String> callback) {

    super(params, loginDisplay, environment);
    loginSuccessCallback = callback;
    loginService = getEnvironment().getModel().getRemoteLoginService();

    final SimpleCallback<Object> commonBlurHandler = new SimpleCallback<Object>() {
      @Override
      public void goBack(final Object result) {
        final String name = LoginFormPresenter.this.getDisplay()
            .getName();
        final String pass = LoginFormPresenter.this.getDisplay()
            .getPassword();
        final boolean canLogin = !name.isEmpty() & !pass.isEmpty();
        LoginFormPresenter.this.getDisplay()
            .enableLoginButton(canLogin);
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
        LoginFormPresenter.this.getDisplay().enableLoginButton(false);

        final String name = LoginFormPresenter.this.getDisplay()
            .getName();
        final String pass = LoginFormPresenter.this.getDisplay()
            .getPassword();
        final String nonce = Security.randomCharString();
        final String hashPassword = LoginFormPresenter.this.md5(pass
            + nonce);

        loginService.getSessionKey(name, nonce, hashPassword,
            new AsyncCallback<String>() {
              public void onFailure(final Throwable caught) {
                LoginFormPresenter.this.getEnvironment().showAlert(
                    "Failed login");

                LoginFormPresenter.this.getDisplay().enableLoginButton(
                    true);
                loginSuccessCallback.onFailure(new Throwable());
              }

              public void onSuccess(final String result) {
                final Security secure = new Security();
                final String sessionKey = secure.codeDecode(pass
                    + nonce, result);

                loginSuccessCallback.goBack(sessionKey);
              }
            });
      }
    });
  }

  /**
   * Calculate the MD5 hash value for a given string.
   * 
   * @param pText
   *          String for hash calculation
   * @return The calculated hash
   */
  private native String md5(String pText)
  /*-{
    return $wnd.hex_md5(pText);
  }-*/;
}
