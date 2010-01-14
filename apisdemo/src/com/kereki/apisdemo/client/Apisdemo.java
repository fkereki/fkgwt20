package com.kereki.apisdemo.client;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.core.client.EntryPoint;
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

  // private final native void getFeed() /*-{
  // var feed = new
  // $wnd.google.feeds.Feed("http://weather.yahooapis.com/forecastrss?w=468052&u=c");
  // feed.load(function(result) {
  // if (!result.error) {
  // var container = $doc.getElementById("feed");
  // for (var i = 0; i < result.feed.entries.length; i++) {
  // var entry = result.feed.entries[i];
  // var div = $doc.createElement("div");
  // div.appendChild($doc.createTextNode(entry.title));
  // container.appendChild(div);
  // }
  // }
  // });
  // }-*/;

  public native void getFeed2() /*-{
    var myself = this;
    var feed = new $wnd.google.feeds.Feed("http://weather.yahooapis.com/forecastrss?w=468052&u=c");
    feed.load(function(result) {
    //    if (!result.error) {
    $wnd.rrr= result;
    myself.@com.kereki.apisdemo.client.Apisdemo::processWeather(Lcom/kereki/apisdemo/client/WeatherFeed;)(result);
    //    this.@com.kereki.apisdemo.client.Apisdemo::processWeather(Ljava/lang/String;)(result.feed.title);
    //    }
    });
  }-*/;

  @Override
  public void onModuleLoad() {
    AjaxLoader.init();
    final AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
    AjaxLoader.loadApi("feeds", "1", new Runnable() {
      public void run() {
        getFeed2();
      }
    }, options);
  }

  void processWeather(final WeatherFeed ww) {
    Window.alert("success... " + ww.getTitle());
  }
}
