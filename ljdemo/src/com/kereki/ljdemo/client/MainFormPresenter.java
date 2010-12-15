package com.kereki.ljdemo.client;

public class MainFormPresenter extends Presenter {

	public interface ViewInterface {
		int getFirstNumber();

		int getSecondNumber();

		int getThirdNumber();

		void setPresenter(MainFormPresenter aPresenter);
	}
}
