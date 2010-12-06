package com.kereki.pruebamvp.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HugoViewImpl extends Composite implements HugoView {
	VerticalPanel vp= new VerticalPanel();
	Label label= new Label("Hugo label:");
	TextBox tb= new TextBox();
	Hyperlink hl= new Hyperlink();

	public HugoViewImpl() {
		vp.add(label);
		vp.add(tb);
		vp.add(hl);
		initWidget(vp);
	}

	@Override
	public void setName(final String aString) {
		tb.setText(aString);

	}

	@Override
	public void setLink(final String destination) {
		hl.setText("Saltemos a...");
		hl.setTargetHistoryToken(destination);
	}
}
