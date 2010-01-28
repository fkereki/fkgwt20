package com.fkereki.mvpproject.server;

import com.fkereki.mvpproject.client.rpc.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl
    extends RemoteServiceServlet
    implements LoginService {

  @Override
  public String getSessionKey(
      final String name,
      final String nonce,
      final String passHash)
      throws Exception {

    final String password = "kereki"; // get it from DB!
    final String calculatedHash = Security.md5(password + nonce);

    if (passHash.equals(calculatedHash)) {
      final String sessionKey = Security.randomCharString();

      // store the key at the DB, or at the session

      final Security secure = new Security();
      final String coded = secure.codeDecode(password + nonce,
          sessionKey);
      final String hexCoded = Security.byteStringToHexString(coded);
      return hexCoded;
    } else {
      throw new Exception("not valid login attempt");
    }
  }

  public String getSomething(final String name, final String pass) {
    return name + " " + pass;
  }
}
