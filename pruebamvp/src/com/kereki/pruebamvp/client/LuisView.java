package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface LuisView extends IsWidget {
	void setSomething(String string1, String string2);

	public interface Presenter {
		void goTo(Place place);
	}
}
