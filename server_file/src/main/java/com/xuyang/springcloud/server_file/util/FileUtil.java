package com.xuyang.springcloud.server_file.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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
    public static void valueWriteInFile(String xml, String filePath) {
        File file = null;
        FileWriter fw = null;
        file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(xml);
            fw.flush();
            log.info("内容写成功。");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件中的信息
     * @param filePath
     * @return
     */
    public static String txt2String(String filePath){
        StringBuilder result = new StringBuilder();
        try{
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
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
        byte[] buf = new byte[1024*1024*10];
        int len,count = 0;

        List<String> fileNameList = new ArrayList<>();
        while((len=fis.read(buf))!=-1) {
            String fileName = "D:\\file\\"+outFileName+"\\"+(count++)+".part";
            fos = new FileOutputStream(fileName);
            fos.write(buf,0,len);
            fos.flush();
            fos.close();
            fileNameList.add(fileName);
        }
        fis.close();
        return fileNameList;
    }

}
