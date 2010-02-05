package com.fkereki.mvpproject.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileProcess
    extends HttpServlet {

  private static final long serialVersionUID = -827342423425954584L;

  @Override
  protected void doGet(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    System.out.print("\n\ngot here in GET\n\n");
    super.doGet(request, response);
  }

  @Override
  protected void doPost(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    // Create a factory for disk-based file items
    final FileItemFactory factory = new DiskFileItemFactory();

    // Create a file upload handler
    final ServletFileUpload upload = new ServletFileUpload(factory);

    // Parse the request, and process each uploaded file
    try {
      final List<FileItem> itemsList = upload.parseRequest(request);
      for (final FileItem item : itemsList) {
        if (!item.isFormField()) {
          System.out.println("processing file " + item.getName());

          // use item.getName() to get the original file name
          // use item.getSize() to get the original file size
          // use item.getInputStream() to get the file contents as a stream
        }
      }
    } catch (final FileUploadException e) {
      throw new ServletException(e.getMessage());
    }
  }
}