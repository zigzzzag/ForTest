package com.mnikiforov.tzupdatertest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamCorruptedException;

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

    public static String getTzID(String zoneInfoDirName) {
        String str = null;
        try {
            byte[] arrayOfByte = readZoneInfoMappings(zoneInfoDirName);
            int i = JAVAZM_LABEL.length + 1;
            while (i < arrayOfByte.length) {
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
            throw new TzRuntimeException("can't read ZoneInfoMappings at " + zoneInfoDirName, localIOException);
        } catch (Exception localException) {
            throw new TzRuntimeException("ZoneInfoMappings file is corrupted.", localException);
        }
        return str;
    }

    public static byte[] readZoneInfoMappings(String zoneInfoDirName) throws IOException {
        String zoneInfoMappingsDirName = toZiFileName(zoneInfoDirName, "ZoneInfoMappings");
        File localFile = new File(zoneInfoMappingsDirName);
        int i = (int) localFile.length();
        byte[] arrayOfByte = new byte[i];
        FileInputStream localFileInputStream = new FileInputStream(localFile);
        if (localFileInputStream.read(arrayOfByte) != i) {
            localFileInputStream.close();
            throw new IOException("read error on " + zoneInfoMappingsDirName);
        }
        localFileInputStream.close();
        return arrayOfByte;
    }

    private static String toZiFileName(String paramString1, String paramString2) {
        return paramString1 + File.separator + paramString2;
    }

    public static String getTzIDFromTZDB(String paramString) throws IOException {
        DataInputStream localDataInputStream = null;
        try {
            localDataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(paramString))));

            return getTzID(localDataInputStream);
        } catch (Exception localException) {
            throw new TzRuntimeException("Error reading tzdata version from " + paramString, localException);
        } finally {
            if (localDataInputStream != null) {
                localDataInputStream.close();
            }
        }
    }

    public static String getTzID(DataInputStream paramDataInputStream) throws Exception {
        String str1 = "";
        if (paramDataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        String str2 = paramDataInputStream.readUTF();
        if (!"TZDB".equals(str2)) {
            throw new StreamCorruptedException("File format not recognised");
        }
        int i = paramDataInputStream.readShort();
        for (int j = 0; j < i; j++) {
            str1 = paramDataInputStream.readUTF();
        }
        return "tzdata" + str1;
    }

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
