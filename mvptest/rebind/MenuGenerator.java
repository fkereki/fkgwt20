import java.io.PrintWriter;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;


public class MenuGenerator extends Generator {

  @Override
  public String generate(TreeLogger logger,
    GeneratorContext context, String typeName)
    throws UnableToCompleteException {

    TypeOracle typeOracle = context.getTypeOracle();
    JClassType originalType = typeOracle.getType(typeName);
    String packageName = originalType.getPackage()
      .getName();

    String generatedClassName = "HelloSayer";
    SourceWriter sourceWriter = getSourceWriter(logger,
      context, originalType, packageName,
      generatedClassName);

    return generatedClassName;
  }


  protected SourceWriter getSourceWriter(TreeLogger logger,
    GeneratorContext context, String packageName,
    String className, String... interfaceNames) {
    PrintWriter printWriter = context.tryCreate(logger,
      packageName, className);
    if (printWriter == null) {
      return null;
    }
    ClassSourceFileComposerFactory composerFactory = new ClassSourceFileComposerFactory(
      packageName, className);
    composerFactory
      .addImport("com.google.gwt.core.client.GWT");
    for (String interfaceName : interfaceNames) {
      composerFactory
        .addImplementedInterface(interfaceName);
    }

    composerFactory
      .addImport("org.timepedia.exporter.client.Exporter");
    return composerFactory.createSourceWriter(context,
      printWriter);
  }


}
