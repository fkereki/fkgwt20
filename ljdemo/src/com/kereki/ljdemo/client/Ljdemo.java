package com.kereki.ljdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Ljdemo implements EntryPoint {
	private final Environment ownEnvironment= new Environment();

	@Override
	public void onModuleLoad() {
		MainFormView formView= new MainFormView();
		new MainFormPresenter(ownEnvironment, formView);
		RootPanel.get().add(formView);
	}
}
