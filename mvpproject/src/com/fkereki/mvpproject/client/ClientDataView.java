package com.fkereki.mvpproject.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ClientDataView extends View implements
    ClientDataPresenter.ClientDisplay {

  SimpleCallback<Object> searchClickCallback;

  final TextBox clientNumber = new TextBox();
  final Button clientSearchButton = new Button("Search");
  final PopupPanel clientSearchPanel = new PopupPanel(true);
  final ListBox clientSalute = new ListBox();
  final TextBox clientName = new TextBox();
  final TextBox clientAddress = new TextBox();
  final TextBox clientCity = new TextBox();
  final TextBox clientZip = new TextBox();
  final TextBox clientState = new TextBox();
  final FlexTable flex = new FlexTable();


  public ClientDataView() {
    clientSalute.addItem("");
    clientSalute.addItem("Mr");
    clientSalute.addItem("Ms");
    clientZip.setMaxLength(5);
    clientZip.setWidth("30%");
    clientState.setMaxLength(2);
    clientState.setWidth("15%");
    clientSearchPanel.setAnimationEnabled(true);

    flex.setWidget(0, 0, new Label("Number:"));
    flex.setWidget(0, 1, clientNumber);
    flex.setWidget(0, 2, clientSearchButton);

    flex.setWidget(1, 0, new Label("Salutation:"));
    flex.setWidget(1, 1, clientSalute);

    flex.setWidget(2, 0, new Label("Full Name:"));
    flex.setWidget(2, 1, clientName);

    flex.setWidget(3, 0, new Label("Address:"));
    flex.setWidget(3, 1, clientAddress);

    flex.setWidget(4, 0, new Label("City:"));
    flex.setWidget(4, 1, clientCity);

    flex.setWidget(5, 0, new Label("Zip:"));
    flex.setWidget(5, 1, clientZip);

    flex.setWidget(6, 0, new Label("State:"));
    flex.setWidget(6, 1, clientState);

    initWidget(flex);

    clientSearchPanel.add(new Label("searchin'..."));

    clientSearchButton.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        searchClickCallback.goBack(null);
      }
    });
  }


  @Override
  public Widget asWidget() {
    return ClientDataView.this;
  }



  @Override
  public void showPopupPanel() {
    clientSearchPanel.showRelativeTo(clientSearchButton);
    clientSearchPanel.show();
  }


  @Override
  public String getAddress() {
    return clientAddress.getValue();
  }


  @Override
  public String getCity() {
    return clientCity.getValue();
  }


  @Override
  public String getClient() {
    return clientCity.getValue();
  }


  @Override
  public String getName() {
    return clientName.getValue();
  }


  @Override
  public PopupPanel getPopupPanel() {
    return clientSearchPanel;
  }


  @Override
  public String getSalute() {
    return clientSalute.getValue(clientSalute
      .getSelectedIndex());
  }


  @Override
  public String getState() {
    return clientState.getValue();
  }


  @Override
  public String getZip() {
    return clientZip.getValue();
  }


  @Override
  public void setAddress(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setCity(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setClient(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setName(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setSalute(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setState(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setZip(String s) {
    // TODO Auto-generated method stub

  }


  @Override
  public void setSearchClickCallback(
    SimpleCallback<Object> scb) {
    searchClickCallback = scb;
  }


  @Override
  public void hidePopupPanel() {
    clientSearchPanel.hide();
  }
}
