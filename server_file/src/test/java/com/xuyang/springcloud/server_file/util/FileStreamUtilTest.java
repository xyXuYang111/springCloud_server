package com.xuyang.springcloud.server_file.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileStreamUtilTest {
    @Test
    public void markFileToString() throws Exception {

        String fileName = "G:\\file\\test.doc";
        String outFile = "G:\\file\\text1111.doc";

        String str = FileStreamUtil.markFileToString(fileName, 2000, outFile);
        //还存在问题：他的前面内容将是空的
        byte[] bytes = str.getBytes();
        FileUtil.fileOutputStreamInFile(bytes, outFile);
    }
}