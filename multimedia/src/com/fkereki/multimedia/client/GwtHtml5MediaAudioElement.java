package com.fkereki.multimedia.client;

import com.fkereki.multimedia.client.gwtHtml5Media.Audio;

/**
 * The gwt-html5-media library at
 * http://code.google.com/p/gwt-html5-media/ provides both audio and
 * video support.
 */
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
