package com.fkereki.mvptest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginPresenter extends Presenter {
	LoginServiceAsync loginService;
	SimpleCallback<String> loginSuccessCallback;

	static String PLACE = "login";



	public LoginPresenter(PresenterDisplay loginDisplay,
	    Model model, SimpleCallback<String> callback) {

		super(loginDisplay, model);
		loginSuccessCallback = callback;
		loginService = LoginPresenter.this.getModel()
		    .getRemoteLoginService();

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
