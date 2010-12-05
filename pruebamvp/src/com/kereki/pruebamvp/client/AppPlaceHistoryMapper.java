package com.kereki.pruebamvp.client;

import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ HugoPlace.Tokenizer.class, PacoPlace.Tokenizer.class, LuisPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends com.google.gwt.place.shared.PlaceHistoryMapper {

}
