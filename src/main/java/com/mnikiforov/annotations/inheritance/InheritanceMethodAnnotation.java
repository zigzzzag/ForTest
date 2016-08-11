package com.mnikiforov.annotations.inheritance;

import java.lang.reflect.Method;

/**
 * Created by sbt-nikiforov-mo on 11.08.16.
 */
public class InheritanceMethodAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {
        Parent testObj = new Children();

        {
            Method importMethod = testObj.getClass().getMethod("importFile");
            SupportedType importSuppType = importMethod.getAnnotation(SupportedType.class);
            System.out.println("import SupportedType: " + importSuppType.type());
        }

        {
            Method exportMethod = testObj.getClass().getMethod("exportFile");
            SupportedType exportSuppType = exportMethod.getAnnotation(SupportedType.class);
            System.out.println("import SupportedType: " + (exportSuppType == null ? null : exportSuppType.type()));
        }
    }
}
