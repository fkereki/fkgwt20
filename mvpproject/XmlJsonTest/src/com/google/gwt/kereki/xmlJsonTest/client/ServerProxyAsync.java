package com.google.gwt.kereki.xmlJsonTest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServerProxyAsync {

    void getFromRemoteServer(
        final String serviceUrl,
        AsyncCallback<String> callback);

    void postToRemoteServer(
        final String serviceUrl,
        AsyncCallback<String> callback);
}
