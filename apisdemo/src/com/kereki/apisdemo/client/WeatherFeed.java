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

  public final native String getFeedTitle() /*-{
    return this.feed.title;
  }-*/;

  public final native String getItemContent(int i) /*-{
    return this.feed.entries[i].content;
  }-*/;

  public final native String getItemLink(final int i) /*-{
    return this.feed.entries[i].link;
  }-*/;

  public final native String getItemTitle(int i) /*-{
    return this.feed.entries[i].title;
  }-*/;

  public final native int getNumberOfEntries() /*-{
    return this.feed.entries.length;
  }-*/;
}
