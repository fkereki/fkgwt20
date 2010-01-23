package com.kereki.security.client;

import com.google.gwt.user.client.Random;

public class rc4java {
  final public static String byteStringToHexString(final String s) {
    String r = "";
    for (int i = 0; i < s.length(); i++) {
      r += byteToHexChars(s.charAt(i));
    }
    return r;
  }

  final public static String byteToHexChars(final int i) {
    final String s = "0" + Integer.toHexString(i);
    return s.substring(s.length() - 2);
  }

  final public static String hexStringToByteString(final String s) {
    String r = "";
    for (int i = 0; i < s.length(); i += 2) {
      r += (char) Integer.parseInt(s.substring(i, i + 2), 16);
    }
    return r;
  }

  /**
   * Generates a string of 32 letters (A to Z). For server side code, you might
   * also consider using RandomStringUtils.randomAlphabetic(32)
   * 
   * @return
   */
  final public static String randomCharString() {
    String r = "";
    for (int i = 0; i < 32; i++) {
      r += (char) ('A' + Random.nextInt(26));
    }
    return r;
  }

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
