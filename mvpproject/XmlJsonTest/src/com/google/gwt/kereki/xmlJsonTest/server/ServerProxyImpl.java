package com.google.gwt.kereki.xmlJsonTest.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import com.google.gwt.kereki.xmlJsonTest.shared.ServerProxyException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class ServerProxyImpl extends RemoteServiceServlet implements
    com.google.gwt.kereki.xmlJsonTest.client.ServerProxy {

    @Override
    public String getFromRemoteServer(final String serviceUrl)
        throws ServerProxyException {

        String result= "";

        try {
            final URL url= new URL(serviceUrl);

            final BufferedReader in= new BufferedReader(new InputStreamReader(
                url.openStream()));

            String inputLine;
            while ((inputLine= in.readLine()) != null) {

                /*
                 * Don't do this "if"! It is just to add attributes to the XML.
                 * We are doing this just for an example!
                 */
                if (inputLine.trim().equals("<location>")) {
                    inputLine= "<location useless='"
                        + (new BigInteger(48, new Random()).toString(32))
                        + "' unneeded='" + (new BigInteger(48, new Random()))
                        + "'>";
                }

                result+= inputLine;
            }

            in.close();
            return result;

        } catch (final Exception e) {
            throw new ServerProxyException();
        }
    }

    @Override
    public String postToRemoteServer(final String serviceUrl)
        throws ServerProxyException {
        try {
            // serviceUrl is like
            // http://some.server/a/path/in/it?this=that&those=others
            // and we want to divide it in host (http://some.server), path
            // (a/path/in/it), and parameters (this=that&those=others)

            int hostStart= serviceUrl.indexOf("//");

            int pathStart= serviceUrl.substring(hostStart + 2).indexOf("/");

            int parameterStart= serviceUrl.substring(hostStart + 2 + pathStart)
                .indexOf("?");

            final String serverHost= serviceUrl.substring(0, hostStart
                + pathStart + 2);

            final String serverPath= serviceUrl.substring(hostStart + pathStart
                + 3, hostStart + pathStart + 2 + parameterStart);

            final String serverParameters= serviceUrl.substring(hostStart
                + pathStart + 3 + parameterStart);

            final URL url= new URL(serverHost);

            final URLConnection connection= url.openConnection();
            connection.setDoOutput(true);

            final OutputStreamWriter out= new OutputStreamWriter(
                connection.getOutputStream());

            final BufferedReader in= new BufferedReader(new InputStreamReader(
                connection.getInputStream()));

            out.write("POST " + serverPath + "\r\n");
            out.write("Host: " + serverHost + "\r\n");
            out.write("Accept-Encoding: identity\r\n");
            out.write("Connection: close\r\n");
            out.write("Content-Type: application/x-www-form-urlencoded\r\n");
            out.write("Content-Length: " + serverParameters.length()
                + "\r\n\r\n" + serverParameters + "\r\n");

            String result= "";
            String inputLine;
            while ((inputLine= in.readLine()) != null) {
                result+= inputLine;
            }

            in.close();
            out.close();

            return result;

        } catch (final Exception e) {
            throw new ServerProxyException();
        }
    }
}
