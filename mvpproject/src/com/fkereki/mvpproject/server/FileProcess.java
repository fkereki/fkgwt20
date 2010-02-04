package com.fkereki.mvpproject.server;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class FileProcess
    extends HttpServlet {

  private static final long serialVersionUID = -827342423425954584L;

  @Override
  protected void doGet(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    super.doGet(request, response);
  }

  @Override
  protected void doPost(
      final HttpServletRequest request,
      final HttpServletResponse response)
      throws ServletException,
        IOException {

    // process only multipart requests
    if (ServletFileUpload.isMultipartContent(request)) {

      // Create a factory for disk-based file items
      final FileItemFactory factory = new DiskFileItemFactory();

      // Create a new file upload handler
      final ServletFileUpload upload = new ServletFileUpload(factory);

      // Parse the request
      try {
        final List<FileItem> items = upload.parseRequest(request);
        for (final FileItem item : items) {
          // process only file upload - discard other form item types
          if (item.isFormField()) {
            continue;
          }

          String fileName = item.getName();
          // get only the file name not whole path
          if (fileName != null) {
            fileName = FilenameUtils.getName(fileName);
          }

          final File uploadedFile = new File("/tmp", fileName);
          if (uploadedFile.createNewFile()) {
            item.write(uploadedFile);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter()
                .print("The file was created successfully.");
            response.flushBuffer();
          } else {
            throw new IOException(
                "The file already exists in repository.");
          }
        }
      } catch (final Exception e) {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
            "An error occurred while creating the file : "
                + e.getMessage());
      }

    } else {
      response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE,
          "Request contents type is not supported by the servlet.");
    }
  }
}
