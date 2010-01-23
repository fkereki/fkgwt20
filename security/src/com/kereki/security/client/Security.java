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
    final String key = rc4jsni
        .hexStringToByteString("0123456789abcdef");
    final String input = "FEDERICO KEREKI";
    final String output = rc4java.rc4CodeDecode(key, input);
    final String decoded = rc4jsni.rc4CodeDecode(key, output);
    Window.alert("input=" + input + "\ncoded="
        + rc4jsni.byteStringToHexString(output) + "\ndecoded="
        + decoded);

    final String key1 = rc4jsni
        .hexStringToByteString("0123456789abcdef");
    final String input1 = rc4jsni
        .hexStringToByteString("0000000000000000");
    final String output1 = rc4java.rc4CodeDecode(key1, input1);
    Window.alert("input=0000000000000000"
        + "\ncoded="
        + rc4jsni.byteStringToHexString(output1)
        + "\nexpected=7494c2e7104b0879"
        + "\ndecoded="
        + rc4jsni.byteStringToHexString(rc4java.rc4CodeDecode(key1,
            output1)));

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
     * MD5 test suite:¶ MD5 ("") = d41d8cd98f00b204e9800998ecf8427e¶ MD5 ("a") =
     * 0cc175b9c0f1b6a831c399e269772661¶ MD5 ("abc") =
     * 900150983cd24fb0d6963f7d28e17f72¶ MD5 ("message digest") =
     * f96b697d7cb7938d525a2f31aaf161d0¶ MD5 ("abcdefghijklmnopqrstuvwxyz") =
     * c3fcd3d76192e4007dfb496cca67e13b¶ MD5
     * ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789") =
     * d174ab98d277d9f5a5611c2c9f419d9f¶ MD5
     * ("123456789012345678901234567890123456789012345678901234567890123456
     * 78901234567890") = 57edf4a22be3c955ac49da2e2107b67a¶
     */

    gs.calcMD5("message digest", algo);
    // = f96b697d7cb7938d525a2f31aaf161d0

    gs.calcMD5("abcdefghijklmnopqrstuvwxyz", algo);
    // = c3fcd3d76192e4007dfb496cca67e13b

    // gs.storePair("007", "James Bond", nada);
    // gs.storePair("1809", "Lincoln", nada);
    // gs.storePair("7", "Wonders of the Ancient World", nada);

    gs.getValueForKey("7", algo);

  }
}
