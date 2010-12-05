package com.kereki.pruebamvp.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Pruebamvp implements EntryPoint {
	private final Place defaultPlace= new HugoPlace("defaultdehugo");
	private final SimplePanel appWidget= new SimplePanel();

	@Override
	public void onModuleLoad() {
		Environment environment= new Environment();
		EventBus eventBus= environment.eventBus;
		PlaceController placeController= environment.placeController;

		ActivityMapper activityMapper= new AppActivityMapper(environment);
		ActivityManager activityManager= new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler= new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get().add(appWidget);
		historyHandler.handleCurrentHistory();
	}
}
