package com.fkereki.multimedia.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Multimedia implements EntryPoint {
	HTML audioHtml= new HTML("<audio id='audioelement' src='http://www.sound-effect.com/sounds1/office/TYPING_t.wav'>NO AUDIO?</audio>");

	@Override
	public void onModuleLoad() {
		VerticalPanel vp= new VerticalPanel();
		final Button loadAudioButton= new Button("Load Audio");
		final Button playAudioButton= new Button("Play Audio");
		final Button videoButton= new Button("Show Video");
		vp.add(loadAudioButton);
		vp.add(playAudioButton);
		vp.add(videoButton);

		loadAudioButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				RootPanel.get().add(audioHtml);
			}
		});

		playAudioButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				playAudio();
			}
		});

		videoButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				Window.alert("Video!!");
			}
		});

		RootPanel.get().add(vp);
	}

	private native void playAudio() /*-{
		$doc.getElementById("audioelement").play();
	}-*/;
}
