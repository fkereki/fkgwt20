package com.kereki.ljdemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class FormPresenter {
	private final Model ownModel;
	private final FormView ownView;

	public void onAnyChange() {
		ownView.setResult("--press to calculate--");
	}

	public void onAverageClick() {
		String s1= ownView.getFirstText();
		String s2= ownView.getSecondText();
		String s3= ownView.getThirdText();

		ownModel.calculateAverage(s1, s2, s3, new AsyncCallback<Integer>() {
			@Override
			public void onFailure(final Throwable caught) {
				ownModel.showMessage("Please enter three numbers!");
			}

			@Override
			public void onSuccess(final Integer result) {
				ownView.setResult("" + result);
			}
		});
	};

	public FormPresenter(final Model aModel, final FormView aView) {

		ownModel= aModel;
		ownView= aView;
		aView.setPresenter(this);
	}
}
