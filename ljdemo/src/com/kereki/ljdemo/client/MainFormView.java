package com.kereki.ljdemo.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class MainFormView extends Composite implements MainFormPresenter.ViewInterface {
	private MainFormPresenter ownPresenter;
	private final FlexTable ft= new FlexTable();
	private final TextBox tf1= new TextBox();
	private final TextBox tf2= new TextBox();
	private final TextBox tf3= new TextBox();
	private final Button btn= new Button("Average");

	@Override
	public String getFirstText() {
		return tf1.getValue();
	}

	@Override
	public String getSecondText() {
		// TODO Auto-generated method stub
		return tf2.getValue();
	}

	@Override
	public String getThirdText() {
		return tf3.getValue();
	}

	@Override
	public void setPresenter(final MainFormPresenter aPresenter) {
		this.ownPresenter= aPresenter;
	}

	public MainFormView() {
		super();
		ft.setWidget(0, 0, new Label("First number:"));
		ft.setWidget(0, 1, tf1);
		ft.setWidget(1, 0, new Label("Second number:"));
		ft.setWidget(1, 1, tf2);
		ft.setWidget(2, 0, new Label("Third number:"));
		ft.setWidget(2, 1, tf3);
		ft.setWidget(3, 1, btn);
		initWidget(ft);

		btn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ownPresenter.onAverageClick();
			}
		});
	}
}
