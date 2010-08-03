package com.fkereki.multimedia.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Multimedia implements EntryPoint {
	// http://www.partnersinrhyme.com/soundfx/Office.shtml

	@Override
	public void onModuleLoad() {
		VerticalPanel vp= new VerticalPanel();

		final Html5AudioElement audio1a= new Html5AudioElement("TYPING_t.wav");
		final Button playAudioButton1a= new Button("Play Audio (Typing) Through HTML5 via JSNI");
		vp.add(playAudioButton1a);
		playAudioButton1a.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				audio1a.play();
			}
		});

		final EmbedAudioElement audio1b= new EmbedAudioElement("TYPING_t.wav");
		final Button playAudioButton1b= new Button("Play Audio (Typing) Through Embedded object");
		vp.add(playAudioButton1b);
		playAudioButton1b.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				audio1b.play();
			}
		});

		final GwtHtml5MediaAudioElement audio2= new GwtHtml5MediaAudioElement("fax2.wav");
		final Button playAudioButton2= new Button("xx Play Audio (Fax) Through gwt_html5_media");
		vp.add(playAudioButton2);
		playAudioButton2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				audio2.play();
			}
		});

		final GwtVoicesAudioElement audio3= new GwtVoicesAudioElement("telephone-ring-1.mp3");
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
