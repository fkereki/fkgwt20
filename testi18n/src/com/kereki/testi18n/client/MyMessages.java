package com.kereki.testi18n.client;

import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;

@DefaultLocale("en")
public interface MyMessages
    extends Messages {

  // see trunk/user/src/com/google/gwt/i18n/client/impl/plurals/DefaultRule.java
  // for rules relative to each country!

  @DefaultMessage("You got {0} things")
  @PluralText( { "one", "You got a single thing." })
  String howMany(@PluralCount int count);
}
