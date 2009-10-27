package com.fkereki.mvptest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginPresenter extends Presenter<String> {
	public LoginServiceAsync loginService;

	public LoginPresenter(LoginView loginView, Model model,
			SimpleCallback<String> callback) {

		super(loginView, model, callback);
		loginService = LoginPresenter.this.model.getRemoteLoginService();

		loginView.setName("federico");
		loginView.setPassword("eduardo");
		loginView.setLoginCallback(new SimpleCallback<Object>() {
			@Override
			public void goBack(Object result) {
				String name = ((LoginView) LoginPresenter.this.view).getName();
				String pass = ((LoginView) LoginPresenter.this.view)
						.getPassword();

				loginService.getSomething(name, pass,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								LoginPresenter.this.callback
										.onFailure(new Throwable());
							}

							public void onSuccess(String result) {
								LoginPresenter.this.callback.goBack(result);
							}
						});
			}
		});
	}

	public interface Display {
		public String getName();

		public void setName(String s);

		public String getPassword();

		public void setPassword(String s);

		public void setLoginCallback(SimpleCallback<Object> acb);
	}
}
