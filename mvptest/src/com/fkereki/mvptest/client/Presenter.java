package com.fkereki.mvptest.client;

abstract public class Presenter {
  String params;
  Display display;
  Model model;
  KeyValueMap kvm;


  public Presenter() {
  }


  public Presenter(String someParams, Display aDisplay,
    Model aModel) {
    super();
    params = someParams;
    display = aDisplay;
    model = aModel;
    kvm = new KeyValueMap(params);
  }


  public Model getModel() {
    return model;
  }


  public Display getDisplay() {
    return display;
  }


  public KeyValueMap getKvm() {
    return kvm;
  }
}
