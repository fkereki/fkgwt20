package com.kereki.ljdemo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class Environment {
	public int calculateAverage(final int n1, final int n2, final int n3, final AsyncCallback<Integer> cb) {
		int avg= (n1 + n2 + n3) / 3;
		return avg;
	}
}
