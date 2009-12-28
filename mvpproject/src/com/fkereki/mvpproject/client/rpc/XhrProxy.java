package com.fkereki.mvpproject.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("xhrproxy")
public interface XhrProxy
    extends RemoteService {
  public String getFromUrl(final String originalUrl);
}
