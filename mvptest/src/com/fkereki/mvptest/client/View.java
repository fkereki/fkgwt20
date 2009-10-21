package com.fkereki.mvptest.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;

abstract class View extends Composite {

  abstract Panel asPanel();
}
