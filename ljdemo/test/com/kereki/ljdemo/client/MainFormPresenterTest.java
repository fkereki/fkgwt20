package com.kereki.ljdemo.client;

public class MainFormPresenterTest {

}
/*
 * import static org.junit.Assert.assertEquals;
 * 
 * import org.easymock.Capture; import static
 * org.easymock.classextension.EasyMock.*; import org.junit.Test;
 * 
 * import com.google.gwt.junit.GWTMockUtilities; import
 * com.google.gwt.user.client.rpc.AsyncCallback;
 * 
 * public class MainFormPresenterTest {
 * 
 * @Test public void TestMainForm1() { GWTMockUtilities.disarm();
 * 
 * Environment environmentMock= createStrictMock(Environment.class);
 * MainFormView formViewMock= createStrictMock(MainFormView.class);
 * 
 * // We'll use these to capture values passed from the Presenter // to
 * the other objects
 * 
 * Capture<MainFormPresenter> mfpCapture= new
 * Capture<MainFormPresenter>(); Capture<AsyncCallback<Integer>>
 * acbCapture= new Capture<AsyncCallback<Integer>>();
 * 
 * // we'll do a calc average click, so ...
 * 
 * formViewMock.setPresenter(capture(mfpCapture));
 * expect(formViewMock.getFirstText()).andReturn("2");
 * expect(formViewMock.getSecondText()).andReturn("4");
 * expect(formViewMock.getThirdText()).andReturn("9");
 * formViewMock.setResult(matches("5"));
 * 
 * environmentMock.calculateAverage(matches("2"), matches("4"),
 * matches("9"), capture(acbCapture));
 * 
 * // Prepare the mock objects for replay...
 * 
 * replay(environmentMock); replay(formViewMock);
 * 
 * // ...and then go do the job!
 * 
 * MainFormPresenter formPresenter= new
 * MainFormPresenter(environmentMock, formViewMock);
 * formPresenter.onAverageClick(); acbCapture.getValue().onSuccess(5);
 * 
 * // We can check whether the setPresenter(...) call provided the //
 * right value (i.e., the presenter we had just created)
 * 
 * assertEquals(mfpCapture.getValue(), formPresenter);
 * 
 * GWTMockUtilities.restore(); } }
 */
