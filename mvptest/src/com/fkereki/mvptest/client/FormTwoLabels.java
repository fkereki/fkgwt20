package com.fkereki.mvptest.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO Add security checks, so unauthorized users
// cannot get to a function just by entering the
// appropriate token

public class FormTwoLabels extends Composite {
  PopupPanel pup = new PopupPanel(true);

  public FormTwoLabels(final Mvptest main, String params) {
    KeyValueMap kvm = new KeyValueMap(params);

    VerticalPanel panel = new VerticalPanel();
    panel.add(new Label("kvm..." + kvm.get("pepe")));
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
        pup.showRelativeTo(popupOpener);
        pup.show();
        main.executeInPanel(pup, "foo?pepe=termina ahora");
      }
    });

    initWidget(panel);
  }
}