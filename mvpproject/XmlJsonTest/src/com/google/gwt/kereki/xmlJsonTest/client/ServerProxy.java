package com.google.gwt.kereki.xmlJsonTest.client;

import com.google.gwt.kereki.xmlJsonTest.shared.ServerProxyException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("serverproxy")
public interface ServerProxy extends RemoteService {

    public String getFromRemoteServer(final String serviceUrl)
        throws ServerProxyException;

    public String postToRemoteServer(final String serviceUrl)
        throws ServerProxyException;
}
