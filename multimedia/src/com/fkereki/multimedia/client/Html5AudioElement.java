package com.fkereki.multimedia.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * This is a straightforward usage of the HTML5 <audio> tag. There are
 * many parameters that could be used, but for our limited objectives,
 * this is enough.
 * 
 * See http://www.whatwg.org/specs/web-apps/current-work/#audio for more
 * on this tag.
 */
public class Html5AudioElement extends BrowserAudioElement {
	public Html5AudioElement(final String audioUrl) {
		super(audioUrl);
		final HTML audio1= new HTML("<audio id='" + generateId() + "' src='" + audioUrl + "' />");
		RootPanel.get().add(audio1);
	}
}
