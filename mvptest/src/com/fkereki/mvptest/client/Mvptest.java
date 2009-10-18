package com.fkereki.mvptest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mvptest implements EntryPoint {
  public void onModuleLoad() {
    MenuBar runMenuBar = new MenuBar();
    final VerticalPanel runPanel = new VerticalPanel();
    Grid rootDisplay = new Grid(2, 1);
    Command cmd = new Command() {
      public void execute() {
        runPanel.add(new Label("xxx"));
      }
    };

    Command cmd2 = new Command() {
      public void execute() {
        runPanel.clear();
        runPanel.add(new FormTwoLabels());
      }
    };

    Command cmd3 = new Command() {
      public void execute() {
        runPanel.clear();
        runPanel.add(new FormManyFields());
      }
    };

    runMenuBar.setWidth("100%");
    runMenuBar.addItem("the", cmd);
    runMenuBar.addItem("foo", cmd2);
    runMenuBar.addItem("menu", cmd3);

    MenuBar fooMenu = new MenuBar(true);
    fooMenu.addItem("the", cmd);
    fooMenu.addItem("foo", cmd);
    fooMenu.addItem("menu", cmd);

    MenuBar barMenu = new MenuBar(true);
    barMenu.addItem("the", cmd);
    barMenu.addItem("bar", cmd);
    barMenu.addItem("menu", cmd);

    MenuBar bazMenu = new MenuBar(true);
    bazMenu.addItem("the", cmd);
    bazMenu.addItem("baz", cmd);
    bazMenu.addItem("menu", cmd);

    // Make a new menu bar, adding a few cascading menus to
    // it.
    runMenuBar.addItem("foo", fooMenu);
    runMenuBar.addItem("bar", barMenu);
    runMenuBar.addItem("baz", bazMenu);

    rootDisplay.setWidth("100%");
    rootDisplay.setWidget(0, 0, runMenuBar);
    rootDisplay.setWidget(1, 0, runPanel);

    RootPanel.get().add(rootDisplay);
  }
}