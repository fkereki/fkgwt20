package com.fkereki.mvptest.client;

abstract public class Presenter {
  String params;
  Display display;
  Environment environment;
  Model model;
  KeyValueMap kvm;


  public Presenter() {
  }


  public Presenter(String someParams, Display aDisplay,
    Model aModel, Environment anEnvironment) {
    super();
    params = someParams;
    display = aDisplay;
    model = aModel;
    environment = anEnvironment;
    kvm = new KeyValueMap(params);
  }


  public Model getModel() {
    return model;
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
