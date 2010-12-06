package com.kereki.pruebamvp.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LuisViewImpl extends Composite implements LuisView {
	VerticalPanel viewPanel= new VerticalPanel();
	Label labelOne= new Label();
	Label labelTwo= new Label();

	public LuisViewImpl() {
		Window.alert("luisviewimpl constructor");
		viewPanel.add(labelOne);
		viewPanel.add(labelTwo);
		initWidget(viewPanel);
	}

	@Override
	public void setSomething(final String string1, final String string2) {
		Window.alert("luisviewimpl setsomething");
		labelOne.setText(string1);
		labelTwo.setText(string2);
	}
}
