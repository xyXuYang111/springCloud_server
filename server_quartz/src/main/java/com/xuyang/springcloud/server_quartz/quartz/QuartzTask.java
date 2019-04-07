package com.xuyang.springcloud.server_quartz.quartz;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Auther: xuy
 * @Date: 2019/4/8 00:25
 * @Description:
 */
@Data
@Slf4j
@Component
public class QuartzTask {

    public void reptilian(){
      log.info("quartz-定时调度方法，每5秒执行一次");
    }
}
