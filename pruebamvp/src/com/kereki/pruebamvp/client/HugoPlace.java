package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.user.client.Window;

public class HugoPlace extends Place {
	private final String hugoName;

	public HugoPlace(final String token) {
		this.hugoName= token;
	}

	public String getHugoName() {
		return this.hugoName;
	}

	public static class Tokenizer implements PlaceTokenizer<HugoPlace> {

		@Override
		public HugoPlace getPlace(final String token) {
			Window.alert("hugoplace tokenizer getplace token >>" + token + " <<");
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getToken(final HugoPlace place) {
			Window.alert("hugoplace tokenizer getToken ");
			// TODO Auto-generated method stub
			return null;
		}
	}
}
