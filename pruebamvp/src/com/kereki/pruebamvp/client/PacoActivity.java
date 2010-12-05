package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class PacoActivity extends AbstractActivity implements PacoView.Presenter {
	private final Environment environment;
	private final Place place;

	public PacoActivity(final Place place, final Environment environment) {
		this.place= place;
		this.environment= environment;
	}

	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		PacoView pv= environment.getNewPacoView();
		pv.setSomething("tarzan king jungle!!");
		panel.setWidget(pv);
	}

	@Override
	public void goTo(final Place place) {
		environment.placeController.goTo(place);
	}
}
