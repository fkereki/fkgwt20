package com.kereki.generator.rebind;

import java.io.PrintWriter;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class MenuGenerator
    extends Generator {

  private String createClass(
      final TreeLogger logger,
      final GeneratorContext context,
      final String typeName) {

    System.out.println("createClass " + typeName);
    final JClassType originalType;
    final String packageName;
    final TypeOracle typeOracle = context.getTypeOracle();
    try {
      originalType = typeOracle.getType(typeName);
      packageName = originalType.getPackage().getName();

      final String originalClassName = originalType
          .getSimpleSourceName();
      final String generatedClassName = originalClassName + "Gen";
      final SourceWriter sourceWriter = getSourceWriter(logger,
          context, originalType, packageName, generatedClassName);
      if (sourceWriter != null) {
        writeClass(logger, originalType, sourceWriter);
      }
      return originalType.getParameterizedQualifiedSourceName() + "Gen";

    } catch (final Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  @Override
  public String generate(
      final TreeLogger logger,
      final GeneratorContext context,
      final String typeName)
      throws UnableToCompleteException {

    final String generatedClassQualifiedName = createClass(logger,
        context, typeName);
    if (generatedClassQualifiedName == null) {
      throw new UnableToCompleteException();
    }
    return generatedClassQualifiedName;
  }

  private SourceWriter getSourceWriter(
      final TreeLogger logger,
      final GeneratorContext context,
      final JClassType originalType,
      final String packageName,
      final String generatedClassName) {

    final ClassSourceFileComposerFactory classFactory = new ClassSourceFileComposerFactory(
        packageName, generatedClassName);
    classFactory.addImport("com.google.gwt.user.client.ui.MenuBar");
    classFactory.addImplementedInterface(originalType.getName());

    final PrintWriter printWriter = context.tryCreate(logger,
        packageName, generatedClassName);
    if (printWriter == null) {
      return null;
    }

    final SourceWriter sourceWriter = classFactory.createSourceWriter(
        context, printWriter);
    return sourceWriter;
  }

  private void writeClass(
      final TreeLogger logger,
      final JClassType originalType,
      final SourceWriter sourceWriter) {
    logger.log(TreeLogger.ALL, "testing logger");
    sourceWriter
        .println("public com.google.gwt.user.client.ui.MenuBar createMenu() {");
    sourceWriter
        .println("com.google.gwt.user.client.ui.MenuBar mb2 = new com.google.gwt.user.client.ui.MenuBar(true);");
    sourceWriter.println("return mb2;");
    sourceWriter.println("}");
    sourceWriter.commit(logger);
  }
}