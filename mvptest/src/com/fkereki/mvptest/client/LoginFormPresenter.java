package com.fkereki.mvptest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter extends Presenter {
  static String PLACE = "login";

  LoginServiceAsync loginService;
  SimpleCallback<String> loginSuccessCallback;


  public LoginFormPresenter(final String params,
    final PresenterDisplay loginDisplay,
    final Environment environment,
    final SimpleCallback<String> callback) {

    super(params, loginDisplay, environment);

    loginSuccessCallback = callback;
    loginService = LoginFormPresenter.this.getEnvironment()
      .getModel().getRemoteLoginService();

    loginDisplay.setName("federico");
    loginDisplay.setPassword("eduardo");
    loginDisplay
      .setLoginCallback(new SimpleCallback<Object>() {
        @Override
        public void goBack(final Object result) {
          String name = ((PresenterDisplay) LoginFormPresenter.this
            .getDisplay()).getName();
          String pass = ((PresenterDisplay) LoginFormPresenter.this
            .getDisplay()).getPassword();

          loginService.getSomething(name, pass,
            new AsyncCallback<String>() {
              public void onFailure(final Throwable caught) {
                loginSuccessCallback
                  .onFailure(new Throwable());
              }


              public void onSuccess(final String result) {
                loginSuccessCallback.goBack(result);
              }
            });
        }
      });
  }


  interface PresenterDisplay extends Display {
    String getName();


    void setName(String s);


    String getPassword();


    void setPassword(String s);


    void setLoginCallback(SimpleCallback<Object> acb);
  }
}
