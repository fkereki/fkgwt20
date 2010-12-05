package com.kereki.pruebamvp.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class PacoViewImpl extends Composite implements PacoView {
	HorizontalPanel hp= new HorizontalPanel();
	Label lb= new Label();

	public PacoViewImpl() {
		hp.add(lb);
		initWidget(hp);
	}

	@Override
	public void setSomething(final String aString) {
		lb.setText(aString);
	}

	@Override
	public String getSomething() {
		return lb.getText() + "//" + lb.getText();
	}
}
