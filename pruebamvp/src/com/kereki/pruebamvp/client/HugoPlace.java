package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getToken(final HugoPlace place) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
