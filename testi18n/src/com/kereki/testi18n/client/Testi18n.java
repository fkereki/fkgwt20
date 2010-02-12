package com.kereki.testi18n.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Testi18n
    implements EntryPoint {

  @Override
  public void onModuleLoad() {
    // final Texts texts = GWT.create(Texts.class);
    //
    // Window.alert(texts.helloWorld() + " " + texts.howAreYou() + " "
    // + texts.random() + texts.outOfFile());

    final MyMessages myme = GWT.create(MyMessages.class);

    Window.alert(myme.howMany(0) + "/" + myme.howMany(1) + "/"
        + myme.howMany(2) + "/" + myme.howMany(3));

  }
}
