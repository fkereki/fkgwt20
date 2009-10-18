package com.fkereki.mvptest.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormTwoLabels extends Composite {
  public FormTwoLabels() {
    VerticalPanel panel = new VerticalPanel();
    panel.add(new Label("uno"));
    panel.add(new Label("dos"));
    panel.add(new Hyperlink("vamos al foo", "foo"));
    panel.add(new Hyperlink("vamos al bar",
      "bar?pepe=juan&luis=33"));
    panel.add(new Hyperlink("vamos al baZ", "baz"));
    initWidget(panel);
  }
}