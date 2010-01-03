package com.kereki.nixietest.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.HTMLPanel;

public class NixieDisplay
    extends HTMLPanel {

  JavaScriptObject display;

  public NixieDisplay(String pName, int pDigits, String pAlign) {
    super("<div id='" + pName + "'></div>");
    display = initNixieDisplay(pName, pDigits, pAlign);
  }

  private native JavaScriptObject initNixieDisplay(
      String pName,
      int pDigits,
      String pAlign) /*-{
    var nd = new $wnd.NixieDisplay();
    nd.id = pName;
    nd.charCount = pDigits;
    nd.charWidth = 30;
    nd.charHeight = 50;
    nd.charGapWidth = 0;
    nd.urlCharsetImage= "nixielib/zm1080_d1_09bdm_30x50_8b.png";
    nd.align = pAlign;
    return (nd);
  }-*/;

  public native void setText(String pText) /*-{
    this.@com.kereki.nixietest.client.NixieDisplay::display.init();
    this.@com.kereki.nixietest.client.NixieDisplay::display.setText(pText);
  }-*/;
}
