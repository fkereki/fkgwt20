package com.kereki.pruebamvp.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class PacoViewImpl extends Composite implements PacoView {
	PacoView.Presenter presenter;

	FlexTable ft= new FlexTable();
	Label lbl1= new Label("1r número:");
	Label lbl2= new Label("2o número:");
	TextBox tb1= new TextBox();
	TextBox tb2= new TextBox();
	Button btn= new Button("Sumar:");
	TextBox tb3= new TextBox();

	public PacoViewImpl() {
		tb3.setReadOnly(true);

		ft.setWidget(0, 0, lbl1);
		ft.setWidget(0, 1, tb1);
		ft.setWidget(1, 0, lbl2);
		ft.setWidget(1, 1, tb2);
		ft.setWidget(2, 0, btn);
		ft.setWidget(2, 1, tb3);
		initWidget(ft);
	}

	@Override
	public void setPresenter(final Presenter presenter) {
		this.presenter= presenter;

		btn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				presenter.onSumaClick();
			}
		});
	}

	@Override
	public int get1stNumber() {
		return Integer.parseInt(tb1.getValue());
	}

	@Override
	public int get2ndNumber() {
		return Integer.parseInt(tb2.getValue());
	}

	@Override
	public void setSum(final int aNumber) {
		tb3.setValue("" + aNumber);
	}
}
