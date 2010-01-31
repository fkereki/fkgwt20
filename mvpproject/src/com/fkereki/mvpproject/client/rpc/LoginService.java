package com.fkereki.mvpproject.client.rpc;

import com.fkereki.mvpproject.client.exceptions.PasswordNotChangedException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService
    extends RemoteService {
  void changePassword(
      String name,
      String encryptedNewPassword,
      String nonce,
      String parametersHash)
      throws PasswordNotChangedException;

  String getSessionKey(String name, String nonce, String passHash)
      throws Exception;

  String getSomething(String name, String pass);
}