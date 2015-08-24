package com.mnikiforov.tzupdatertest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by SBT-Nikiforov-MO on 21.08.2015.
 */
public class UtilsHelper {
    public static final byte[] JAVAZM_LABEL = {
            (byte) 'j', (byte) 'a', (byte) 'v', (byte) 'a', (byte) 'z', (byte) 'm', (byte) '\0'
    };

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
            //{ 106, 97, 118, 97, 122, 109, 0 }
            //{ 106, 97, 118, 97, 122, 109, 0 }
            byte[] arrayOfByte = readZoneInfoMappings(paramString);
            int i = JAVAZM_LABEL.length + 1;
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
            throw new RuntimeException("can't read ZoneInfoMappings at " + paramString, localIOException);
        } catch (Exception localException) {
            throw new RuntimeException("ZoneInfoMappings file is corrupted.", localException);
        }
        return str;
    }

    public static byte[] readZoneInfoMappings(String paramString) throws IOException {
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
}
