package com.xuyang.springcloud.server_quartz.quartz;

import com.xuyang.springcloud.server_quartz.util.DateUtil;
import com.xuyang.springcloud.server_quartz.util.ZipUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;

/**
 * @Auther: xuy
 * @Date: 2019/4/8 00:18
 * @Description: 通过使用spring自带的：spring-task  必须让他初始化下
 */
@Data
@Slf4j
@Configuration
@EnableScheduling
public class QuartzSchedule {

    @Scheduled(cron = "0 0 0 * * ?")
    public void createFileSchedule(){
        log.info("定时创建文件");
        String nowDate = DateUtil.getNowDate();
        File writeFile = new File("D:\\file\\write\\" + nowDate);
        if(!writeFile.exists()){
            writeFile.mkdir();
        }

        File historyFile = new File("D:\\file\\history\\" + nowDate);
        if(!historyFile.exists()){
            historyFile.mkdir();
        }

        File zipFile = new File("D:\\file\\write\\" + nowDate + ".zip");
        if(!zipFile.exists()){
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Scheduled(cron = "0 50 23 * * ?")
    public void zipFileSchedule() {
        log.info("定时压缩文件");
        String nowDate = DateUtil.getNowDate();

        String writeFile = "D:\\file\\write\\" + nowDate;
        String historyFile = "D:\\file\\history\\" + nowDate;
        /** 测试压缩方法1  */
        try {
            //zip文件
            FileOutputStream writeFileFos = new FileOutputStream(new File("D:\\file\\write\\" + nowDate + ".zip"));
            ZipUtil.toZip(writeFile, writeFileFos, true);

            //zip文件
            FileOutputStream historyFileFos = new FileOutputStream(new File("D:\\file\\history\\" + nowDate + ".zip"));
            ZipUtil.toZip(historyFile, historyFileFos, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
