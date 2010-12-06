package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LuisActivity extends AbstractActivity implements LuisView.Presenter {
	private final Environment environment;
	private final Place place;

	public LuisActivity(final Place place, final Environment environment) {
		Window.alert("luisactivity constructor");
		this.place= place;
		this.environment= environment;
	}

	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		Window.alert("luisactivity start");
		LuisView lv= environment.getNewLuisView();
		lv.setSomething("kreegah", "bundolo!");
		panel.setWidget(lv);
	}

	@Override
	public void goTo(final Place place) {
		Window.alert("luisactivity goto");
		environment.placeController.goTo(place);
	}
}