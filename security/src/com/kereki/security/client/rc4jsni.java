package com.kereki.security.client;

public class rc4jsni {

  // recordar RC4 también es ARCFOUR

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

  final public static native String randomCharString()
  /*-{
    var i= 0;
    var r= '';
    for (i = 0; i < 32; i++) {
      r += String.fromCharCode(65 + Math.floor(Math.random()*26));
    }
    return r;
  }-*/;

  final public static native String rc4CodeDecode(
      String key,
      String plaintext)
  /*-{
    var i=0, j=0, k=0;
    var s= new Array();
    for (i=0; i<256; i++) {
    s[i]= i;
    }

    var x= '';
    var kl= key.length;
    for (i=0, j=0, k=0; i<256; i++) {
      j= (j + s[i] + key.charCodeAt(k)) % 256;
      k= (k + 1) % kl;

      x= s[i];
      s[i]= s[j];
      s[j]= x;
    }

    var r= '';
    var pl= plaintext.length;
    for (i=0, j=0, k=0; k<pl; k++) {
      i= (i + 1) % 256;
      j= (j + s[i]) % 256;

    x= s[i];
    s[i]= s[j];
    s[j]= x;

    r+= String.fromCharCode(plaintext.charCodeAt(k) ^ s[(s[i] + s[j]) % 256]);
    }
    return r;
  }-*/;
}
