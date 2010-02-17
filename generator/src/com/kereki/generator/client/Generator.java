package com.kereki.generator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Generator
    implements EntryPoint {

  @Override
  public void onModuleLoad() {
    final MenuBar stack[] = new MenuBar[20];
    stack[0] = new MenuBar();
    stack[1] = new MenuBar(true);
    stack[0].addItem("Este es un menu", stack[1]);
    stack[1].addItem("este es un texto", (Command) null);
    stack[1].addItem("este es otro", (Command) null);
    stack[2] = new MenuBar(true);
    stack[1].addItem("Va un submenu", stack[2]);
    stack[2].addItem("tercero", (Command) null);
    stack[2].addItem("cuarto comando", (Command) null);
    stack[1].addItem("va algo mas", (Command) null);
    stack[1] = new MenuBar(true);
    stack[0].addItem("Aca empieza el segundo menu", stack[1]);
    stack[1].addItem("sexto en linea", (Command) null);
    stack[1].addItem("septimo comando", (Command) null);
    stack[1].addItem("octavo", (Command) null);

    Window.alert("Hi!");

    final MenuMaker newMenuBuilder = GWT.create(MenuMaker.class);

    Window.alert("Mid!");

    final MenuBar mb = newMenuBuilder.createMenu();

    Window.alert("Lo!");
    RootPanel.get().add(mb);
  }
}
