package com.fkereki.mvpproject.client.dummyTwo;

import com.fkereki.mvpproject.client.View;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.Widget;

public class DummyTwoView extends View implements DummyTwoDisplay {

  FlexTable ft = new FlexTable();
  SuggestBox sb;

  public DummyTwoView() {
    ft.setWidget(0, 0, new Label("Pick a New York city:"));
    ft.setWidget(0, 1, new SuggestBox());
    initWidget(ft);
  }

  @Override
  public Widget asWidget() {
    return DummyTwoView.this;
  }

  @Override
  public void setCitiesOracle(MultiWordSuggestOracle oracle) {
    sb = new SuggestBox(oracle);
    ft.setWidget(0, 1, sb);
  }
}