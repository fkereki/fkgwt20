package com.fkereki.mvptest.client;

import com.google.gwt.junit.client.GWTTestCase;

public class TestB extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.fkereki.mvptest.client";
  }

  public void testExampleValidator() {
    assertTrue(1 == 1);
    assertFalse(1 == 2);
  }
}
