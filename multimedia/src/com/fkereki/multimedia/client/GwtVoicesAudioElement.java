package com.fkereki.multimedia.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;

/**
 * The gwt-voices library at http://code.google.com/p/gwt-voices/ uses a
 * small Flash object to actually play sound. The only real problem
 * might be either a Flash-plugin-less browser, or a browser with an
 * installed Flash blocker.
 */
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
