package com.xuyang.springcloud.server_file.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileUtilTest {
    @Test
    public void fileToByte() throws Exception {

        String fileName = "G:\\file\\test.doc";
        String outFile = "11111";

        //这个就是我想要的文件截取
        FileUtil.fileToByte(fileName, outFile, 1024*10);
    }

}