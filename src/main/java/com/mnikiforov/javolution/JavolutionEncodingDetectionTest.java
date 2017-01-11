package com.mnikiforov.javolution;

import com.mnikiforov.util.Constants;
import javolution.xml.stream.XMLStreamConstants;
import javolution.xml.stream.XMLStreamReaderImpl;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by zigzzzag on 20.07.2015.
 */
public class JavolutionEncodingDetectionTest extends TestCase {
    private static final String XML =
            "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><a>b</a>";

    private static File FP = new File(Constants.DATA_PATH + "tmp.xml");

    public void test__FileInputStream() throws Exception {
        OutputStream out = new FileOutputStream(FP);
        out.write(XML.getBytes());
        out.flush();
        out.close();

        XMLStreamReaderImpl reader = new XMLStreamReaderImpl();
        reader.setInput(new FileInputStream(FP));

        while (reader.getEventType() != XMLStreamConstants.END_DOCUMENT) {
            reader.next();
        }
    }
}
