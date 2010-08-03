package com.fkereki.multimedia.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;

public class GwtVoicesAudioElement extends AudioElement {
	final SoundController soundController= new SoundController();
	final Sound sound;

	public GwtVoicesAudioElement(final String audioUrl) {
		super(audioUrl);
		sound= soundController.createSound(Sound.MIME_TYPE_AUDIO_MPEG, audioUrl);
	}

	@Override
	public void play() {
		sound.play();
	}
}
