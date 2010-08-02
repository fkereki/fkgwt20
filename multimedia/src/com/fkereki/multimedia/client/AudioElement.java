package com.fkereki.multimedia.client;

public class AudioElement {
	static int audioCounter= 22960;
	int selfCounter= 0;

	protected String generateId() {
		return "audioelement" + selfCounter;
	}

	// public native void showCounter() /*-{
	// alert("audioelement..."+this.@com.fkereki.multimedia.client.AudioElement::audioCounter);
	// call=this.@com.fkereki.multimedia.client.AudioElement::generateId()();
	// alert("function..."+call);
	// }-*/;

	public AudioElement(final String audioUrl) {
		audioCounter++;
		selfCounter= audioCounter;
	}

	public native void play() /*-{
		id= this.@com.fkereki.multimedia.client.AudioElement::generateId()();
		$doc.getElementById(id).play();
	}-*/;
}
