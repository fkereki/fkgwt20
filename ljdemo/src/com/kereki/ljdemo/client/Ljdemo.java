package com.kereki.ljdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Ljdemo implements EntryPoint {
	private final Model ownModel= new Model();

	@Override
	public void onModuleLoad() {
		MainFormView formView= new MainFormView();
		new MainFormPresenter(ownModel, formView);
		RootPanel.get().add(formView);
	}
}
