package com.xuyang.springcloud.server_quartz.quartz;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

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

    @Scheduled(cron = "*/5 * * * * ?")
    public void text(){
        log.info("spring-tesk定时调度，每五秒执行一次");
    }
}
