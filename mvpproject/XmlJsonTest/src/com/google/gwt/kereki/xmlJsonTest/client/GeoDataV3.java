package com.google.gwt.kereki.xmlJsonTest.client;

import com.google.gwt.core.client.JavaScriptObject;

public class GeoDataV3 extends JavaScriptObject {
    protected GeoDataV3() {
    }

    public final native String getAddressPartsLongName(final int i)
    /*-{
    	return this.results[0].address_components[i].long_name;
    }-*/;

    public final native int getAddressPartsLength()
    /*-{
    	return this.results[0].address_components.length;
    }-*/;

    public final native String getAddressPartsType(final int i, final int j)
    /*-{
    	return this.results[0].address_components[i].types[j];
    }-*/;

    public final native int getAddressPartsTypeLength(final int i)
    /*-{
    	return this.results[0].address_components[i].types.length;
    }-*/;

    public final native float getLatitude()
    /*-{
    	return this.results[0].geometry.location.lat;
    }-*/;

    public final native float getLongitude()
    /*-{
    	return this.results[0].geometry.location.lng;
    }-*/;
}
