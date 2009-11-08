package com.fkereki.mvptest.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Environment {
  Model model;
  String startingToken;
  String currentUser;

  Grid rootDisplay;
  MenuBar runMenuBar;
  VerticalPanel runPanel;


  public Environment(Model aModel, String aToken) {
    model = aModel;
    startingToken = aToken;
    rootDisplay = new Grid(2, 1);
    runMenuBar = new MenuBar();
    runPanel = new VerticalPanel();
  }


  public void showAlert(String s) {
    Window.alert(s);
  }


  private void showLogin() {
    currentUser = "";

    LoginPresenter loginForm = new LoginPresenter("",
      new LoginView(), model, this,
      new SimpleCallback<String>() {
        @Override
        public void goBack(String result) {
          currentUser = result;
          showMainMenu();
        }
      });

    RootPanel.get().clear();
    RootPanel.get().add(loginForm.getDisplay().asWidget());
  }


  private void showMainMenu() {
    // TODO Use user information for menu configuration

    runMenuBar.clearItems();
    runMenuBar.setWidth("100%");
    createMenu(runMenuBar);

    rootDisplay.setWidth("100%");
    rootDisplay.setWidget(0, 0, runMenuBar);
    rootDisplay.setWidget(1, 0, runPanel);

    RootPanel.get().clear();
    RootPanel.get().add(rootDisplay);

    /*
     * If the application was started with a token, now that
     * the user is logged in, it's time to show it.
     * 
     * Don't forget to clear startingToken, or after a
     * logout/login, we will go back again to the token.
     */
    if (!startingToken.isEmpty()) {
      History.newItem(startingToken, true);
      startingToken = "";
    }
  }


  private void createMenu(MenuBar mb) {
    // TODO Add user type parameter, for specific menu
    // generation

    mb.addItem("dummy#1", new HistoryCommand(
      DummyOnePresenter.PLACE + "?parameter=value"));
    mb.addItem("dummy#2", new HistoryCommand(
      DummyTwoPresenter.PLACE));
    mb.addItem("login", new HistoryCommand(
      LoginPresenter.PLACE));
  }


  public void executeInPanel(String token) {
    executeInPanel(token, runPanel);
  }


  public void executeInPanel(String token, Panel ppp) {
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
    // allowed to run the program

    ppp.clear();

    if (token.isEmpty()) {
      // no need to do anything...
    } else if (token.equals(LoginPresenter.PLACE)) {
      showLogin();
    } else if (token.equals(DummyOnePresenter.PLACE)) {
      ppp.add((new DummyOnePresenter(args,
        new DummyOneView(), model, this)).getDisplay()
        .asWidget());
    } else if (token.equals(DummyTwoPresenter.PLACE)) {
      ppp.add((new DummyTwoPresenter(args,
        new DummyTwoView(), model, this)).getDisplay()
        .asWidget());
    } else {
      Window.alert("Unrecognized token=" + token);
    }
  }
}
