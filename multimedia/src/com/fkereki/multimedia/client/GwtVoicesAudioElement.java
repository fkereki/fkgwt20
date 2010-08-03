package com.fkereki.multimedia.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;

public class GwtVoicesAudioElement extends AudioElement {
	final SoundController soundController= new SoundController();
	final Sound sound;

	public GwtVoicesAudioElement(final String url) {
		super(url);
		sound= soundController.createSound(Sound.MIME_TYPE_AUDIO_MPEG, url);
	}

	@Override
	public void play() {
		sound.play();
	}
}
