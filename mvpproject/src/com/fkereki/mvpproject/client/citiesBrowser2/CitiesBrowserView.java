/**
 * 
 */
package com.fkereki.mvpproject.client.citiesBrowser2;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.fkereki.mvpproject.client.countryState.CountryStateDisplay;
import com.fkereki.mvpproject.client.countryState.CountryStateView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class CitiesBrowserView
    extends View
    implements CitiesBrowserDisplay {
  @UiTemplate("CitiesBrowserView.ui.xml")
  interface Binder
      extends UiBinder<HTMLPanel, CitiesBrowserView> {
  }

  public static final int CITIES_PAGE_SIZE = 20;

  private static final Binder binder = GWT.create(Binder.class);

  @UiField
  CountryStateView countryStateView;

  @UiField
  FlexTable cg;

  @UiField(provided = true)
  Button firstButton = new Button("First " + CITIES_PAGE_SIZE + " cities");

  @UiField(provided = true)
  Button previousButton = new Button("Previous " + CITIES_PAGE_SIZE);

  @UiField(provided = true)
  Button nextButton = new Button("Next " + CITIES_PAGE_SIZE);

  SimpleCallback<Object> onFirstClickCallback;
  SimpleCallback<Object> onPreviousClickCallback;
  SimpleCallback<Object> onNextClickCallback;
  SimpleCallback<Object> onCountryStateChangeCallback;

  public CitiesBrowserView() {
    super();
    HTMLPanel dlp = binder.createAndBindUi(this);
    initWidget(dlp);

    cg.setText(0, 0, "Name");
    cg.setText(0, 1, "Population");
    cg.setText(0, 2, "Latitude");
    cg.setText(0, 3, "Longitude");
  }

  @Override
  public Widget asWidget() {
    return CitiesBrowserView.this;
  }

  @Override
  public CountryStateDisplay getCountryState() {
    return countryStateView;
  }

  @Override
  public void setCityData(int i, String name, String pop, String lat, String lon) {
    cg.setText(i, 0, name);
    cg.setText(i, 1, pop);
    cg.setText(i, 2, lat);
    cg.setText(i, 3, lon);
  }

  @Override
  public void setOnCountryStateChangeCallback(SimpleCallback<Object> acb) {
    onCountryStateChangeCallback = acb;
  }

  @Override
  public void setOnFirstClickCallback(SimpleCallback<Object> acb) {
    onFirstClickCallback = acb;
  }

  @Override
  public void setOnNextClickCallback(SimpleCallback<Object> acb) {
    onNextClickCallback = acb;
  }

  @Override
  public void setOnPreviousClickCallback(SimpleCallback<Object> acb) {
    onPreviousClickCallback = acb;
  }

  @UiHandler("countryStateView")
  void uiOnChange(ValueChangeEvent<Object> event) {
    onCountryStateChangeCallback.onSuccess(null);
  }

  @UiHandler("firstButton")
  void uiOnFirstClick(ClickEvent event) {
    onFirstClickCallback.onSuccess(null);
  }

  @UiHandler("nextButton")
  void uiOnNextClick(ClickEvent event) {
    onNextClickCallback.onSuccess(null);
  }

  @UiHandler("previousButton")
  void uiOnPreviousClick(ClickEvent event) {
    onPreviousClickCallback.onSuccess(null);
  }
}