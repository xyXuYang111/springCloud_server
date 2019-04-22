package com.xuyang.springcloud.server_file.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: cypc
 * @Date: 2019-4-19 10:46
 * @Description:
 */
@Data
@Slf4j
public class FileUtil {

    /**
     * 给一个空文本中写入内容
     * @param value
     * @param filePath
     */
    public static void writeWordInfoFile(String value, String filePath){
        File file = new File(filePath);;
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            //向文件中写内容
            fw.write(value);
            fw.flush();
            System.out.println("写数据成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fw != null){
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
     * 文件字节流的写入
     * @param filePath
     * @throws Exception
     */
    public static List<byte[]> fileToByte(File filePath, int byteSize) throws Exception{
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = null;
        byte[] bytes = new byte[byteSize];
        int len,count = 0;

        //下面这个是关键：文件的字节流的写入
        List<byte[]> bytesList = new ArrayList<>();
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
            bytesList.add(bytes);
            file.delete();
        }
        fis.close();
        return bytesList;
    }

    /**
     *
     * @param sourceFile 旧文件
     * @param targetFile 新文件
     * @throws IOException
     */
    // 复制文件
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        // 新建文件输入流并对它进行缓冲
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);

        // 新建文件输出流并对它进行缓冲
        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        // 缓冲数组
        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        // 刷新此缓冲的输出流
        outBuff.flush();

        //关闭流
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    /**
     * 想某个文件下添加内容：也就是文档合并
     * @param readerFile 被合并的文件
     * @param writerUrl 结果文件
     */
    public static void addFile(String readerFile, String writerUrl){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readerFile));
            BufferedWriter writer  = new BufferedWriter(new FileWriter(writerUrl,true));
            String line = reader.readLine();
            while(line!=null){
                writer.write(line);
                line = reader.readLine();
            }
            writer.flush();
            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
