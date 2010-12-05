package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface PacoView extends IsWidget {
	void setSomething(String aString);

	String getSomething();

	public interface Presenter {
		void goTo(Place place);
	}

}
