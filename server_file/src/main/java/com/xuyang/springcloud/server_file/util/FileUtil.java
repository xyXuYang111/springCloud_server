package com.xuyang.springcloud.server_file.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

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
            fw.write(xml);//向文件中写内容
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
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();//Vector效率低
        int count = 0;
        File dir = new File(fileFindName);//利用File遍历文件夹下的文件
        File[] files = dir.listFiles();
        for(int x=0;x<files.length;x++) {
            al.add(new FileInputStream(files[x]));
        }
        final Iterator<FileInputStream> it = al.iterator();//ArrayList本身没有枚举方法，通过迭代器来实现
        Enumeration<FileInputStream> en= new Enumeration<FileInputStream>()//匿名内部类，复写枚举接口下的两个方法
        {
            public boolean hasMoreElements(){
                return it.hasNext();
            }
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
    public static void splitDemo(String filePath, String outFileName)throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = null;//要在循环内部创建FileOutputStream对象
        byte[] buf = new byte[1024*1024*10];//将文件分割成1M大小的碎片
        int len,count = 0;

        while((len=fis.read(buf))!=-1) {
            fos = new FileOutputStream("D:\\file\\"+outFileName+"\\"+(count++)+".part");
            fos.write(buf,0,len);
            fos.flush();
            fos.close();
        }
        fis.close();
    }

}
