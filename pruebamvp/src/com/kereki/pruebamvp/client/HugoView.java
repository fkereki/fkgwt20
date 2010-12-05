package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface HugoView extends IsWidget {
	void setName(String aString);

	public interface Presenter {
		void goTo(Place place);
	}
}
