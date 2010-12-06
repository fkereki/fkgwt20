package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.user.client.Window;

public class LuisPlace extends Place {

	public LuisPlace(final String token) {
		Window.alert("luisplace constructor >>" + token + "<<");
	}

	public static class Tokenizer implements PlaceTokenizer<LuisPlace> {

		@Override
		public LuisPlace getPlace(final String token) {
			Window.alert("luisplace tokenizer getplace " + token);
			return new LuisPlace(token);
		}

		@Override
		public String getToken(final LuisPlace place) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
