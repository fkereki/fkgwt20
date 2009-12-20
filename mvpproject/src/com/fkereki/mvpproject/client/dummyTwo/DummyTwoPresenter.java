package com.fkereki.mvpproject.client.dummyTwo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.fkereki.mvpproject.client.ClientCityData;
import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SuggestionItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public class DummyTwoPresenter extends Presenter<DummyTwoDisplay> {

  public static String PLACE = "baz";

  public DummyTwoPresenter(String params, DummyTwoDisplay dummyTwoDisplay,
      Environment environment) {

    super(params, dummyTwoDisplay, environment);

    getDisplay().setCitiesOracle(new MultiWordSuggestOracle() {
      @Override
      public void requestSuggestions(Request request, Callback callback) {
        final Request savedRequest = request;
        final Callback savedCallback = callback;
        final Response response = new Response();
        final ArrayList<SuggestionItem> suggestionsList = new ArrayList<SuggestionItem>();

        /*
         * If the query is more than two characters long, let's do a search;
         * otherwise, just return no suggestions. We'll also return no
         * suggestions if the search happens to fail for some reason.
         */
        String beginning = request.getQuery();
        if (beginning.length() > 2) {
          getEnvironment().getModel().getRemoteWorldService()
              .getCitiesStartingWith("US", "NY", request.getQuery(),
                  new AsyncCallback<LinkedHashMap<String, ClientCityData>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                      response.setSuggestions(suggestionsList);
                      savedCallback.onSuggestionsReady(savedRequest, response);
                    }

                    @Override
                    public void onSuccess(
                        LinkedHashMap<String, ClientCityData> result) {

                      for (final String it : result.keySet()) {
                        suggestionsList.add(new SuggestionItem(
                            result.get(it).cityName));
                      }
                      response.setSuggestions(suggestionsList);
                      savedCallback.onSuggestionsReady(savedRequest, response);
                    }
                  });
        } else {
          response.setSuggestions(suggestionsList);
          callback.onSuggestionsReady(request, response);
        }
      }
    });
  }
}