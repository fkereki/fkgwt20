package com.kereki.nixietest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Nixietest
    implements EntryPoint {

  private static native void showNixie() /*-{
    pCount=10;
    pStyle="1080_d1";
    pWidth=30;
    pHeight=50;
    pGap=0;
    pAlign="right";
    var nd = new $wnd.NixieDisplay();
    nd.id = 'nd1';
    nd.charCount = pCount;
    nd.charWidth = pWidth;
    nd.charHeight = pHeight;
    nd.urlCharsetImage = "nixielib/zm"+pStyle+"_09bdm_"+pWidth+"x"+pHeight+"_8b.png";
    nd.charGapWidth = pGap;
    nd.align = pAlign;
    nd.init();
    nd.setText('02-12-1809');
  }-*/;

  FlexTable ft = new FlexTable();

  public void onModuleLoad() {
    // HTMLPanel nixieDiv = new HTMLPanel("<div id='nd1'></div>");
    NixieDisplay display1 = new NixieDisplay("nd1", 3, "right");
    NixieDisplay display2 = new NixieDisplay("nd2", 10, "left");
    NixieDisplay display3 = new NixieDisplay("nd3", 11, "right");
    ft.setWidget(0, 0, new Label("James Bond is:"));
    // ft.setWidget(0, 1, nixieDiv);
    ft.setWidget(0, 1, display1);
    ft.setWidget(1, 0, new Label("Darwin/Lincoln Birthdate:"));
    ft.setWidget(1, 1, display2);
    ft.setWidget(2, 0, new Label("All digits:"));
    ft.setWidget(2, 1, display3);

    RootPanel.get().add(ft);
    // showNixie();
    display1.setText("007");
    display2.setText("02-12-1809");
    display3.setText("-123456.7890");
  }
}
