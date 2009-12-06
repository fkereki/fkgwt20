package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.Window;
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
                Window.alert("failure");
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
    /**
     * Access the Name field
     * 
     * @return Whatever the user entered in the Name field
     */
    String getName();


    /**
     * Initialize the Name field
     * 
     * @param s
     *          Set the name field to s; most commonly just
     *          "" or possibly a saved name from an earlier
     *          session.
     */
    void setName(String s);


    /**
     * Access the Password field
     * 
     * @return Whatever the user entered in the Password
     *         field
     */
    String getPassword();


    /**
     * Initialize the Password field
     * 
     * @param s
     *          Set the password field to s; usually just ""
     */
    void setPassword(String s);


    /**
     * Initialize the login callback, which shall be
     * executed when the user clicks the "Login" button
     * 
     * @param acb
     *          Set the login callback to acb. The Presenter
     *          will have to get the Name and Password
     *          fields (by using the methods above) and
     *          perform the needed checks.
     */
    void setLoginCallback(SimpleCallback<Object> acb);
  }
}
