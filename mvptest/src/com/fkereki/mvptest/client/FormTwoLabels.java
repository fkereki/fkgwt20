package com.fkereki.mvptest.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO Add security checks, so unauthorized users
// cannot get to a function just by entering the
// appropriate token

public class FormTwoLabels extends Composite {
  public FormTwoLabels() {
    this(null);
  }

  public FormTwoLabels(String params) {
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