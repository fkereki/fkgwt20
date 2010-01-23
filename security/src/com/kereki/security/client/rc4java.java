package com.kereki.security.client;

public class rc4java {
  final public static native String byteStringToHexString(String s)
  /*-{
    var i= 0;
    var r= '';
    for (i=0; i<s.length; i++) {
    r+= byteToHexChars(s.charCodeAt(i));
    }
    return r;

    function byteToHexChars(n) {
    return ("0"+n.toString(16)).substr(-2);
    }
  }-*/;

  final public static native String hexStringToByteString(String s)
  /*-{
    var i= 0;
    var r= '';
    for (i=0; i<s.length; i+=2) {
         r+= String.fromCharCode(parseInt(s.substr(i,2), 16));
    }
    return r;
  }-*/;

  final public static String rc4CodeDecode(
      final String key,
      final String plaintext) {

    int i, j, k;
    byte x;
    final byte s[] = new byte[256];

    for (i = 0; i < 256; i++) {
      s[i] = (byte) i;
    }

    final int kl = key.length();
    for (i = 0, j = 0, k = 0; i < 256; i++) {
      j = j + s[i] + key.charAt(k) & 0xff;
      k = (k + 1) % kl;

      x = s[i];
      s[i] = s[j];
      s[j] = x;
    }

    String r = "";
    final int pl = plaintext.length();
    for (i = j = k = 0; k < pl; k++) {
      i = i + 1 & 0xff;
      j = j + s[i] & 0xff;

      x = s[i];
      s[i] = s[j];
      s[j] = x;
      r += (char) (plaintext.charAt(k) ^ s[s[i] + s[j] & 0xff] & 0xff);
    }
    return r;
  }
}
