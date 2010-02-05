package com.fkereki.mvpproject.client.fileUpload;

import com.fkereki.mvpproject.client.Environment;
import com.fkereki.mvpproject.client.Presenter;
import com.fkereki.mvpproject.client.SimpleCallback;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;

public class FileUploadPresenter
    extends Presenter<FileUploadDisplay> {
  public static String PLACE = "upload";

  public FileUploadPresenter(
      final String params, final FileUploadDisplay fileUploadDisplay,
      final Environment environment) {

    super(params, fileUploadDisplay, environment);

    fileUploadDisplay
        .setUploadClickCallback(new SimpleCallback<Object>() {

          @Override
          public void goBack(final Object result) {
            if (getDisplay().getFileToUploadName().isEmpty()) {
              getEnvironment().showAlert(
                  "You must pick a file to upload.");
            } else {
              getDisplay().submitForm();
            }
          }
        });

    fileUploadDisplay
        .setSubmitCallback(new SimpleCallback<SubmitEvent>() {

          @Override
          public void goBack(final SubmitEvent result) {
            Window.alert("event!");
            // result.cancel();
          }
        });

    fileUploadDisplay
        .setSubmitCompleteCallback(new SimpleCallback<SubmitCompleteEvent>() {

          @Override
          public void goBack(final SubmitCompleteEvent result) {
            Window.alert("complete!" + result.getResults());
          }
        });
  }
}
