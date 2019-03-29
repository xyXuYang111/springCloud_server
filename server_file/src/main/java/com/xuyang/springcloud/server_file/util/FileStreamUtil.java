package com.xuyang.springcloud.server_file.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Auther: cypc
 * @Date: 2019-3-29 09:06
 * @Description:
 */
public class FileStreamUtil {

    /**
     * 读取文件内容
     * 字节流
     *
     * @param fileName
     */
    public static String InputStreamToString(String fileName) throws Exception {
        //InputStream:是一个抽象类
        // \:是一个 转移符
        //表示磁盘路径的两种表示方式：1、\\   2、/
        //从文件地址中读取内容到程序中
        //1、建立连接
        InputStream is = new FileInputStream(fileName);
        //2、开始读取信息
        //先定义一个字节数组存放数据
        byte[] b = new byte[is.available()];//把所有的数据读取到这个字节当中
        //is.available()：返回文件的大小
        //		while(is.available()==0);//不等于0时才停止循环
        //完整的读取一个文件
        int off = 0;
        int le = 2;
        while (is.read(b, off, le) != -1) {
            off += 1;
        }
        is.read(b, off, le);
        //read:返回的是读取的文件大小
        //最大不超过b.length，返回实际读取的字节个数
        System.out.println(Arrays.toString(b));//读取的是字节数组
        //把字节数组转成字符串
        System.out.println(new String(b));
        //关闭流
        is.close();
        return Arrays.toString(b);
    }

    /**
     * 读取中文字符的文件
     * 管道字节流
     *
     * @param fileName
     */
    public static String bufferedInputStreamToString(String fileName) throws Exception {
        // TODO Auto-generated method stub

			/*FileInputStream fis = new FileInputStream("E:/iodemo/ch04.txt");
            //包装流
			BufferedInputStream bis = new BufferedInputStream(fis);*/
        //包装流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        //读取文件内容
        byte[] b = new byte[bis.available()];
        bis.read(b);

			/*char[] c = new char[b.length];
            for (int i = 0; i < c.length; i++) {
				c[i]=(char) b[i];
			}
			System.out.println(Arrays.toString(c));//乱码
			 */
        System.out.println(Arrays.toString(b));//得到的是字节
        //String(byte[])把字节数组转成字符串
        System.out.println(new String(b));//可以得到中文
        bis.close();//关闭流(关闭bis就可以了)
        return Arrays.toString(b);
    }

    /**
     * 文件流读取
     * 跳过多少字节后在读取
     *
     * @param fileName
     * @throws Exception
     */
    public static String skipToString(String fileName, int skip) throws Exception {
        // TODO Auto-generated method stub
        //读取文件
        FileInputStream fis = new FileInputStream(fileName);
        //fis.available():文件的长度
        byte[] b = new byte[fis.available()];
        //skip:跳过n个字节后再开始读取
        fis.skip(skip);//跳过前skip个
        fis.read(b);

        System.out.println(new String(b));
        fis.close();
        return new String(b);
    }

    /**
     * 读取过程暂停，给当前做一个标记，下一次从标记位置开始读取
     * 截取读取
     * 读取过程中暂停
     * 给当前做一个标记
     * 下一次从标记位置开始读取
     *
     * @param fileName
     * @param skip
     * @throws Exception
     */
    public static String markFileToString(String fileName, int skip, String outFile) throws Exception {
        // TODO Auto-generated method stub
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
        byte[] b = new byte[1024*1024*5];
        //设置断点
        //位置就是读取的长度
        bis.mark(bis.read(b, 0, b.length / 5));
        System.out.println(new String(b));
        String str = new String(b);
        System.out.println("暂停读取....");
        //休眠skip/1000s
        Thread.sleep(skip);
        //休眠后继续读
        System.out.println("继续读取...");
        //reset：将当前复位的位置设置成上次调用mark标记的位置
        bis.reset();
        bis.read(b);
        bis.close();
        return str;
    }

    /**
     * 多个文件合并然后读里面内容
     *
     * @param fileNameList
     * @return
     * @throws Exception
     */
    public static String sequenceInputStreamToFile(List<String> fileNameList) throws Exception {
        //把多个流添加到集合中
        Vector<FileInputStream> vector = new Vector<>();
        for (String fileName : fileNameList) {
            //文件流
            FileInputStream fis = new FileInputStream(fileName);
            vector.add(fis);
        }
        //	vector.elements(); //方法返回的是Enumeration
        //合并到一个序列流中
        SequenceInputStream sis = new SequenceInputStream(vector.elements());
        //设置大小
        byte[] b = new byte[1024 * 1024 * 100];
        //读取
        int off = 0;
        //vector.get(i).available():一个文件的长度
        for (int i = 0; i < vector.size(); i++) {
            //off:数组当中存放数据的起始下标的位置
            off += sis.read(b, off, vector.get(i).available());//每次读取一个文件的长度

        }
        System.out.println(new String(b));
        sis.close();
        return new String(b);
    }
}
