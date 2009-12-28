package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface XhrProxyAsync {

  void getFromUrl(String originalUrl, AsyncCallback<String> callback);

}
