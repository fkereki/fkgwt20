package com.kereki.ljdemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EnvironmentInterface {
	public void calculateAverage(final String s1, final String s2,
	        final String s3, final AsyncCallback<Integer> cb);

	public void showMessage(final String text);
}
