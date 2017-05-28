package com.mnikiforov.core.string;

import com.mnikiforov.core.stringtest.CustomStringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomStringUtilsTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(CustomStringUtilsTest.class);
    private static final Map<String, Integer> TEST_DATA = new HashMap<>();

    static {
        TEST_DATA.put(null, 0);
        TEST_DATA.put("", 0);
        TEST_DATA.put("a", 0);
        TEST_DATA.put("1", 1);
        TEST_DATA.put("00", 2);
        TEST_DATA.put("a1", 1);
        TEST_DATA.put("1a", 1);
        TEST_DATA.put("abc12", 2);
        TEST_DATA.put("a9b2", 2);
        TEST_DATA.put("?s.2f5", 2);
    }

    public void testGetDigitsCountSlow() {
        final Set<Map.Entry<String, Integer>> entries = TEST_DATA.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            final String testStr = entry.getKey();
            final Integer testResult = entry.getValue();

            final int digitsCountSlow = CustomStringUtils.INSTANCE.getDigitsCountSlow(testStr);
            assertTrue(testResult == digitsCountSlow);
        }
    }

    public void testGetDigitsCountFast() {
        final Set<Map.Entry<String, Integer>> entries = TEST_DATA.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            final String testStr = entry.getKey();
            final Integer testResult = entry.getValue();

            final int digitsCountFast = CustomStringUtils.INSTANCE.getDigitsCountFast(testStr);
            assertTrue(testResult == digitsCountFast);
        }
    }

    public String getTestStringForSpeedTest() throws IOException {
        URL url = new URL("http://norvig.com/big.txt");
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        return IOUtils.toString(in, encoding);
    }

    public void testTimeGetDigitsCountSlow() throws IOException {
        final String testStringForSpeedTest = getTestStringForSpeedTest();

        final long start = System.currentTimeMillis();
        CustomStringUtils.INSTANCE.getDigitsCountSlow(testStringForSpeedTest);
        LOG.info("Total getDigitsCountSlow time: {}ms", System.currentTimeMillis() - start);
    }

    public void testTimeGetDigitsCountFast() throws IOException {
        final String testStringForSpeedTest = getTestStringForSpeedTest();

        final long start = System.currentTimeMillis();
        CustomStringUtils.INSTANCE.getDigitsCountFast(testStringForSpeedTest);
        LOG.info("Total getDigitsCountFast time: {}ms", System.currentTimeMillis() - start);
    }
}
