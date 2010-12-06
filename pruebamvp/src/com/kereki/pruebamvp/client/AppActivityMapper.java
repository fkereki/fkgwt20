package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;

public class AppActivityMapper implements ActivityMapper {
	private final Environment environment;

	public AppActivityMapper(final Environment environment) {
		super();
		this.environment= environment;
	}

	@Override
	public Activity getActivity(final Place place) {
		Window.alert("appactivitymapper getactivity");

		if (place instanceof HugoPlace) {
			Window.alert("getactivity hugoplace");
			return new HugoActivity(place, this.environment);
		} else if (place instanceof LuisPlace) {
			Window.alert("getactivity luisplace");
			return new LuisActivity(place, this.environment);
		} else if (place instanceof PacoPlace) {
			Window.alert("pacoplace");
			return new PacoActivity(place, this.environment);
		} else {
			return null;
		}
	}

}
