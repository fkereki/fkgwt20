package com.kereki.ljdemo.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Environment {
	public void calculateAverage(final String s1, final String s2, final String s3, final AsyncCallback<Integer> cb) {
		try {
			int n1= Integer.parseInt(s1);
			int n2= Integer.parseInt(s2);
			int n3= Integer.parseInt(s3);
			int avg= (n1 + n2 + n3) / 3;
			cb.onSuccess(avg);
		}
		catch (Exception e) {
			cb.onFailure(null);
		}
	}

	public void showMessage(final String text) {
		Window.alert(text);
	}
}
