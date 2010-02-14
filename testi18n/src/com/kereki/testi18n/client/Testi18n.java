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
    final Greet greet = GWT.create(Greet.class);

    Window.alert(greet.genericHello() + " " + greet.specificQuery());

    Window.alert(greet.getString("kindOfUsers"));

    final MyMessages myme = GWT.create(MyMessages.class);

    Window.alert(myme.howMany(0) + "/" + myme.howMany(1) + "/"
        + myme.howMany(2) + "/" + myme.howMany(3));

  }
}
