package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PacoActivity extends AbstractActivity implements PacoView.Presenter {
	private final Environment environment;
	private final Place place;
	private PacoView pv;

	public PacoActivity(final Place place, final Environment environment) {
		this.place= place;
		this.environment= environment;
	}

	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		pv= environment.getNewPacoView();
		pv.setPresenter(this);
		panel.setWidget(pv);
	}

	@Override
	public void goTo(final Place place) {
		environment.placeController.goTo(place);
	}

	@Override
	public void onSumaClick() {
		int a= pv.get1stNumber();
		int b= pv.get2ndNumber();
		pv.setSum(a + b);
	}
}
