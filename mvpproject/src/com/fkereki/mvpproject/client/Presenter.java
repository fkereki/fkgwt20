package com.fkereki.mvpproject.client;

abstract public class Presenter {
  String params;
  Display display;
  Environment environment;
  KeyValueMap kvm;


  public Presenter() {
  }


  public Presenter(String someParams, Display aDisplay,
    Environment anEnvironment) {
    super();
    params = someParams;
    display = aDisplay;
    environment = anEnvironment;
    kvm = new KeyValueMap(params);
  }


  public Environment getEnvironment() {
    return environment;
  }


  public Display getDisplay() {
    return display;
  }


  public KeyValueMap getKvm() {
    return kvm;
  }
}
