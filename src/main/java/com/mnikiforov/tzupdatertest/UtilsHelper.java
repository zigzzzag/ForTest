package com.mnikiforov.tzupdatertest;

import sun.util.calendar.ZoneInfoFile;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by SBT-Nikiforov-MO on 21.08.2015.
 */
public class UtilsHelper {

    public static String toZiDirName(String paramString) {
        String str = paramString + File.separator + "jre" + File.separator + "lib" + File.separator + "zi";
        File localFile = new File(str);
        if (localFile.isDirectory()) {
            return str;
        }
        str = paramString + File.separator + "lib" + File.separator + "zi";
        localFile = new File(str);
        return localFile.isDirectory() ? str : null;
    }

    public static String getTzID(String paramString) {
        String str = null;
        try {
            byte[] arrayOfByte = readZoneInfoMappings(paramString);
            int i = ZoneInfoFile.JAVAZM_LABEL.length + 1;
            int j = arrayOfByte.length;
            while (i < j) {
                int k = arrayOfByte[(i++)];
                int m = ((arrayOfByte[(i++)] & 0xFF) << 8) + (arrayOfByte[(i++)] & 0xFF);
                switch (k) {
                    case 68:
                        str = new String(arrayOfByte, i, m - 1, "utf-8");
                        break;
                    default:
                        i += m;
                }
            }
        } catch (IOException localIOException) {
            throw new TzRuntimeException("can't read ZoneInfoMappings at " + paramString, localIOException);
        } catch (Exception localException) {
            throw new TzRuntimeException("ZoneInfoMappings file is corrupted.", localException);
        }
        return str;
    }

    public static byte[] readZoneInfoMappings(String paramString)
            throws IOException {
        String str = toZiFileName(paramString, "ZoneInfoMappings");
        File localFile = new File(str);
        int i = (int) localFile.length();
        byte[] arrayOfByte = new byte[i];
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        if (localFileInputStream.read(arrayOfByte) != i) {
            localFileInputStream.close();
            throw new IOException("read error on " + str);
        }
        localFileInputStream.close();
        return arrayOfByte;
    }

    private static String toZiFileName(String paramString1, String paramString2) {
        return paramString1 + File.separator + paramString2;
    }


//    public static String getTzIDFromTZDB(String paramString) throws IOException {
//        DataInputStream localDataInputStream = null;
//        try {
//            localDataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(paramString))));
//            return getTzID(localDataInputStream);
//        } catch (Exception localException) {
//            throw new TzRuntimeException("Error reading tzdata version from " + paramString, localException);
//        } finally {
//            if (localDataInputStream != null) {
//                localDataInputStream.close();
//            }
//        }
//    }

    public static String toTzdbFileName(String paramString) {
        String str = paramString + File.separator + "jre" + File.separator + "lib" + File.separator + "tzdb.dat";
        File localFile = new File(str);
        if (localFile.exists()) {
            return str;
        }
        str = paramString + File.separator + "lib" + File.separator + "tzdb.dat";
        localFile = new File(str);
        return localFile.isFile() ? str : null;
    }
}
