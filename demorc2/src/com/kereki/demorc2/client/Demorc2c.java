package com.kereki.demorc2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Demorc2c extends Composite {

  interface Demorc2cUiBinder extends UiBinder<Widget, Demorc2c> {
  }

  private static Demorc2cUiBinder uiBinder = GWT.create(Demorc2cUiBinder.class);

  public Demorc2c() {
    initWidget(uiBinder.createAndBindUi(this));
  }

}
