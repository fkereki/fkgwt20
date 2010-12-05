package com.kereki.pruebamvp.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;

public class LuisViewImpl extends Composite implements LuisView {
	SimplePanel viewPanel= new SimplePanel();
	Label labelOne= new Label();
	Label labelTwo= new Label();

	public LuisViewImpl() {
		viewPanel.add(labelOne);
		viewPanel.add(labelTwo);
		initWidget(viewPanel);
	}

	@Override
	public void setSomething(final String string1, final String string2) {
		labelOne.setText(string1);
		labelTwo.setText(string2);
	}

}
