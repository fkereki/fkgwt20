package com.fkereki.mvpproject.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.fkereki.mvpproject.client.rpc.XhrProxy;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class XhrProxyImpl
    extends RemoteServiceServlet
    implements XhrProxy {

  /**
   * Access a URL, do a GET, and return its text as as string. If there is any
   * problem, return a blank string instead.
   * 
   * @param originalUrl
   *          URL for the GET
   */
  public String getFromUrl(final String originalUrl) {
    String result = "";

    try {
      final BufferedReader in = new BufferedReader(new InputStreamReader(
          new URL(originalUrl).openStream()));

      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        result += inputLine;
      }

      in.close();
      return result;

    } catch (final Exception e) {
      return "";
    }
  }
}
