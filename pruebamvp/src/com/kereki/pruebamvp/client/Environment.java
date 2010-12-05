package com.kereki.pruebamvp.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class Environment {
	public final String nombreSistema= "Sobrinos de Donald";
	public final EventBus eventBus= new SimpleEventBus();
	public final PlaceController placeController= new PlaceController(eventBus);

	HugoView getNewHugoView() {
		return new HugoViewImpl();
	}

	LuisView getNewLuisView() {
		return new LuisViewImpl();
	}

	PacoView getNewPacoView() {
		return new PacoViewImpl();
	}

}
