package com.fkereki.multimedia.client;

/**
 * This is the base class we'll be using for browser-defined audio
 * elements, such as HTML5's <audio> tag, or Internet Explorer's <embed>
 * tag. We are taking advantage here that both those objects have a
 * play() method; otherwise, we'd have to write separate definitions.
 * 
 * For the play() method to work, we need have a distinct id value for
 * the browser element, and we use audioCounter statically so each new
 * object will get a new id. Note the usage of JSNI in play(), to call
 * the (Java) generateId() method.
 */
public abstract class BrowserAudioElement extends AudioElement {
	static int audioCounter= 22960;
	int selfCounter= 0;

	protected String generateId() {
		return "audioelement" + selfCounter;
	}

	public BrowserAudioElement(final String audioUrl) {
		super(audioUrl);
		audioCounter++;
		selfCounter= audioCounter;
	}

	@Override
	public native void play() /*-{
		id= this.@com.fkereki.multimedia.client.BrowserAudioElement::generateId()();
		$doc.getElementById(id).play();
	}-*/;
}
