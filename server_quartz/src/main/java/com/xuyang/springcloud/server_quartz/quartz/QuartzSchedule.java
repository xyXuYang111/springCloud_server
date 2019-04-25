package com.xuyang.springcloud.server_quartz.quartz;

import com.xuyang.springcloud.server_quartz.util.DateUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;

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
        File file = new File("D:\\file\\write\\" + nowDate);
        if(!file.exists()){
            file.mkdir();
        }
    }

    @Scheduled(cron = "0 50 23 * * ?")
    public void zipFileSchedule(){
       log.info("定时压缩文件");

    }
}
