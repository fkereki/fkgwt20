package com.fkereki.mvptest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mvptest implements EntryPoint,
    ValueChangeHandler<String> {

  final Grid rootDisplay = new Grid(2, 1);
  final MenuBar runMenuBar = new MenuBar();
  final VerticalPanel runPanel = new VerticalPanel();

  public void onModuleLoad() {
    runMenuBar.setWidth("100%");
    createMenu(runMenuBar);

    rootDisplay.setWidth("100%");
    rootDisplay.setWidget(0, 0, runMenuBar);
    rootDisplay.setWidget(1, 0, runPanel);

    DOM.removeChild(RootPanel.getBodyElement(), DOM
      .getElementById("loading"));
    RootPanel.get().add(rootDisplay);
    History.addValueChangeHandler(this);
  }

  void createMenu(MenuBar mb) {
    mb.addItem("the", new HistoryCommand("foo"));
    mb.addItem("foo", new HistoryCommand("bar"));
    mb.addItem("menu", new HistoryCommand("baz"));
  }

  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    runPanel.clear();
    String token = event.getValue();
    if (token.equals("foo")) {
      runPanel.add(new FormTwoLabels());
    } else if (token.equals("bar")) {
      runPanel.add(new FormManyFields());
    } else if (token.equals("baz")) {
      runPanel.add(new Label("just bazzing along..."));
    } else if (token.equals("")) {
      // no need to do anything...
    }
  }
}