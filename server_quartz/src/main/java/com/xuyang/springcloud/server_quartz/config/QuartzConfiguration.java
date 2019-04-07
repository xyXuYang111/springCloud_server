package com.xuyang.springcloud.server_quartz.config;

import com.xuyang.springcloud.server_quartz.quartz.QuartzTask;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Auther: xuy
 * @Date: 2019/4/8 00:24
 * @Description: quartz：一个定时调度一个配置
 */
@Data
@Slf4j
@Configuration
public class QuartzConfiguration {

    /**
     *  配置任务
     * @param quartzTask QuartzTask为需要执行的任务
     * @return
     */
    @Bean(name = "reptilianJob")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(QuartzTask quartzTask) {

        log.info("quartz-配置任务");
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();

        // 是否并发执行
        jobDetail.setConcurrent(true);
        // 设置任务的名字
        jobDetail.setName("reptilianJob");
        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("reptilianJobGroup");
        // 需要执行的对象
        jobDetail.setTargetObject(quartzTask);
        /*
         * TODO  非常重要
         * 执行QuartzTask类中的需要执行方法
         */
        jobDetail.setTargetMethod("reptilian");
        return jobDetail;
    }

    /**
     * 定时触发器
     * @param reptilianJob 任务
     * @return
     */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(@Qualifier("reptilianJob")JobDetail reptilianJob){
        log.info("quartz-定时触发器");
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(reptilianJob);
        //cron表达式，每1分钟执行一次
        tigger.setCronExpression("*/5 * * * * ?");
        tigger.setName("reptilianTrigger");
        return tigger;
    }

    /**
     * 调度工厂
     * @param jobTrigger 触发器
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(@Qualifier("jobTrigger") Trigger jobTrigger) {
        log.info("quartz-调度工厂");
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);

        // 注册触发器
        factoryBean.setTriggers(jobTrigger);
        return factoryBean;
    }
}
