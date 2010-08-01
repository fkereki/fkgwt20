package com.fkereki.multimedia.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
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

		// versión Windows:
		/*
		 * <embed id="mysound") src="TYPING_t.wav" height="0" width="0" type="application/x-mplayer2" autostart="0"
		 * loop="0"></embed>
		 */

		final HTML audio1= new HTML("<audio id='audioelement' src='TYPING_t.wav' />");
		RootPanel.get().add(audio1);
		final Button playAudioButton1= new Button("Play Audio (Typing) Through HTML5 via JSNI");
		vp.add(playAudioButton1);
		playAudioButton1.addClickHandler(new ClickHandler() {
			@Override
			public native void onClick(final ClickEvent event) /*-{
		$doc.getElementById("audioelement").play();
	}-*/;
		});

		final Audio audio2= new Audio("fax2.wav");
		final Button playAudioButton2= new Button("Play Audio (Fax) Through gwt_html5_media");
		vp.add(playAudioButton2);
		playAudioButton2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				audio2.play();
			}
		});

		final SoundController soundController= new SoundController();
		final Sound audio3= soundController.createSound(Sound.MIME_TYPE_AUDIO_MPEG, "telephone-ring-1.mp3");
		final Button playAudioButton3= new Button("Play Audio (Phone) Through gwt_voices");
		vp.add(playAudioButton3);
		playAudioButton3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				audio3.play();
			}
		});

		RootPanel.get().add(vp);

	}
}
