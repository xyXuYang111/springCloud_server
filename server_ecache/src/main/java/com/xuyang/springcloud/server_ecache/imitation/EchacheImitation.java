package com.xuyang.springcloud.server_ecache.imitation;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xuy
 * @Date: 2019/5/13 22:05
 * @Description:
 */
@Data
@Slf4j
public class EchacheImitation {

    //缓存存放地方
    private static Map<String, Object> map = new HashMap<>();

    static {
        //单例模式：静态莫板块
        //初始化数据
        initEcache();
    }

    /**
     * 定义缓存
     */
    public static void initEcache(){
        log.info("初始化自定义缓存");
        map.put("111", "11111");
        map.put("222", "11111");
    }

    /**
     * 获取缓存
     * @param id
     * @return
     */
    public static Object ecacheMap(String id){
        Object object = map.get(id);
        return object;
    }

    public static void main(String[] args){
        //读取缓存
        System.out.println(ecacheMap("111"));
    }
}
