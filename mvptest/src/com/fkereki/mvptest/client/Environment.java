package com.fkereki.mvptest.client;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Environment {
  final Model model;
  final Grid rootDisplay = new Grid(2, 1);
  final MenuBar runMenuBar = new MenuBar();
  final VerticalPanel runPanel = new VerticalPanel();
  String startingToken;
  String currentUser;


  protected class HistoryCommand implements Command {
    String historyToken;


    public HistoryCommand(final String newToken) {
      historyToken = newToken;
    }


    public void execute() {
      launch(historyToken);
    }
  }


  public Environment(Model aModel, String aToken) {
    model = aModel;
    startingToken = aToken;
  }


  public Model getModel() {
    return model;
  }


  public void showAlert(String alertText) {
    Window.alert(alertText);
  }


  private void showLogin(Panel panel) {
    currentUser = "";

    LoginPresenter loginForm = new LoginPresenter("",
      new LoginView(), this, new SimpleCallback<String>() {
        @Override
        public void goBack(String result) {
          currentUser = result;
          showMainMenu();
        }
      });

    panel.clear();
    panel.add(loginForm.getDisplay().asWidget());
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
     * logout/login, we will go back again to it.
     */
    if (!startingToken.isEmpty()) {
      launch(startingToken);
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


  public void launch(String token) {
    launch(token, null);
  }


  public void launch(String token, Panel panel) {
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

    /*
     * If no panel is given, use the standard runPanel, and
     * add the token to History.
     */
    if (panel == null) {
      panel = runPanel;
      History.newItem(token);
    }
    panel.clear();

    // TODO Check, before running, if the current user is
    // allowed to run the program

    if (token.isEmpty()) {
      // no need to do anything...
    } else if (token.equals(LoginPresenter.PLACE)) {
      showLogin(RootPanel.get());
    } else if (token.equals(DummyOnePresenter.PLACE)) {
      panel.add((new DummyOnePresenter(args,
        new DummyOneView(), this)).getDisplay().asWidget());
    } else if (token.equals(DummyTwoPresenter.PLACE)) {
      panel.add((new DummyTwoPresenter(args,
        new DummyTwoView(), this)).getDisplay().asWidget());
    } else {
      Window.alert("Unrecognized token=" + token);
    }
  }
}
