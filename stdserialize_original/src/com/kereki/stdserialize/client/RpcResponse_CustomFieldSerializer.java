package com.kereki.stdserialize.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class RpcResponse_CustomFieldSerializer {
  public static void deserialize(
      SerializationStreamReader reader, RpcResponse instance)
      throws SerializationException {

    if (instance == null) {
      throw new NullPointerException("Null RpcResponse!");
    } else {
      String dummy= reader.readString();
      instance.aText= reader.readString();
      instance.anotherText= reader.readString();
      instance.aNumber= reader.readFloat();
      instance.aBoolean= reader.readBoolean();
    }
  }

  public static RpcResponse instantiate(
      SerializationStreamReader reader)
      throws SerializationException {
    return new RpcResponse();
  }

  public static void serialize(
      SerializationStreamWriter writer, RpcResponse instance)
      throws SerializationException {

    if (instance == null) {
      throw new NullPointerException("Null RpcResponse!");
    } else {
      writer.writeString("my own serializer!");
      writer.writeString(instance.aText);
      writer.writeString(instance.anotherText);
      writer.writeFloat(instance.aNumber);
      writer.writeBoolean(instance.aBoolean);
    }
  }
}
