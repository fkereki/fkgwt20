package com.fkereki.multimedia.client;

/**
 * Define the base class for all audio elements. Since there is no
 * standard audio class, we don't want to directly work with any
 * specific classes.
 * 
 * Note that this is actually an Adapter pattern; see
 * http://c2.com/cgi/wiki?AdapterPattern or
 * http://en.wikipedia.org/wiki/Adapter_pattern for more on this.
 */
public abstract class AudioElement {
	public AudioElement(final String audioUrl) {
	}

	public abstract void play();
}
