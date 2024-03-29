package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LuisPlace extends Place {

	public LuisPlace(final String token) {
		// Window.alert("luisplace constructor >>" + token + "<<");
	}

	public static class Tokenizer implements PlaceTokenizer<LuisPlace> {

		@Override
		public LuisPlace getPlace(final String token) {
			// Window.alert("luisplace tokenizer getplace " + token);
			return new LuisPlace(token);
		}

		@Override
		public String getToken(final LuisPlace place) {
			return null;
		}
	}
}
