package com.kereki.demorc2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Demorc2b extends Composite {

  private static Demorc2bUiBinder uiBinder = GWT.create(Demorc2bUiBinder.class);

  interface Demorc2bUiBinder extends UiBinder<Widget, Demorc2b> {
  }

  @UiField
  Button button;

  public Demorc2b(String firstName) {
    initWidget(uiBinder.createAndBindUi(this));
    button.setText(firstName);
  }

  @UiHandler("button")
  void onClick(ClickEvent e) {
    Window.alert("Hello!");
  }

}
