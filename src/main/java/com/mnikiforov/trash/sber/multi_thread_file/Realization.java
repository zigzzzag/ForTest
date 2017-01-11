package com.mnikiforov.trash.sber.multi_thread_file;

import java.io.File;
import java.io.IOException;

/**
 * Created by zigzzzag on 02.03.16.
 */
public interface Realization {

    String getName();

    File gitUniqueFile() throws IOException;
}
