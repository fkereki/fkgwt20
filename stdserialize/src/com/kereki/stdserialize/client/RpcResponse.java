package com.kereki.stdserialize.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RpcResponse
    implements IsSerializable {
  public String aText;
  public String anotherText;
  public float aNumber;
  public boolean aBoolean;
}
