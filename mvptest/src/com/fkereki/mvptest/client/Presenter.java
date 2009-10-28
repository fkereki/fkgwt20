package com.fkereki.mvptest.client;

abstract public class Presenter {
	Display display;
	Model model;


	public Presenter() {
	}


	public Presenter(Display aDisplay, Model aModel) {
		super();
		display = aDisplay;
		model = aModel;
	}


	public Model getModel() {
		return model;
	}


	public Display getDisplay() {
		return display;
	}
}
