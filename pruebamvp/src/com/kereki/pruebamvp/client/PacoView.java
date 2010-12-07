package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface PacoView extends IsWidget {
	public void setPresenter(final PacoView.Presenter presenter);

	public int get1stNumber();

	public int get2ndNumber();

	public void setSum(int aNumber);

	public interface Presenter {
		void goTo(Place place);

		void onSumaClick();
	}

}
