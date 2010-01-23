package com.kereki.security.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.kereki.security.client.GreetingService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl
    extends RemoteServiceServlet
    implements GreetingService {

  @Override
  public String calcMD5(final String pString) {
    try {
      final MD5 md5 = new MD5();
      md5.Update(pString, null);
      return md5.asHex();
    } catch (final Exception e) {
      return "";
    }
  }

  // final String serverInfo = getServletContext().getServerInfo();
  // final String userAgent = getThreadLocalRequest().getHeader(
  // "User-Agent");

  @Override
  public String getValueForKey(final String pKey) {
    final HttpServletRequest request = getThreadLocalRequest();
    final HttpSession session = request.getSession();
    return (String) session.getAttribute(pKey);
  }

  @Override
  public void storePair(final String pKey, final String pName) {
    final HttpServletRequest request = getThreadLocalRequest();
    final HttpSession session = request.getSession();
    session.setAttribute(pKey, pName);
  }
}
