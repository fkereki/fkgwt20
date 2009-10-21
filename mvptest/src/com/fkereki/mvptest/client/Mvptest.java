package com.fkereki.mvptest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mvptest implements EntryPoint,
    ValueChangeHandler<String> {

  final Grid rootDisplay = new Grid(2, 1);
  final MenuBar runMenuBar = new MenuBar();
  final VerticalPanel runPanel = new VerticalPanel();
  KeyValueMap keyValue;

  final Model model = new Model(); // access the Model

  public void onModuleLoad() {
    DOM.removeChild(RootPanel.getBodyElement(), DOM
      .getElementById("loading"));

    LoginPresenter loginForm = new LoginPresenter(
      new LoginView());
    View xxx = loginForm.getView();
    Window.alert("333");

    RootPanel.get().add(xxx);

    Window.alert("444");

    // runMenuBar.setWidth("100%");
    // createMenu(runMenuBar);
    //
    // rootDisplay.setWidth("100%");
    // rootDisplay.setWidget(0, 0, runMenuBar);
    // rootDisplay.setWidget(1, 0, runPanel);
    //
    //
    // // TODO Add login; get username and password,
    // validate
    // // with server, and also get user type (for menues
    // and
    // // authorization)
    //
    // RootPanel.get().add(rootDisplay);
    // History.addValueChangeHandler(this);
  }

  void createMenu(MenuBar mb) {
    // TODO Add user type parameter, for specific menu
    // generation

    mb
      .addItem("the", new HistoryCommand("foo?pepe=inicio"));
    mb.addItem("foo", new HistoryCommand("bar"));
    mb.addItem("menu", new HistoryCommand("baz"));
  }


  @Override
  public void onValueChange(ValueChangeEvent<String> event) {
    executeInPanel(runPanel, event.getValue());
  }


  public void executeInPanel(Panel ppp, String token) {

    /*
     * There could be parameters after the "#token" in the
     * classic form "?key1=value1&key2=value2..."; for more
     * on this, check http://www.w3.org/TR/hash-in-uri/.
     */
    String args = "";
    int question = token.indexOf("?");
    if (question != -1) {
      args = token.substring(question + 1);
      token = token.substring(0, question);
    }

    ppp.clear();
    if (token.equals("foo")) {
      ppp.add(new FormTwoLabels(this, args));
    } else if (token.equals("bar")) {
      ppp.add(new FormManyFields(this, args));
    } else if (token.equals("baz")) {
      ppp.add(new Label("just bazzing along..."));
    } else if (token.equals("")) {
      // no need to do anything...
    } else {
      Window.alert("Unrecognized token=" + token);
    }
  }
}