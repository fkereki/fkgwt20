package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DummyOneView extends View implements
    DummyOnePresenter.DummyOneDisplay {

  String pepeValue = "";

  public DummyOneView() {
    VerticalPanel panel = new VerticalPanel();
    panel.add(new Label("kvm..." + pepeValue));
    panel.add(new Label("dos"));
    panel.add(new Hyperlink("vamos al foo",
      "foo?pepe=continua"));
    panel.add(new Hyperlink("vamos al bar", "bar"));
    panel.add(new Hyperlink("vamos al baZ", "baz"));
    panel.add(new Label(""));

    final Button popupOpener = new Button("Click me");
    panel.add(popupOpener);

    popupOpener.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        // pup.showRelativeTo(popupOpener);
        // pup.show();
        // main.executeInPanel(pup,
        // "foo?pepe=termina ahora");
      }
    });
  }



  @Override
  public Widget asWidget() {
    return DummyOneView.this;
  }



  @Override
  public void setPepeValue(String s) {
    pepeValue = s;
  }
}
