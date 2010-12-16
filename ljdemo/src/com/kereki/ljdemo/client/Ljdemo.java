package com.kereki.ljdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Ljdemo implements EntryPoint {
	private Environment ownEnvironment;

	@Override
	public void onModuleLoad() {
		MainFormView formView= new MainFormView();
		MainFormPresenter presenter= new MainFormPresenter(ownEnvironment, formView);
		RootPanel.get().add(formView);
	}
}