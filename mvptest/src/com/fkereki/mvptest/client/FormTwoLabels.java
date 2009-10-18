package com.fkereki.mvptest.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormTwoLabels extends Composite {
  public FormTwoLabels() {
    VerticalPanel panel = new VerticalPanel();
    panel.add(new Label("uno"));
    panel.add(new Label("dos"));
    initWidget(panel);
  }
}