package com.kereki.security.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
  void calcMD5(String pString, AsyncCallback<String> callback);

  void getValueForKey(String pKey, AsyncCallback<String> callback);

  void storePair(String pKey, String pName, AsyncCallback<Void> callback);
}
