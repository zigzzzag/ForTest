package com.mnikiforov.trash.sber.multi_thread_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static com.mnikiforov.trash.sber.multi_thread_file.MultiThreadFileTest.*;

/**
 * Created by sbt-nikiforov-mo on 02.03.16.
 */
public class PatchRealization implements Realization {

    private String fileName = "patch_test";

    @Override
    public String getName() {
        return "PatchRealization";
    }

    @Override
    public synchronized File gitUniqueFile() throws IOException {
        File targetFile = new File(exportPath, fileName);
        if (targetFile.exists()) {
            Integer counter = 0;
            while (targetFile.exists()) {
                counter++;
                String newFileName = fileName + "(" + counter.toString() + ")";
                targetFile = new File(exportPath, newFileName);
            }
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(targetFile);
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
        return targetFile;
    }
}
