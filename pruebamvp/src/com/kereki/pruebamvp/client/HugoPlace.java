package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HugoPlace extends Place {
	private final String hugoName;

	public HugoPlace(final String token) {
		// Window.alert("hugoplace constructor >>" + token + "<<");
		this.hugoName= token;
	}

	public String getHugoName() {
		return this.hugoName;
	}

	public static class Tokenizer implements PlaceTokenizer<HugoPlace> {

		@Override
		public HugoPlace getPlace(final String token) {
			// Window.alert("hugoplace tokenizer getplace token >>" +
			// token + " <<");
			return new HugoPlace(token);
		}

		@Override
		public String getToken(final HugoPlace place) {
			// Window.alert("hugoplace tokenizer getToken ");
			return null;
		}
	}
}
