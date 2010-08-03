package com.fkereki.multimedia.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Html5AudioElement extends HtmlAudioElement {
	public Html5AudioElement(final String audioUrl) {
		super(audioUrl);
		final HTML audio1= new HTML("<audio id='" + generateId() + "' src='" + audioUrl + "' />");
		RootPanel.get().add(audio1);
	}
}
