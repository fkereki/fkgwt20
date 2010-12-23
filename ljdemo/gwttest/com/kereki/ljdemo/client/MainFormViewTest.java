package com.kereki.ljdemo.client;

import org.junit.Test;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.junit.client.GWTTestCase;

public class MainFormViewTest extends GWTTestCase {
	@Override
	public String getModuleName() {
		return "com.kereki.ljdemo.Ljdemo";
	}

	protected class FakeFormPresenter extends MainFormPresenter {
		public boolean onAnyChangeCalled= false;
		public boolean onAverageClickCalled= false;

		public FakeFormPresenter(final Model anEnvironment,
		        final MainFormView aView) {
			super(anEnvironment, aView);
		}

		@Override
		public void onAnyChange() {
			this.onAnyChangeCalled= true;
		}

		@Override
		public void onAverageClick() {
			this.onAverageClickCalled= true;
		}
	};

	@Test
	public void testMainFormView() {
		final MainFormView mfv= new MainFormView();
		final FakeFormPresenter ffp= new FakeFormPresenter(null, mfv);

		mfv.setPresenter(ffp);
		assertEquals(mfv.ownPresenter, ffp);

		mfv.tf1.setText("123");
		assertEquals(mfv.tf1.getValue(), "123");

		// fire change event on the first field
		// and check if the correct presenter method was called
		final com.google.gwt.dom.client.Document doc= com.google.gwt.dom.client.Document
		        .get();
		final NativeEvent evt1= doc.createBlurEvent();
		DomEvent.fireNativeEvent(evt1, mfv.tf1);
		assertTrue(ffp.onAnyChangeCalled);

		// fire click event on the average button
		final NativeEvent evt2= doc.createClickEvent(0, 0, 0, 0, 0, false,
		        false, false, false);
		DomEvent.fireNativeEvent(evt2, mfv.btn);
		assertTrue(ffp.onAverageClickCalled);

		mfv.setResult("234");
		assertEquals(mfv.tavg.getValue(), "234");
	}
}
