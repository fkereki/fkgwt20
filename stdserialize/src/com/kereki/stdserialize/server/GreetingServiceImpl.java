package com.kereki.stdserialize.server;

import com.google.gwt.rpc.server.RpcServlet;
import com.kereki.stdserialize.client.GreetingService;
import com.kereki.stdserialize.client.RpcResponse;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl
    extends RpcServlet
    implements GreetingService {

  public RpcResponse greetServer(
      String input) {
    String serverInfo= getServletContext().getServerInfo();
    String userAgent= getThreadLocalRequest().getHeader(
        "User-Agent");

    RpcResponse answer= new RpcResponse();
    answer.aText= "Hello, " + input + "!<br><br>I am running "
        + serverInfo + ".";
    answer.anotherText= "It looks like you are using:<br>"
        + userAgent;
    answer.aNumber= 220960;
    answer.aBoolean= true;

    return answer;
  }
}
