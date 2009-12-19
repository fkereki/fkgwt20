/**
 * 
 */
package com.fkereki.mvpproject.client.citiesBrowser;

import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.SimpleCallback;
import com.fkereki.mvpproject.client.View;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CitiesBrowserView extends View implements CitiesBrowserDisplay {

  public static final int CITIES_PAGE_SIZE = 20;

  final ListBox countryCode = new ListBox();
  final ListBox stateCode = new ListBox();

  final VerticalPanel vp = new VerticalPanel();
  final HorizontalPanel ht1 = new HorizontalPanel();
  final HorizontalPanel ht2 = new HorizontalPanel();

  final FlexTable cg = new FlexTable();
  final Button firstButton = new Button("First " + CITIES_PAGE_SIZE + " cities");
  final Button previousButton = new Button("Previous " + CITIES_PAGE_SIZE);
  final Button nextButton = new Button("Next " + CITIES_PAGE_SIZE);

  SimpleCallback<Object> onFirstClickCallback;
  SimpleCallback<Object> onPreviousClickCallback;
  SimpleCallback<Object> onNextClickCallback;
  SimpleCallback<Object> onCountryChangeCallback;

  public CitiesBrowserView() {
    super();

    cg.setText(0, 0, "City");
    cg.setText(0, 1, "Population");
    cg.setText(0, 2, "Latitude");
    cg.setText(0, 3, "Longitude");

    ht1.add(new Label("Country/State:"));
    ht1.add(countryCode);
    ht1.add(stateCode);

    ht2.add(firstButton);
    ht2.add(previousButton);
    ht2.add(nextButton);

    vp.add(ht1);
    vp.add(ht2);
    vp.add(cg);

    initWidget(vp);

    firstButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        onFirstClickCallback.onSuccess(null);
      }
    });

    previousButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        onPreviousClickCallback.onSuccess(null);
      }
    });

    nextButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        onNextClickCallback.onSuccess(null);
      }
    });

    countryCode.addChangeHandler(new ChangeHandler() {
      @Override
      public void onChange(ChangeEvent event) {
        onCountryChangeCallback.onSuccess(null);
      }
    });
  }

  @Override
  public Widget asWidget() {
    return CitiesBrowserView.this;
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
  public void setCityLatitude(int i, String n) {
    cg.setText(i, 2, n);
  }

  @Override
  public void setCityLongitude(int i, String n) {
    cg.setText(i, 3, n);
  }

  @Override
  public void setCityName(int i, String n) {
    cg.setText(i, 0, n);
  }

  @Override
  public void setCityPopulation(int i, String n) {
    cg.setText(i, 1, n);
  }

  @Override
  public void setCountryList(LinkedHashMap<String, String> cl) {
    countryCode.clear();
    if (cl != null) {
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

  @Override
  public void setStateList(LinkedHashMap<String, String> sl) {
    stateCode.clear();
    if (sl != null) {
      for (final String it : sl.keySet()) {
        stateCode.addItem(sl.get(it), it);
      }
    }
  }
}
