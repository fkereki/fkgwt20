package com.kereki.ljdemo.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Environment implements EnvironmentInterface {
	@Override
	public void calculateAverage(final String s1, final String s2,
	        final String s3, final AsyncCallback<Integer> cb) {

		final RequestBuilder rb= new RequestBuilder(RequestBuilder.GET,
		        "http://127.0.0.1/average3ws.php?first=" + s1 + "&second=" + s2
		                + "&third=" + s3);

		try {
			rb.sendRequest(null, new RequestCallback() {

				@Override
				public void onResponseReceived(final Request request,
				        final Response response) {

					/*
					 * Successful return? If so, send the result back;
					 * otherwise, it's a failure.
					 */
					if (response.getStatusCode() == 200) {
						cb.onSuccess(Integer.parseInt(response.getText()));
					} else {
						cb.onFailure(new Throwable(response.getStatusText()));
					}
				}

				@Override
				public void onError(final Request request,
				        final Throwable exception) {
					cb.onFailure(exception);
				}
			});
		}
		catch (Exception e) {
			cb.onFailure(e);
		}
	}

	@Override
	public void showMessage(final String text) {
		Window.alert(text);
	}
}
