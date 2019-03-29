package com.xuyang.springcloud.server_file.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 00:24
 * @Description:
 */
@Slf4j
public class FileUtil {

    /**
     * 将内容写到文档中
     *
     * @param xml
     */
    public static void valueWriteInFile(String xml, String filePath) throws Exception {
        File file = null;
        FileWriter fw = null;
        file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        fw.write(xml);
        fw.flush();
        log.info("内容写成功。");
    }


    /**
     * 将字节流写到文本中
     *
     * @param bytes
     */
    public static void fileOutputStreamInFile(byte[] bytes, String filePath) throws Exception {
        File file = null;
        file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytes);
        fos.flush();
        log.info("内容写成功。");
    }

    /**
     * 文件合并
     * @throws IOException
     */
    public static void sequenceDemo(String resultFileName, String fileFindName)throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = new FileOutputStream(resultFileName);
        ArrayList<FileInputStream> al = new ArrayList<>();
        int count = 0;
        File dir = new File(fileFindName);
        File[] files = dir.listFiles();
        for(int x=0;x<files.length;x++) {
            al.add(new FileInputStream(files[x]));
        }
        final Iterator<FileInputStream> it = al.iterator();
        Enumeration<FileInputStream> en= new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements(){
                return it.hasNext();
            }
            @Override
            public FileInputStream nextElement()
            {
                return it.next();
            }

        };
        SequenceInputStream sis = new SequenceInputStream(en);
        //定义分割大小
        byte[] buf = new byte[1024*1024];
        while((count=sis.read(buf))!=-1) {
            fos.write(buf,0,count);
        }
        sis.close();
        fos.close();
    }

    /**
     * 文件分割
     * @param filePath
     * @throws IOException
     */
    public static List<String> splitDemo(String filePath, String outFileName)throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = null;
        byte[] buf = new byte[1024*2];
        int len,count = 0;

        List<String> fileNameList = new ArrayList<>();
        while((len=fis.read(buf))!=-1) {
            String fileName = "D:\\file\\"+outFileName+"\\"+(count++)+".doc";
            fos = new FileOutputStream(fileName);
            fos.write(buf,0,len);
            fos.flush();
            fos.close();
            fileNameList.add(fileName);
        }
        fis.close();
        return fileNameList;
    }

    /**
     * 文件字节流的写入
     * @param filePath
     * @param outFilePath
     * @throws Exception
     */
    public static void fileToByte(String filePath, String outFilePath, int byteSize) throws Exception{
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = null;
        byte[] bytes = new byte[byteSize];
        int len,count = 0;

        //下面这个是关键：文件的字节流的写入
        List<String> fileNameList = new ArrayList<>();
        while((len=fis.read(bytes))!=-1) {
            String fileName = "F:\\text\\"+(count++)+".doc";
            File file = new File(fileName);
            file.createNewFile();
            fos = new FileOutputStream(fileName);
            fos.write(bytes,0,len);
            fos.flush();
            fos.close();
            String str = new String(bytes);
            fileNameList.add(str);
            file.delete();
        }
        fis.close();
    }
}
