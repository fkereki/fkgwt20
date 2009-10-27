package com.fkereki.mvptest.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

// TODO Add security checks, so unauthorized users
// cannot get to a function just by entering the
// appropriate token

public class FormManyFields extends Composite {
	public FormManyFields(final Mvptest main, String params) {
		FlexTable ft = new FlexTable();
		ft.setWidget(0, 0, new Label("allzero"));
		ft.setWidget(0, 1, new Label("000-111"));
		ft.setWidget(1, 0, new Label("10"));
		ft.setWidget(1, 1, new Label("111111"));
		initWidget(ft);
	}
}