package com.kereki.security.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Security
    implements EntryPoint {

  private final GreetingServiceAsync gs = GWT
      .create(GreetingService.class);

  public void onModuleLoad() {
    Window.alert(RC4Java.randomCharString());

    final String key = RC4Java
        .hexStringToByteString("0123456789abcdef");
    final String input = "FEDERICO KEREKI";

    final RC4Java rc4 = new RC4Java();

    rc4.setUp(key);
    final String outputx = rc4.codeDecode("FEDERICO");
    final String outputy = rc4.codeDecode(" ");
    final String outputz = rc4.codeDecode("KEREKI");
    final String output = outputx + outputy + outputz;
    final String decoded = rc4.codeDecode(key, output);
    Window.alert("input=" + input + "\ncoded="
        + RC4Java.byteStringToHexString(output) + "\ndecoded="
        + decoded);

    final String key1 = RC4Java
        .hexStringToByteString("0123456789abcdef");
    final String input1 = RC4Java
        .hexStringToByteString("0000000000000000");

    rc4.setUp(key1);
    final String output1 = rc4.codeDecode(input1);
    Window.alert("input=0000000000000000" + "\ncoded="
        + RC4Java.byteStringToHexString(output1)
        + "\nexpected=7494c2e7104b0879" + "\ndecoded="
        + RC4Java.byteStringToHexString(rc4.codeDecode(key1, output1)));

    // final String key1b = rc4java
    // .hexStringToByteString("0123456789abcdef");
    // final String input1b = rc4jsni
    // .hexStringToByteString("0000000000000000");
    // final String output1b = rc4java.rc4CodeDecode(key1b, input1b);
    // Window.alert("input=0000000000000000"
    // + "\ncoded="
    // + rc4jsni.byteStringToHexString(output1b)
    // + "\nexpected=7494c2e7104b0879"
    // + "\ndecoded="
    // + rc4java.byteStringToHexString(rc4java.rc4CodeDecode(key1b,
    // output1b)));

    final AsyncCallback<Void> nada = new AsyncCallback<Void>() {
      @Override
      public void onFailure(final Throwable caught) {
      }

      @Override
      public void onSuccess(final Void result) {
      }
    };

    final AsyncCallback<String> algo = new AsyncCallback<String>() {

      @Override
      public void onFailure(final Throwable caught) {
        // TODO Auto-generated method stub

      }

      @Override
      public void onSuccess(final String result) {
        Window.alert(result);
      }
    };

    /*
     * The output is the following, as excepted from RFC 1321 :
     * 
     * http://www.ietf.org/rfc/rfc1321.txt
     * 
     * MD5("") = d41d8cd98f00b204e9800998ecf8427e
     * 
     * MD5("a") = 0cc175b9c0f1b6a831c399e269772661
     * 
     * MD5("abc") = 900150983cd24fb0d6963f7d28e17f72
     * 
     * MD5("message digest") = f96b697d7cb7938d525a2f31aaf161d0
     * 
     * MD5("abcdefghijklmnopqrstuvwxyz") = c3fcd3d76192e4007dfb496cca67e13b
     */

    gs.calcMD5("message digest", algo);
    // = f96b697d7cb7938d525a2f31aaf161d0

    // gs.calcMD5("abcdefghijklmnopqrstuvwxyz", algo);
    // = c3fcd3d76192e4007dfb496cca67e13b

    gs.storePair("007", "James Bond", nada);
    gs.storePair("1809", "Lincoln", nada);
    gs.storePair("7", "Wonders of the Ancient World", nada);

    gs.getValueForKey("7", algo);

  }
}
