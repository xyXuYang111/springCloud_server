package com.xuyang.springcloud.server_file.aop;

import com.xuyang.springcloud.server_file.feign.RedisFeign;
import com.xuyang.springcloud.server_file.feign.model.RedisModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: cypc
 * @Date: 2019-4-20 09:36
 * @Description: 异常监听：成功通过kafka发送消息，并记录到redis和elastic上
 */
@Data
@Slf4j
@Component
@Aspect
public class FileExceptionAspect {

    @Autowired
    private RedisFeign redisFeign;

    //指定切入点表达式，拦截那些方法，即为那些类生成代理对象
    //@Pointcut("execution(* com.bie.aop.UserDao.save(..))")  ..代表所有参数
    //@Pointcut("execution(* com.bie.aop.UserDao.*())")  指定所有的方法
    //@Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法

    @Pointcut("execution(* com.xuyang.springcloud.server_file.controller.FileController.*(..))")
    public void pointCut(){ }

    /**
     * 参数校验
     * @param joinPoint
     */
    @Before("pointCut()")
    public void begin(JoinPoint joinPoint){
        log.info("前置通知");
        log.info("目标方法名为:" + joinPoint.getSignature().getName());
        log.info("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());

        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        log.info("被代理的对象:" + joinPoint.getTarget());
        log.info("代理对象自己:" + joinPoint.getThis());

    }

    /**
     * 异常抓取
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("环绕异常通知");
        String methodName = joinPoint.getSignature().getName();
        log.info("执行的方法名：" + methodName);
        StringBuilder stringBuilder = new StringBuilder();
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("第" + (i+1) + "个参数为:" + args[i]);
            stringBuilder.append(args[i]).append(",");
        }

        RedisModel redisModel = new RedisModel();
        redisModel.setKey(methodName);
        redisModel.setObject(stringBuilder.toString());

        //将key存放到
        redisFeign.insertObjectList(redisModel);
    }

    /**
     * 操作成功日志记录
     * @param joinPoint
     */
    @After("pointCut()")
    public void close(JoinPoint joinPoint){
        log.info("后置通知");

        String methodName = joinPoint.getSignature().getName();
        log.info("执行的方法名：" + methodName);

        StringBuilder stringBuilder = new StringBuilder();
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            log.info("第" + (i+1) + "个参数为:" + args[i]);
            stringBuilder.append(args[i]).append(",");
        }
    }
}
