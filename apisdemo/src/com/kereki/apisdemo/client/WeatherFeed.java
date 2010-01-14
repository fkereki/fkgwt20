package com.kereki.apisdemo.client;

import com.google.gwt.core.client.JavaScriptObject;

public class WeatherFeed
    extends JavaScriptObject {

  protected WeatherFeed() {
  }

  public final native String getTitle() /*-{
    return this.feed.title;
  }-*/;
}
