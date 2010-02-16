package com.kereki.generator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Generator
    implements EntryPoint {

  @Override
  public void onModuleLoad() {
    // Window.alert("Hi!");

    final MenuBar newMenu = GWT.create(MenuMaker.class);

    RootPanel.get().add(newMenu);
  }
}
