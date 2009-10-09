package com.fkereki.mvptest.server;

import com.fkereki.mvptest.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet
        implements GreetingService {

    public String greetServer(String input) {
        String serverInfo = getServletContext().getServerInfo();
        String userAgent = getThreadLocalRequest().getHeader(
            "User-Agent");
        return "Hello, " + input + "!<br><br>I am running "
            + serverInfo
            + ".<br><br>It looks NOW like you are using:<br>"
            + userAgent;
    }
}
