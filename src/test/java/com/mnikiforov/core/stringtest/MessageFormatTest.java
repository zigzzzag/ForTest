package com.mnikiforov.core.stringtest;

import org.junit.Test;

import java.text.MessageFormat;

import static org.junit.Assert.*;

public class MessageFormatTest {

    @Test
    public void formatTest() {
        assertEquals("Processing message (req_GUID=aaa contains not success status and description={1}) ",
                MessageFormat.format("Processing message (req_GUID={0} contains not success status and description='{1}') ", "aaa", "bbb"));
    }
}