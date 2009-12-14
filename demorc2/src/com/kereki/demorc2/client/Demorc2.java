package com.kereki.demorc2.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Demorc2 implements EntryPoint {
  @UiTemplate("Demorc2.ui.xml")
  interface Binder1 extends UiBinder<HTMLPanel, Demorc2> {
  }

  private static Binder1 binder1 = GWT.create(Binder1.class);

  @UiField
  TextBox nameTextBox;
  @UiField
  PasswordTextBox passwordTextBox;

  @UiField
  Button loginButton;

  TabPanel tp;

  public void onModuleLoad() {
    HTMLPanel dl1 = binder1.createAndBindUi(this);

    Demorc2c d2c = new Demorc2c();
    d2c.setHeight("400px");

    // tp = new TabPanel();
    // tp.add(dl1, "Login");
    // tp.add(new Demorc2b("hello"), "bar");
    // tp.add(d2c, "baz");
    //
    // // Show the 'bar' tab initially.
    // tp.selectTab(2);
    //
    // tp.setWidth("500px");
    // tp.setHeight("400px");

    // Add it to the root panel.
    RootPanel.get().add(d2c);
  }
}