package com.kereki.nixietest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Nixietest
    implements EntryPoint {

  private static native String md5(String pText) /*-{
    return $wnd.hex_md5(pText);
  }-*/;

  FlexTable ft = new FlexTable();

  public void onModuleLoad() {
    Window.alert(md5("hola"));

    NixieDisplay display1 = new NixieDisplay("nd1", 5, "right");
    NixieDisplay display2 = new NixieDisplay("nd2", 10, "left");
    NixieDisplay display3 = new NixieDisplay("nd3", 12, "right");

    ft.setWidget(0, 0, new Label("James Bond is:"));
    ft.setWidget(0, 1, display1);
    ft.setWidget(1, 0, new Label("Darwin/Lincoln Birthdate:"));
    ft.setWidget(1, 1, display2);
    ft.setWidget(2, 0, new Label("All digits:"));
    ft.setWidget(2, 1, display3);

    RootPanel.get().add(ft);

    display1.setText("007 ");
    display2.setText("02-12-1809");
    display3.setText("-123456.7890");
  }
}
