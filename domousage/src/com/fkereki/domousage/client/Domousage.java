package com.fkereki.domousage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Domousage implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Button drawGraphButton= new Button("Click me for a graph");
		RootPanel.get().add(drawGraphButton);

		HTML html= new HTML();
		html.setHeight("200px");
		html.setWidth("400px");
		html.getElement().setId("newchart");
		RootPanel.get().add(html);

		final JsArrayNumber vectorcito= (JsArrayNumber) JavaScriptObject.createArray();
		vectorcito.push(1);
		vectorcito.push(4);
		vectorcito.push(2);
		vectorcito.push(6);
		vectorcito.push(3);
		vectorcito.push(21);
		vectorcito.push(21);
		vectorcito.push(20);

		drawGraphButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				llamadaJSNI(vectorcito);
			}
		});
	}

	public native void llamadaJSNI(JsArrayNumber vvvv) /*-{
		$wnd.drawChart("newchart", vvvv);
	}-*/;
}
