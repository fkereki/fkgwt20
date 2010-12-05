package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	private final Environment environment;

	public AppActivityMapper(final Environment environment) {
		super();
		this.environment= environment;
	}

	@Override
	public Activity getActivity(final Place place) {
		if (place instanceof HugoPlace) {
			return new HugoActivity(place, this.environment);
		} else if (place instanceof LuisPlace) {
			return new LuisActivity(place, this.environment);
		} else if (place instanceof PacoPlace) {
			return new PacoActivity(place, this.environment);
		}
	}

}
