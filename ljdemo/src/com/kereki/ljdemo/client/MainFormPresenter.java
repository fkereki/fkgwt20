package com.kereki.ljdemo.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MainFormPresenter {
	private final Environment ownEnvironment;
	private final MainFormView ownView;

	public interface ViewInterface {
		int getFirstNumber();

		int getSecondNumber();

		int getThirdNumber();

		void setPresenter(MainFormPresenter aPresenter);
	}

	public void onAverageClick() {
		int n1, n2, n3;
		n1= ownView.getFirstNumber();
		n2= ownView.getSecondNumber();
		n3= ownView.getThirdNumber();
		ownEnvironment.calculateAverage(n1, n2, n3, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(final Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(final Integer result) {
				Window.alert("Exito " + result);
			}
		});
	};

	public MainFormPresenter(final Environment anEnvironment, final MainFormView aView) {
		super();
		this.ownEnvironment= anEnvironment;
		this.ownView= aView;
		aView.setPresenter(this);
	}
}
