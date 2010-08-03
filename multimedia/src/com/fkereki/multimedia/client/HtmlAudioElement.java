package com.fkereki.multimedia.client;

public class HtmlAudioElement extends AudioElement {
	static int audioCounter= 22960;
	int selfCounter= 0;

	protected String generateId() {
		return "audioelement" + selfCounter;
	}

	public HtmlAudioElement(final String audioUrl) {
		super(audioUrl);
		audioCounter++;
		selfCounter= audioCounter;
	}

	@Override
	public native void play() /*-{
		id= this.@com.fkereki.multimedia.client.HtmlAudioElement::generateId()();
		$doc.getElementById(id).play();
	}-*/;
}
