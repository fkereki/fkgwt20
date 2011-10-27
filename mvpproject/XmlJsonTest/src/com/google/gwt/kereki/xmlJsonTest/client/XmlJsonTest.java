package com.google.gwt.kereki.xmlJsonTest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class XmlJsonTest implements EntryPoint {
    private final ServerProxyAsync serverProxy= GWT.create(ServerProxy.class);

    final TextBox addressField= new TextBox();
    final TextBox latitudeField= new TextBox();
    final TextBox longitudeField= new TextBox();
    final TextArea fullAddressField= new TextArea();

    final Button getXmlFromServerButton= new Button("Get XML from Server");
    final Button getJsonFromServerButton= new Button("Get JSON from Server");
    final Button getJsonDirectlyButton= new Button("Get JSON using JSONP");

    @Override
    public void onModuleLoad() {

        getXmlFromServerButton.setWidth("100%");
        getJsonFromServerButton.setWidth("100%");
        getJsonDirectlyButton.setWidth("100%");

        RootPanel.get("addressContainer").add(addressField);
        RootPanel.get("xmlButtonContainer").add(getXmlFromServerButton);
        RootPanel.get("jsonButtonContainer").add(getJsonFromServerButton);
        RootPanel.get("jsonpButtonContainer").add(getJsonDirectlyButton);
        RootPanel.get("latitudeContainer").add(latitudeField);
        RootPanel.get("longitudeContainer").add(longitudeField);
        RootPanel.get("fullAddressContainer").add(fullAddressField);

        addressField.setWidth("100%");
        addressField.setText("10901 W 120th Ave,Broomfield,CO");
        addressField.selectAll();
        addressField.setFocus(true);

        latitudeField.setReadOnly(true);
        longitudeField.setReadOnly(true);

        fullAddressField.setReadOnly(true);
        fullAddressField.setHeight("200px");
        fullAddressField.setWidth("100%");

        getXmlFromServerButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                serverProxy.getFromRemoteServer(
                    "http://maps.googleapis.com/maps/api/geocode/xml?address="
                        + URL.encode(addressField.getText()) + "&sensor=false",

                    new AsyncCallback<String>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            Window.alert("Failure getting XML through proxy");
                        }

                        @Override
                        public void onSuccess(String result) {
                            processXml(result);
                        }
                    });
            }
        });

        getJsonFromServerButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                serverProxy.getFromRemoteServer(
                    "http://maps.googleapis.com/maps/api/geocode/json?address="
                        + URL.encode(addressField.getText()) + "&sensor=false",

                    new AsyncCallback<String>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            Window.alert("Failure getting JSON through proxy");
                        }

                        @Override
                        public void onSuccess(String result) {
                            processJson(result);
                        }
                    });
            }
        });

        getJsonDirectlyButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final JsonpRequestBuilder jsonprb= new JsonpRequestBuilder();
                jsonprb.requestObject(
                    "http://maps.googleapis.com/maps/geo?output=json&q="
                        + URL.encode(addressField.getText()) + "&sensor=false",

                    new AsyncCallback<GeoDataV2>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            Window
                                .alert("Failure getting JSONP directly from remote server");

                        }

                        @Override
                        public void onSuccess(GeoDataV2 result) {
                            processJsonp(result);
                        }
                    });
            }
        });
    }

    public void processXml(final String xml) {
        final Document xmlDoc= XMLParser.parse(xml);
        final Element root= xmlDoc.getDocumentElement();
        XMLParser.removeWhitespace(xmlDoc);

        final NodeList results= root.getElementsByTagName("result");

        final Element firstResult= (Element) results.item(0);

        final NodeList addressParts= firstResult
            .getElementsByTagName("address_component");

        final Element geometry= (Element) firstResult.getElementsByTagName(
            "geometry").item(0);

        final Element location= (Element) geometry.getElementsByTagName(
            "location").item(0);

        final String latitude= location.getElementsByTagName("lat").item(0)
            .getFirstChild().getNodeValue();

        final String longitude= location.getElementsByTagName("lng").item(0)
            .getFirstChild().getNodeValue();

        latitudeField.setText(latitude);
        longitudeField.setText(longitude);

        String detailedAddress= "";

        /*
         * The following is just to show how to get the values of the invented
         * "useless" and "unneeded" attributes of the <location> element
         */
        detailedAddress= "USELESS=" + location.getAttribute("useless") + "\n"
            + "UNNEEDED=" + location.getAttribute("unneeded") + "\n\n";

        /*
         * Let's build up the address description by joining all the (possibly
         * more than one) <type> and (only one) <long_name> values
         */
        for (int i= 0; i < addressParts.getLength(); i++) {
            Element components= (Element) addressParts.item(i);

            /*
             * Loop over all the <type> nodes
             */
            String separator= "";

            NodeList types= components.getElementsByTagName("type");
            for (int j= 0; j < types.getLength(); j++) {
                detailedAddress= detailedAddress + separator
                    + types.item(j).getFirstChild().getNodeValue();
                separator= ", ";
            }

            /*
             * Add the <long_name> node value
             */
            detailedAddress= detailedAddress
                + ": "
                + components.getElementsByTagName("long_name").item(0)
                    .getFirstChild().getNodeValue() + "\n";
        }
        fullAddressField.setText(detailedAddress);
    }

    public void processJson(final String json) {
        final GeoDataV3 gd3= JsonUtils.unsafeEval(json);

        latitudeField.setText("" + gd3.getLatitude());
        longitudeField.setText("" + gd3.getLongitude());

        String detailedAddress= "";

        for (int i= 0; i < gd3.getAddressComponentsLength(); i++) {
            String separator= "";

            for (int j= 0; j < gd3.getAddressComponentTypeLength(i); j++) {
                detailedAddress= detailedAddress + separator
                    + gd3.getAddressComponentType(i, j);
                separator= ", ";
            }

            detailedAddress= detailedAddress + ": "
                + gd3.getAddressPartsLongName(i) + "\n";
        }
        fullAddressField.setText(detailedAddress);
    }

    public void processJsonp(final GeoDataV2 gd2) {
        fullAddressField.setText(gd2.getAddress() + "\nLocality:"
            + gd2.getLocality() + "\nPostal Code:" + gd2.getPostalCode());

        latitudeField.setText("" + gd2.getLatitude());
        longitudeField.setText("" + gd2.getLongitude());
    }
}
