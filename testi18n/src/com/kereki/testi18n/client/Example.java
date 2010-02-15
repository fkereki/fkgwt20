package com.kereki.testi18n.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Example
    extends Widget {

  interface MyUiBinder
      extends UiBinder<HTMLPanel, Example> {
  }

  private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

  @UiField
  Button aButton;

  public Example() {
    RootPanel.get().add(uiBinder.createAndBindUi(this));
  }

  // need for the -soyc parameter (click red google, to compile)
  // alternative: "-extra <directory name>"

  // need to compile in order to get files
  // extras directory
  // need to copy and rename files
  // mention lack of documentation

  // somewhat incomplete doc at
  // http://code.google.com/p/google-web-toolkit/wiki/UiBinderI18n
  // http://code.google.com/webtoolkit/doc/latest/DevGuideUiBinderI18n.html

  // more up to date at
  // http://code.google.com/p/google-web-toolkit/issues/detail?id=4355

  // key and defaultLocale are not documented
  // if key is not used, MD5 values are generated... problem: if you change the
  // string, the MD5 will change, and you'll have to let your translator know he
  // should not only redo the translation, but change the code everywhere

  // problem: merging... ok I see so this a one-time pass-through process and
  // NOT an iterative process
  // (which I assumed it would be). Isn't that problematic? It imposes the
  // restriction that the complete (!) code of a project must be finished
  // before the translators can start working. Example: Dev team finishes
  // Milestone1, generate properties files. Translaters translate. Dev team adds
  // new translatable content, generate properties files (they will now have the
  // default content). Translaters will
  // have to perform cumbersome merging between the properties files that
  // contain already translated material from M1 and the new properties. I hope
  // I'm
  // wrong here and be thankful if somebody could shed some light in the dark
  // here.

}
