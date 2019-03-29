package com.xuyang.springcloud.server_file.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileStreamUtilTest {
    @Test
    public void markFileToString() throws Exception {

        String fileName = "G:\\file\\test.doc";
        String outFile = "G:\\file\\text.doc";

        FileStreamUtil.markFileToString(fileName, 2000, outFile);
    }
}