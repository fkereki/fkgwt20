package com.fkereki.mvptest.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginPresenter extends Presenter<String> {
	public LoginPresenter(LoginView loginView, AsyncCallback<String> callback) {
		super(loginView, callback);

		loginView.setName("federico");
		loginView.setPassword("eduardo");
		loginView.addLoginButtonHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				LoginServiceAsync loginService = GWT.create(LoginService.class);

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
								LoginPresenter.this.callback.onSuccess(result);
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

		public void addLoginButtonHandler(ClickHandler ch);
	}
}
