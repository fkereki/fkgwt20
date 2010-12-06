package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HugoActivity extends AbstractActivity implements HugoView.Presenter {
	private final Environment environment;
	private final Place place;

	public HugoActivity(final Place place, final Environment environment) {
		Window.alert("hugoactivity constructor");
		this.place= place;
		this.environment= environment;
	}

	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		Window.alert("hugoactivity start");

		HugoView hv= environment.getNewHugoView();
		hv.setName("unga hugo bunga");
		hv.setLink("LuisPlace:");
		panel.setWidget(hv);
	}

	@Override
	public void goTo(final Place place) {
		Window.alert("hugoactivity goto");
		environment.placeController.goTo(place);
	}
}
