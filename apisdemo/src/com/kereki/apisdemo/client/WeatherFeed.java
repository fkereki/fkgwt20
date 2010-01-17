package com.kereki.apisdemo.client;

import com.google.gwt.core.client.JavaScriptObject;

/* 
 * feed
 * title
 * type (=rss20)
 * entries[]
 *   content
 *   contentSnippet
 *   link
 *   publishedDate
 *   title
 */

public class WeatherFeed
    extends JavaScriptObject {

  protected WeatherFeed() {
  }

  public final native String getFeedDescription() /*-{
    return this.feed.description;
  }-*/;

  public final native String getItemContent() /*-{
    return this.feed.entries[0].content;
  }-*/;

  public final native String getItemLink() /*-{
    return this.feed.entries[0].link;
  }-*/;

  public final native String getItemTitle() /*-{
    return this.feed.entries[0].title;
  }-*/;
}
