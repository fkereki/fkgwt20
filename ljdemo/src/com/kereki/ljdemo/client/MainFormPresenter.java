package com.kereki.ljdemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class MainFormPresenter {
	private final Environment ownEnvironment;
	private final MainFormView ownView;

	public interface ViewInterface {
		String getFirstText();

		String getSecondText();

		String getThirdText();

		void setResult(int aValue);

		void setPresenter(MainFormPresenter aPresenter);
	}

	public void onAverageClick() {
		String s1, s2, s3;
		s1= ownView.getFirstText();
		s2= ownView.getSecondText();
		s3= ownView.getThirdText();
		ownEnvironment.calculateAverage(s1, s2, s3,
		        new AsyncCallback<Integer>() {
			        @Override
			        public void onFailure(final Throwable caught) {
				        ownEnvironment
				                .showMessage("Please enter three numbers!");
			        }

			        @Override
			        public void onSuccess(final Integer result) {
				        ownView.setResult(result);
			        }
		        });
	};

	public MainFormPresenter(final Environment anEnvironment,
	        final MainFormView aView) {
		super();
		this.ownEnvironment= anEnvironment;
		this.ownView= aView;
		aView.setPresenter(this);
	}
}
