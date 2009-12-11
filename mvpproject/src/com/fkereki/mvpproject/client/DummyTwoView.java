package com.fkereki.mvpproject.client;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class DummyTwoView
    extends View implements DummyTwoDisplay {

  public DummyTwoView() {
    FlexTable ft= new FlexTable();
    ft.setWidget(0, 0, new Label("allzero"));
    ft.setWidget(0, 1, new Label("000-111"));
    ft.setWidget(1, 0, new Label("10"));
    ft.setWidget(1, 1, new Label("111111"));
    initWidget(ft);
  }

  @Override
  public Widget asWidget() {
    // TODO Auto-generated method stub
    return DummyTwoView.this;
  }
}
