package com.mnikiforov.tzupdatertest;

/**
 * Created by SBT-Nikiforov-MO on 21.08.2015.
 */
public class TZDataUtils {

    private final String jreVersion = System.getProperty("java.version");
    private final String javaHome = System.getProperty("java.home");
    private static boolean jsr310;

    public static void main(String[] args) {
        TZDataUtils tzDataUtils = new TZDataUtils();
        System.out.println(tzDataUtils.getTzDataVersion());
    }

    public TZDataUtils() {
        int i = Integer.parseInt(this.jreVersion.substring(2, 3));
        if (i >= 8) {
            jsr310 = true;
        }
    }

    public String getTzDataVersion() {
//        String str1 = ((DataConfiguration)localObject1).getTzID();
//        String str2 = UtilsHelper.toTzdbFileName(this.javaHome);
//        if (externalResourceBundle) {
//            ExternalModule.createVersionFile(tmpDynamicDir.getPath(), str1);
//            if (jsr310) {
//                str2 = UtilsHelper.toTzdbFileName(this.javaHome);
//                if (str2 == null) {
//                    throw new TzRuntimeException("The Java runtime doesn't have a tzdb.dat file.");
//                }
//                ExternalModule.compileToJSRBinary(tmpDynamicDir.getPath(), str2 + ".dynamic");
//            } else {
//                ExternalModule.compileToZiBinary(str1, tmpDynamicDir.getPath());
//            }
//        };

        String currentID;
        String str3 = null;
        if (!jsr310) {
            str3 = UtilsHelper.toZiDirName(this.javaHome);
            if (str3 == null) {
                throw new TzRuntimeException("The Java runtime doesn't have time zone data (zi directory).");
            }
            currentID = UtilsHelper.getTzID(str3);
        } else {
//            currentID = UtilsHelper.getTzIDFromTZDB(str2);
            currentID  = "fall";
        }
        return currentID;
    }
}
