package com.kereki.ljdemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class MainFormPresenter {
	private final Model ownModel;
	private final MainFormView ownView;

	public void onAnyChange() {
		ownView.setResult("--press to calculate--");
	}

	public void onAverageClick() {
		String s1, s2, s3;
		s1= ownView.getFirstText();
		s2= ownView.getSecondText();
		s3= ownView.getThirdText();
		ownModel.calculateAverage(s1, s2, s3,
		        new AsyncCallback<Integer>() {
			        @Override
			        public void onFailure(final Throwable caught) {
				        ownModel
				                .showMessage("Please enter three numbers!");
			        }

			        @Override
			        public void onSuccess(final Integer result) {
				        ownView.setResult("" + result);
			        }
		        });
	};

	public MainFormPresenter(final Model aModel,
	        final MainFormView aView) {

		ownModel= aModel;
		ownView= aView;
		aView.setPresenter(this);
	}
}
