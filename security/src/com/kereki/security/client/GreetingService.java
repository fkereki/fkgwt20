package com.kereki.security.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService
    extends RemoteService {
  String calcMD5(String pString);

  String getValueForKey(String pKey);

  void storePair(String pKey, String pName);
}