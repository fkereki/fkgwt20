package com.fkereki.multimedia.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class EmbedAudioElement extends AudioElement {
	public EmbedAudioElement(final String audioUrl) {
		super(audioUrl);
		final HTML audio1= new HTML("<embed id='" + generateId() + "' src='" + audioUrl
		        + "' type='application/x-mplayer2' height='0' width='0' autostart='0' loop='0'></embed>");
		RootPanel.get().add(audio1);
	}
}
