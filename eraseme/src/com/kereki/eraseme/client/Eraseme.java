package com.kereki.eraseme.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Eraseme implements EntryPoint {
  public class SuggestionItem implements Suggestion, IsSerializable {
    private String suggestionText;

    /**
     * Empty constructor: Required for serialization
     */
    public SuggestionItem() {
    }

    /**
     * Simplify creating a straight suggestion item
     */
    public SuggestionItem(String text) {
      suggestionText = text;
    }

    public String getDisplayString() {
      return suggestionText;
    }

    public String getReplacementString() {
      return suggestionText;
    }
  }

  public void onModuleLoad() {
    final VerticalPanel vp = new VerticalPanel();
    final Button unoButton = new Button("Hace sonar al 2");
    final Button dosButton = new Button("Boton 2");

    final TextBox trestexto = new TextBox();
    final TextBox cuatrotexto = new TextBox();

    MultiWordSuggestOracle oracle = new MultiWordSuggestOracle() {
      @Override
      public void requestSuggestions(Request request, Callback callback) {
        Response resp = new Response();
        List<SuggestionItem> suggestions = new ArrayList<SuggestionItem>();

        String beginning = request.getQuery();
        if (beginning.length() > 3) {
          suggestions.add(new SuggestionItem(beginning
              + " It is a good day to die"));
          suggestions.add(new SuggestionItem(beginning + " I shall return"));
          suggestions.add(new SuggestionItem(beginning
              + " There is nothing to fear but fear itself"));
        }
        resp.setSuggestions(suggestions);
        callback.onSuggestionsReady(request, resp);
      }
    };

    SuggestBox box = new SuggestBox(oracle);

    unoButton.addClickHandler(new ClickHandler() {

      @Override
      public void onClick(ClickEvent event) {
        Window.alert("click1");

        // a) Get the current DOM Document, i.e. Document doc =
        // com.google.gwt.dom.client.Document.get();
        // b) Create a click event in that document, e.g. NativeEvent evt =
        // doc.createClickEvent(0, 0, 0, 0, 0, false, false, false, false); (you
        // can read the JavaDoc to see all the arguments' meanings)
        // c) Fire that event on your Button, i.e. DomEvent.fireNativeEvent(evt,
        // button);

        // Document doc = com.google.gwt.dom.client.Document.get();
        // NativeEvent evt = doc.createClickEvent(0, 0, 0, 0, 0, false, false,
        // false, false);

        DomEvent.fireNativeEvent(com.google.gwt.dom.client.Document.get()
            .createClickEvent(0, 0, 0, 0, 0, false, false, false, false),
            dosButton);
      }
    });

    dosButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        Window.alert("soy el dos");
      }
    });

    trestexto.addChangeHandler(new ChangeHandler() {

      @Override
      public void onChange(ChangeEvent event) {
        Window.alert("cambie y soy el 3!");
      }
    });

    cuatrotexto.addChangeHandler(new ChangeHandler() {

      @Override
      public void onChange(ChangeEvent event) {
        Window.alert("cambie yo 4!");

        DomEvent.fireNativeEvent(com.google.gwt.dom.client.Document.get()
            .createChangeEvent(), trestexto);
      }
    });

    vp.add(box);
    vp.add(unoButton);
    vp.add(dosButton);
    vp.add(trestexto);
    vp.add(cuatrotexto);
    RootPanel.get().add(vp);
  }
}
