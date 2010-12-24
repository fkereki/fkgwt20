package com.kereki.ljdemo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Ljdemo implements EntryPoint {
    private final Model ownModel= new Model();

    @Override
    public void onModuleLoad() {
        FormView formView= new FormView();
        new FormPresenter(ownModel, formView);
        RootPanel.get().add(formView);
    }
}
