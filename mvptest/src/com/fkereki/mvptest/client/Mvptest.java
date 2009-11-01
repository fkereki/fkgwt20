package com.fkereki.mvptest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Mvptest implements EntryPoint,
    ValueChangeHandler<String> {

  final Model model = new Model(); // access the Model

  final Grid rootDisplay = new Grid(2, 1);
  final MenuBar runMenuBar = new MenuBar();
  final VerticalPanel runPanel = new VerticalPanel();
  KeyValueMap keyValue;


  public void onModuleLoad() {
    DOM.removeChild(RootPanel.getBodyElement(), DOM
      .getElementById("loading"));

    History.addValueChangeHandler(this);
    History.newItem(LoginPresenter.PLACE, true);

    // the "true" as last parameter could be omitted; then,
    // you would have to History.fireCurrenthistoryState()
    // on your own.
  }


  void showLogin() {
    // TODO Clear data of possible current user.

    LoginPresenter loginForm = new LoginPresenter("",
      new LoginView(), model, new SimpleCallback<String>() {
        @Override
        public void goBack(String result) {
          // TODO Save user information, so the main menu
          // can be configured
          showMainMenu();
        }
      });

    RootPanel.get().clear();
    RootPanel.get().add(loginForm.getDisplay().asWidget());
  }


  void showMainMenu() {
    // TODO Use user information for menu configuration

    runMenuBar.clearItems();
    runMenuBar.setWidth("100%");
    createMenu(runMenuBar);

    rootDisplay.setWidth("100%");
    rootDisplay.setWidget(0, 0, runMenuBar);
    rootDisplay.setWidget(1, 0, runPanel);

    RootPanel.get().clear();
    RootPanel.get().add(rootDisplay);
  }


  void createMenu(MenuBar mb) {
    // TODO Add user type parameter, for specific menu
    // generation

    mb.addItem("dummy#1", new HistoryCommand(
      DummyOnePresenter.PLACE + "?pepe=show this"));
    mb.addItem("dummy#2", new HistoryCommand(
      DummyTwoPresenter.PLACE));
    mb.addItem("login", new HistoryCommand(
      LoginPresenter.PLACE));
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

    // TODO Check, before running, if the current user is
    // allowed to run the
    // program

    ppp.clear();
    if (token.equals(LoginPresenter.PLACE)) {
      showLogin();
    } else if (token.equals(DummyOnePresenter.PLACE)) {
      ppp
        .add((new DummyOnePresenter(args,
          new DummyOneView(), model)).getDisplay()
          .asWidget());
    } else if (token.equals(DummyTwoPresenter.PLACE)) {
      ppp
        .add((new DummyTwoPresenter(args,
          new DummyTwoView(), model)).getDisplay()
          .asWidget());
    } else if (token.equals("")) {
      // no need to do anything...
    } else {
      Window.alert("Unrecognized token=" + token);
    }
  }
}