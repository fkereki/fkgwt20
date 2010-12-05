package com.kereki.pruebamvp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Pruebamvp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be
	 * reached or returns an error.
	 */
	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		final VerticalPanel vp= new VerticalPanel();
		final Label labelEnter= new Label("Enter something:");
		final Button sendButton= new Button("Send");
		final TextBox nameField= new TextBox();

		vp.add(labelEnter);
		vp.add(nameField);
		vp.add(sendButton);

		RootPanel.get().add(vp);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		sendButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				Window.alert("clickity!!");
			}
		});
	}
}
