package com.fkereki.multimedia.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Using <embed> is a simple way to get audio in Internet Explorer. Note
 * that we need set the height and width attributes to zero, so the
 * object won't be visible.
 */
public class EmbedAudioElement extends BrowserAudioElement {
	public EmbedAudioElement(final String audioUrl) {
		super(audioUrl);
		final HTML audio1= new HTML("<embed id='" + generateId() + "' src='" + audioUrl
		        + "' type='application/x-mplayer2' height='0' width='0' autostart='0' loop='0'></embed>");
		RootPanel.get().add(audio1);
	}
}
