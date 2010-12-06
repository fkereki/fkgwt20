package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class PacoPlace extends Place {
	public PacoPlace(final String token) {
		// Window.alert("pacoplace constructor >>" + token + "<<");
	}

	public static class Tokenizer implements PlaceTokenizer<PacoPlace> {

		@Override
		public PacoPlace getPlace(final String token) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getToken(final PacoPlace place) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
