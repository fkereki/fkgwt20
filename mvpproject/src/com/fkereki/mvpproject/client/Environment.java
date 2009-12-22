package com.fkereki.mvpproject.client;

import com.fkereki.mvpproject.client.citiesBrowser2.CitiesBrowserPresenter;
import com.fkereki.mvpproject.client.citiesBrowser2.CitiesBrowserView;
import com.fkereki.mvpproject.client.cityCreator.CityCreatorPresenter;
import com.fkereki.mvpproject.client.cityCreator.CityCreatorView;
import com.fkereki.mvpproject.client.clientData.ClientDataPresenter;
import com.fkereki.mvpproject.client.clientData.ClientDataView;
import com.fkereki.mvpproject.client.clientSearch.ClientSearchPresenter;
import com.fkereki.mvpproject.client.clientSearch.ClientSearchView;
import com.fkereki.mvpproject.client.dummyOne.DummyOnePresenter;
import com.fkereki.mvpproject.client.dummyOne.DummyOneView;
import com.fkereki.mvpproject.client.login4.LoginFormPresenter;
import com.fkereki.mvpproject.client.login4.LoginFormView;
import com.fkereki.mvpproject.client.suggest.SuggestPresenter;
import com.fkereki.mvpproject.client.suggest.SuggestView;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Environment {
  protected class HistoryCommand
      implements Command {
    String historyToken;

    public HistoryCommand(
        final String newToken) {
      historyToken= newToken;
    }

    public void execute() {
      launch(historyToken);
    }
  }

  final Model model;
  final Grid rootDisplay= new Grid(2, 1);
  final MenuBar runMenuBar= new MenuBar();
  final VerticalPanel runPanel= new VerticalPanel();
  String startingToken;

  String currentUser;

  Command sorry= new Command() {
    @Override
    public void execute() {
      showAlert("Sorry, this isn't ready yet.");
    }
  };

  public Environment(
      Model aModel, String aToken) {
    model= aModel;
    startingToken= aToken;
  }

  private void createMenu(
      MenuBar mb) {
    // TODO Add user type parameter, for specific menu
    // generation

    mb.addItem("dummy#1", new HistoryCommand(
        DummyOnePresenter.PLACE + "?parameter=value"));
    mb.addItem("Suggest", new HistoryCommand(
        SuggestPresenter.PLACE));
    mb.addItem("Clients", new HistoryCommand(
        ClientDataPresenter.PLACE));

    MenuBar mb2= new MenuBar(true);
    mb2.addItem("subitem1", sorry);
    mb2.addItem("subitem2", sorry);
    mb2.addItem("subitem3", sorry);
    mb2.addItem("subitem4", sorry);
    mb.addItem("submenu", mb2);

    MenuBar mb3= new MenuBar(true);
    mb3.addItem("Browsing", new HistoryCommand(
        CitiesBrowserPresenter.PLACE));
    mb3.addItem("Creating", new HistoryCommand(
        CityCreatorPresenter.PLACE));
    mb.addItem("Cities", mb3);

    mb.addItem("login", new HistoryCommand(
        LoginFormPresenter.PLACE));
  }

  public Model getModel() {
    return model;
  }

  public void launch(
      final String token) {
    launch(token, null);
  }

  public void launch(
      String token, Panel panel) {
    /*
     * There could be parameters after the "#token" in the classic form
     * "?key1=value1&key2=value2..."; for more on this, check
     * http://www.w3.org/TR/hash-in-uri/.
     */
    String args= "";
    int question= token.indexOf("?");
    if (question != -1) {
      args= token.substring(question + 1);
      token= token.substring(0, question);
    }

    /*
     * If no panel is given, use the standard runPanel, and add the token to
     * History.
     */
    if (panel == null) {
      panel= runPanel;
      History.newItem(token);
    }
    panel.clear();

    // TODO Check, before running, if the current user is
    // allowed to run the program

    if (token.isEmpty()) {
      // no need to do anything...
    } else if (token.equals(LoginFormPresenter.PLACE)) {
      showLogin(RootPanel.get());
    } else if (token.equals(DummyOnePresenter.PLACE)) {
      panel.add(new DummyOnePresenter(args, new DummyOneView(),
          this).getDisplay().asWidget());
    } else if (token.equals(SuggestPresenter.PLACE)) {
      panel.add(new SuggestPresenter(args, new SuggestView(),
          this).getDisplay().asWidget());
    } else if (token.equals(ClientDataPresenter.PLACE)) {
      panel.add(new ClientDataPresenter(args,
          new ClientDataView(), this).getDisplay().asWidget());
    } else if (token.equals(ClientSearchPresenter.PLACE)) {
      panel.add(new ClientSearchPresenter(args,
          new ClientSearchView(), this).getDisplay().asWidget());
    } else if (token.equals(CitiesBrowserPresenter.PLACE)) {
      panel
          .add(new CitiesBrowserPresenter(args,
              new CitiesBrowserView(), this).getDisplay()
              .asWidget());
    } else if (token.equals(CityCreatorPresenter.PLACE)) {
      panel.add(new CityCreatorPresenter(args,
          new CityCreatorView(), this).getDisplay().asWidget());
    } else {
      Window.alert("Unrecognized token=" + token);
    }
  }

  public void showAlert(
      String alertText) {
    Window.alert(alertText);
  }

  private void showLogin(
      Panel panel) {
    currentUser= "";

    LoginFormPresenter loginForm= new LoginFormPresenter("",
        new LoginFormView(), this, new SimpleCallback<String>() {
          @Override
          public void goBack(
              String result) {
            currentUser= result;
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
     * If the application was started with a token, now that the user is logged
     * in, it's time to show it. Don't forget to clear startingToken, or after a
     * logout/login, we will go back again to it.
     */
    if (!startingToken.isEmpty()) {
      launch(startingToken);
      startingToken= "";
    }
  }
}
