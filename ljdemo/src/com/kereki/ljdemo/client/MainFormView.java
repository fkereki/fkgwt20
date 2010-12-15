package com.kereki.ljdemo.client;

public class MainFormView extends View implements MainFormPresenter.ViewInterface {

	@Override
	public int getFirstNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSecondNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getThirdNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPresenter(final MainFormPresenter aPresenter) {
		this.ownPresenter= aPresenter;
	}
}
