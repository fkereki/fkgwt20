package com.fkereki.mvpproject.client.cityCreator;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CityCreatorView extends View implements CityCreatorDisplay {
  @UiTemplate("CityCreatorView.ui.xml")
  interface Binder extends UiBinder<HTMLPanel, CityCreatorView> {
  }

  @UiField
  ListBox countryCode;

  @UiField
  ListBox stateCode;

  @UiField
  TextBox cityName;

  @UiField
  TextBox cityAccentedName;

  @UiField
  TextBox cityPopulation;

  @UiField
  TextBox cityLatitude;

  @UiField
  TextBox cityLongitude;

  @UiField
  Button addCityButton;

  SimpleCallback<Object> onAddClickCallback;
  SimpleCallback<Object> onCountryChangeCallback;

  private static final Binder binder = GWT.create(Binder.class);

  public CityCreatorView() {
    super();
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }

  @Override
  public Widget asWidget() {
    return CityCreatorView.this;
  }

  @Override
  public String getAccentedCityName() {
    return cityAccentedName.getValue();
  }

  @Override
  public String getCityName() {
    return cityName.getValue();
  }

  @Override
  public String getCountry() {
    int current = countryCode.getSelectedIndex();
    return current == -1 ? "" : countryCode.getValue(current);
  }

  @Override
  public float getLatitude() {
    return Float.parseFloat(cityLatitude.getValue());
  }

  @Override
  public float getLongitude() {
    return Float.parseFloat(cityLongitude.getValue());
  }

  @Override
  public int getPopulation() {
    return Integer.parseInt(cityPopulation.getValue());
  }

  @Override
  public String getState() {
    int current = stateCode.getSelectedIndex();
    return current == -1 ? "" : stateCode.getValue(current);
  }

  @Override
  public void setCountryList(LinkedHashMap<String, String> cl) {
    countryCode.clear();
    if (cl != null) {
      countryCode.addItem("--Select a country--", "");
      for (final String it : cl.keySet()) {
        countryCode.addItem(cl.get(it), it);
      }
    }
  }

  @Override
  public void setOnAddClickCallback(SimpleCallback<Object> acb) {
    onAddClickCallback = acb;
  }

  @Override
  public void setOnCountryChangeCallback(SimpleCallback<Object> acb) {
    onCountryChangeCallback = acb;
  }

  @Override
  public void setStateList(LinkedHashMap<String, String> sl) {
    stateCode.clear();
    if (sl != null) {
      stateCode.addItem("--Select a state--", "");
      for (final String it : sl.keySet()) {
        stateCode.addItem(sl.get(it), it);
      }
    }
  }

  @UiHandler("addCityButton")
  void uiOnAddCityClick(ClickEvent event) {
    onAddClickCallback.onSuccess(null);
  }

  @UiHandler("countryCode")
  void uiOnCountryChange(ChangeEvent event) {
    onCountryChangeCallback.onSuccess(null);
  }
}