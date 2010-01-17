package com.kereki.apisdemo.client;

import com.google.gwt.ajaxloader.client.AjaxLoader;
import com.google.gwt.ajaxloader.client.AjaxLoader.AjaxLoaderOptions;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Apisdemo
    implements EntryPoint {

  private native void getFeed()
  /*-{
  var myself = this;
  // Montevideo, UY=468052
  // Los Angeles, USA= 2442047

  var url= "http://weather.yahooapis.com/forecastrss?w=468052&u=c";
  var feed= new $wnd.google.feeds.Feed(url);
  feed.load(function(result) {
  if (!result.error) {
  $wnd.rrr = result;
  myself.@com.kereki.apisdemo.client.Apisdemo::processWeather(Lcom/kereki/apisdemo/client/WeatherFeed;)(result);
  }});
  }-*/;

  @Override
  public void onModuleLoad() {
    AjaxLoader.init();
    final AjaxLoaderOptions options = AjaxLoaderOptions.newInstance();
    AjaxLoader.loadApi("feeds", "1", new Runnable() {
      public void run() {
        getFeed();
      }
    }, options);
  }

  void processWeather(final WeatherFeed ww) {
    final VerticalPanel vp = new VerticalPanel();
    vp.add(new Anchor(ww.getFeedDescription(), ww.getItemLink()));
    vp.add(new HTMLPanel(ww.getItemContent()));
    RootPanel.get().add(vp);
    Window.alert("Check it out!");
  }
}
