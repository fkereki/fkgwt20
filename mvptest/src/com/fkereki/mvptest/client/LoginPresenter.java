package com.fkereki.mvptest.client;

import java.util.Date;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginPresenter extends Presenter {
  LoginServiceAsync loginService;
  SimpleCallback<String> loginSuccessCallback;

  static String PLACE = "login";


  public LoginPresenter(String params,
    PresenterDisplay loginDisplay, Model model,
    SimpleCallback<String> callback) {

    super(params, loginDisplay, model);
    loginSuccessCallback = callback;
    Date xxx1 = new Date();
    loginService = LoginPresenter.this.getModel()
      .getRemoteLoginService();
    Date xxx2 = new Date();
    Window.alert("time... "
      + (xxx2.getTime() - xxx1.getTime()));

    loginDisplay.setName("federico");
    loginDisplay.setPassword("eduardo");
    loginDisplay
      .setLoginCallback(new SimpleCallback<Object>() {
        @Override
        public void goBack(Object result) {
          String name = ((PresenterDisplay) LoginPresenter.this
            .getDisplay()).getName();
          String pass = ((PresenterDisplay) LoginPresenter.this
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
