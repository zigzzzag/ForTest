package com.mnikiforov.trash.sber.multi_thread_file;

import java.io.File;
import java.io.IOException;
import static com.mnikiforov.trash.sber.multi_thread_file.MultiThreadFileTest.*;

/**
 * Created by sbt-nikiforov-mo on 02.03.16.
 */
public class OldRealization implements Realization {

    private String fileName = "old_test";

    @Override
    public String getName() {
        return "OldRealization";
    }

    @Override
    public File gitUniqueFile() throws IOException {
        File targetFile = new File(exportPath, fileName);

        if (targetFile.exists()) {
            Integer counter = 0;
            while (targetFile.exists()) {
                counter++;
                String newFileName = fileName + "(" + counter.toString() + ")";
                targetFile = new File(exportPath, newFileName);
            }
        }

        return targetFile;
    }
}
