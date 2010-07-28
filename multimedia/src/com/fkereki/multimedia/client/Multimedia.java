package com.fkereki.multimedia.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Multimedia implements EntryPoint {
	@Override
	public void onModuleLoad() {
		VerticalPanel vp= new VerticalPanel();
		final Button audioButton= new Button("Play Music");
		final Button videoButton= new Button("Show Video");
		vp.add(audioButton);
		vp.add(videoButton);

		audioButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				Window.alert("Music!");
			}
		});

		videoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				Window.alert("Video!");
			}
		});

		RootPanel.get().add(vp);
	}
}
