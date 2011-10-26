package com.google.gwt.kereki.xmlJsonTest.client;

import com.google.gwt.core.client.JavaScriptObject;

public class GeoDataV2 extends JavaScriptObject {
    protected GeoDataV2() {
    }

    public final native String getAddress()
    /*-{
		return this.Placemark[0].address;
    }-*/;

    public final native String getLocality()
    /*-{
		return this.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality.LocalityName;
    }-*/;

    public final native String getPostalCode()
    /*-{
		return this.Placemark[0].AddressDetails.Country.AdministrativeArea.Locality.PostalCode.PostalCodeNumber;
    }-*/;

    public final native float getLatitude()
    /*-{
		return this.Placemark[0].Point.coordinates[1];
    }-*/;

    public final native float getLongitude()
    /*-{
		return this.Placemark[0].Point.coordinates[0];
    }-*/;
}
