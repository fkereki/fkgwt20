package com.kereki.testi18n.client;

import com.google.gwt.i18n.client.ConstantsWithLookup;

public interface Greet
    extends ConstantsWithLookup {

  @Key("day.afternoon")
  @DefaultStringValue("afternoon")
  String afternoon();

  String genericHello();

  @DefaultStringValue("English speakers")
  String kindOfUsers();

  @Key("day.morning")
  @DefaultStringValue("morning")
  String morning();

  String specificQuery();
  // Constants es mejor que ConstantsWithLookup porque optimiza al compilar

  // C...W...L... es mejor cuando hay que traducir algo que viene del cliente
}
