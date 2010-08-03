package com.fkereki.multimedia.client;

import com.fkereki.multimedia.client.gwtHtml5Media.Audio;

public class GwtHtml5MediaAudioElement extends AudioElement {
	final Audio sound;

	public GwtHtml5MediaAudioElement(final String audioUrl) {
		super(audioUrl);
		sound= new Audio(audioUrl);
	}

	@Override
	public void play() {
		sound.play();
	}
}
