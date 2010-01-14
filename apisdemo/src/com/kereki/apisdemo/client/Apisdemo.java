package com.kereki.apisdemo.client;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Apisdemo
    implements EntryPoint {

  // feed
  // title
  // type rss20
  // entries[]
  // content
  // contentSnippet
  // link
  // publishedDate
  // title

  private native void getFeed() /*-{
    var feed = new $wnd.google.feeds.Feed("http://weather.yahooapis.com/forecastrss?w=468052&u=c");
    feed.load(function(result) {
    if (!result.error) {
    var container = $doc.getElementById("feed");
    for (var i = 0; i < result.feed.entries.length; i++) {
    var entry = result.feed.entries[i];
    var div = $doc.createElement("div");
    div.appendChild($doc.createTextNode(entry.title));
    container.appendChild(div);
    }
    }
    });
  }-*/;

  private native void getFeed2() /*-{
    var feed = new $wnd.google.feeds.Feed("http://weather.yahooapis.com/forecastrss?w=468052&u=c");
    feed.load(function(result) {
    if (!result.error) {
    alert("11");
    this.@com.kereki.apisdemo.client.Apisdemo::processWeather(Lcom/google/gwt/core/client/JavaScriptObject;)(result);
    }});
  }-*/;

  @Override
  public void onModuleLoad() {
    // TODO Auto-generated method stub
    AjaxLoader.init();
    final AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
    AjaxLoader.loadApi("feeds", "1", new Runnable() {
      public void run() {
        Window.alert("done");
        getFeed2();
      }
    }, options);
  }

  void processWeather(final JavaScriptObject wf) {
    Window.alert("22");
    // Window.alert(((WeatherFeed) wf).getTitle());
  }

}
