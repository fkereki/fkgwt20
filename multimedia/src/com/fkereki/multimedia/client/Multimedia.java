package com.fkereki.multimedia.client;

import com.fkereki.multimedia.client.gwtHtml5Media.Audio;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Multimedia implements EntryPoint {
	// http://www.partnersinrhyme.com/soundfx/Office.shtml

	@Override
	public void onModuleLoad() {
		VerticalPanel vp= new VerticalPanel();

		final HTML audio1= new HTML("<audio id='audioelement' src='http://www.sound-effect.com/sounds1/office/TYPING_t.wav'>NO AUDIO?</audio>");
		RootPanel.get().add(audio1);

		final Button playAudioButton1= new Button("Play Audio Through HTML5 via JSNI");
		vp.add(playAudioButton1);
		playAudioButton1.addClickHandler(new ClickHandler() {
			@Override
			public native void onClick(final ClickEvent event) /*-{
		$doc.getElementById("audioelement").play();
	}-*/;
		});

		final Audio audio2= new Audio("http://www.sound-effect.com/sounds1/office/fax2.wav");
		final Button playAudioButton2= new Button("Play Audio Through gwt_html5_media");
		vp.add(playAudioButton2);
		playAudioButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				audio2.play();
			}
		});

		RootPanel.get().add(vp);
	}

}
