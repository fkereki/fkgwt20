package com.kereki.generator.rebind;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

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
    classFactory.addImport("com.google.gwt.user.client.Command");
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

  // mb3.addItem("Updating", new HistoryCommand(string));

  private void writeClass(
      final TreeLogger logger,
      final JClassType originalType,
      final SourceWriter sourceWriter) {

    final File inFile = new File(
        "/home/fkereki/NetBeansProjects/scannerTest/src/sample.menu");
    Scanner scanner;
    try {
      scanner = new Scanner(inFile);
      String first;
      String second;
      String third;

      sourceWriter.println("public MenuBar createMenu() {");

      int level = 0;
      sourceWriter.println("MenuBar stack[]= new MenuBar[20];");
      sourceWriter.println("stack[0]= new MenuBar();");

      while (scanner.hasNext()) {
        first = scanner.next();

        if (first.equals("menu")) {
          second = scanner.nextLine().trim();
          level++;
          sourceWriter.println("stack[" + level
              + "]= new MenuBar(true);");
          sourceWriter.println("stack[" + (level - 1) + "].addItem(\""
              + second + "\", stack[" + level + "]);");

        } else if (first.equals("command")) {
          second = scanner.next();
          third = scanner.nextLine().trim();
          // sourceWriter.println("stack[" + level + "].addItem(\""
          // + third + "\", new HistoryCommand(" + second
          // + ".PLACE));");

          sourceWriter.println("stack[" + level + "].addItem(\""
              + third + "\", (Command) null);");

        } else /* first.equals("endmenu") assumed */{
          level--;
        }
      }
      scanner.close();
      sourceWriter.println("return stack[0];");
      sourceWriter.println("}");

    } catch (final Exception e) {
      System.out.println("ouch..." + e.getMessage());
    }

    // sourceWriter
    // .println("public com.google.gwt.user.client.ui.MenuBar createMenu() {");
    // sourceWriter.println("MenuBar mb2 = new MenuBar(true);");
    // sourceWriter
    // .println("mb2.addItem(\"nulasdfsfdsity\", (com.google.gwt.user.client.Command) null);");
    // sourceWriter
    // .println("mb2.addItem(\"unbagunba\", (com.google.gwt.user.client.Command) null);");
    // sourceWriter.println("return mb2;");
    // sourceWriter.println("}");
    sourceWriter.commit(logger);
  }
}