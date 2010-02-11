package com.kereki.testi18n.client;

import com.google.gwt.i18n.client.Constants;

public interface Texts
    extends Constants {

  String helloWorld();

  String howAreYou();

  @DefaultStringValue("I'm not anywhere")
  String outOfFile();

  String random();

  // tuve que hacer EDIT, SET ENCODING, UTF-8 para otros idiomas
  // hay que poner el locale por defecto
  // agregué <meta name="gwt:property" content="locale=x_Y">

  // The locale client property can be specified using either a meta tag or as
  // part of the query string in the host page's URL. If both are specified, the
  // query string takes precedence.

  // to specify a locale via the url add locale=xxx
  // http://www.example.org/myapp.html?locale=fr_CA

  // explicar cómo funciona el default... es_UY.properties va primero,
  // es.properties va segundo, .properties va por defecto

  // si no encuentra una string en un locale, la toma del de arriba

  // usar @DefaultStringValue(...) elimina la necesidad del archivo general y es
  // más claro para documentación

  // Constants es mejor que ConstantsWithLookup porque optimiza al compilar

  // C...W...L... es mejor cuando hay que traducir algo que viene del cliente
}
