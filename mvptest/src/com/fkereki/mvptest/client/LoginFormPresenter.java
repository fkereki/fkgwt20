package com.fkereki.mvptest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormPresenter extends Presenter {
  static String PLACE = "login";

  LoginServiceAsync loginService;
  SimpleCallback<String> loginSuccessCallback;


  public LoginFormPresenter(String params,
    PresenterDisplay loginDisplay, Environment environment,
    SimpleCallback<String> callback) {

    super(params, loginDisplay, environment);

    loginSuccessCallback = callback;
    loginService = LoginFormPresenter.this.getEnvironment()
      .getModel().getRemoteLoginService();

    loginDisplay.setName("federico");
    loginDisplay.setPassword("eduardo");
    loginDisplay
      .setLoginCallback(new SimpleCallback<Object>() {
        @Override
        public void goBack(Object result) {
          String name = ((PresenterDisplay) LoginFormPresenter.this
            .getDisplay()).getName();
          String pass = ((PresenterDisplay) LoginFormPresenter.this
            .getDisplay()).getPassword();

          loginService.getSomething(name, pass,
            new AsyncCallback<String>() {
              public void onFailure(Throwable caught) {
                loginSuccessCallback
                  .onFailure(new Throwable());
              }


              public void onSuccess(String result) {
                loginSuccessCallback.goBack(result);
              }
            });
        }
      });
  }


  public interface PresenterDisplay extends Display {
    public String getName();


    public void setName(String s);


    public String getPassword();


    public void setPassword(String s);


    public void setLoginCallback(SimpleCallback<Object> acb);
  }
}
