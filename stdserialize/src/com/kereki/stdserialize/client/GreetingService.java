package com.kereki.stdserialize.client;

import com.google.gwt.rpc.client.RpcService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService
    extends RpcService {
  RpcResponse greetServer(
      String name);
}
