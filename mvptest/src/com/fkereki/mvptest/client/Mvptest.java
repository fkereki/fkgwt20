package com.fkereki.mvptest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mvptest implements EntryPoint,
    ValueChangeHandler<String> {
  final VerticalPanel runPanel = new VerticalPanel();

  public void onModuleLoad() {
    MenuBar runMenuBar = new MenuBar();
    Grid rootDisplay = new Grid(2, 1);

    runMenuBar.setWidth("100%");
    runMenuBar.addItem("the", new HistoryCommand("foo"));
    runMenuBar.addItem("foo", new HistoryCommand("bar"));
    runMenuBar.addItem("menu", new HistoryCommand("baz"));

    rootDisplay.setWidth("100%");
    rootDisplay.setWidget(0, 0, runMenuBar);
    rootDisplay.setWidget(1, 0, runPanel);

    RootPanel.get().add(rootDisplay);
    History.addValueChangeHandler(this);
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