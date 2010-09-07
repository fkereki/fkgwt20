package com.fkereki.domousage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Domousage implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Button drawGraphButton= new Button("Click me for a graph");
		RootPanel.get().add(drawGraphButton);

		drawGraphButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				llamadaJSNI();
			}
		});

	}

	public native void llamadaJSNI() /*-{
		$wnd.drawChart("simplechart");
	}-*/;
}
