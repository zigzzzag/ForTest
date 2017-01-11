package com.mnikiforov.trash.sber.multi_thread_file;

import static com.mnikiforov.trash.sber.multi_thread_file.MultiThreadFileTest.exportPath;
import java.io.File;
import java.io.IOException;

/**
 * Created by zigzzzag on 02.03.16.
 */
public class NewRealization implements Realization {

    private String fileName = "new_test";

    @Override
    public String getName() {
        return "NewRealization";
    }

    @Override
    public File gitUniqueFile() throws IOException {
        File targetFile = new File(exportPath, fileName);
        synchronized (this) {
            if (targetFile.exists()) {
                Integer counter = 0;
                while (targetFile.exists()) {
                    counter++;
                    String newFileName = fileName + "(" + counter.toString() + ")";
                    targetFile = new File(exportPath, newFileName);
                }
            }
            targetFile.createNewFile();
        }
        return targetFile;
    }
}
