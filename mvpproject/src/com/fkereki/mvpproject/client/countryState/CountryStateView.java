package com.fkereki.mvpproject.client.countryState;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;

public class CountryStateView
    extends View
    implements CountryStateDisplay {
  @UiTemplate("CountryStateView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, CountryStateView> {
  }

  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  ListBox countryCode;

  @UiField
  ListBox stateCode;

  SimpleCallback<Object> onCountryChangeCallback;
  SimpleCallback<Object> onStateChangeCallback;

  public CountryStateView() {
    super();
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);
  }

  @Override
  public HandlerRegistration addValueChangeHandler(
      ValueChangeHandler<Object> handler) {
    return addHandler(handler, ValueChangeEvent.getType());
  }

  @Override
  public String getCountry() {
    int current = countryCode.getSelectedIndex();
    return current == -1 ? "" : countryCode.getValue(current);
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
  public void setOnCountryChangeCallback(SimpleCallback<Object> acb) {
    onCountryChangeCallback = acb;
  }

  @Override
  public void setOnStateChangeCallback(SimpleCallback<Object> acb) {
    onStateChangeCallback = acb;
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

  @UiHandler("countryCode")
  void uiOnCountryChange(ChangeEvent event) {
    onCountryChangeCallback.onSuccess(null);
  }

  @UiHandler("stateCode")
  void uiOnStateChange(ChangeEvent event) {
    onStateChangeCallback.onSuccess(null);
  }

}
