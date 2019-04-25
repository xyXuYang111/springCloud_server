package com.xuyang.springcloud.server_redis.controller;

import com.xuyang.springcloud.server_redis.model.RedisModel;
import com.xuyang.springcloud.server_redis.server.RedisService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 01:01
 * @Description:
 */
@Slf4j
@Data
@RestController
public class RedisServiceController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "insertString.do", method = RequestMethod.POST)
    public String insertString(@RequestBody RedisModel redisModel){
        log.info("key-value存储");
        String key = redisModel.getKey();
        String value = redisModel.getValue();
        redisService.set(key, value);
        log.info("存储成功");
        return "key-value存储成成功";
    }

    @RequestMapping(value = "insertGetString.do", method = RequestMethod.POST)
    public String insertGetString(@RequestBody RedisModel redisModel){
        log.info("key-value获取");
        String key = redisModel.getKey();
        log.info((String) redisService.get(key));
        log.info("获取成功");
        return "key-value获取成功";
    }

    @RequestMapping(value = "insertMap.do", method = RequestMethod.POST)
    public String insertMap(@RequestBody RedisModel redisModel){
        log.info("key-map存储");
        String key = redisModel.getKey();
        Map<String, Object> map = new HashMap<>();
        map.put(key, redisModel);
        redisService.hmset(key, map);
        log.info("存储成功");
        return "key-map存储成成功";
    }

    @RequestMapping(value = "insertGetMap.do", method = RequestMethod.POST)
    public String insertGetMap(@RequestBody RedisModel redisModel){
        log.info("key-map获取");
        String key = redisModel.getKey();
        Map<Object, Object> map = redisService.hmget(key);
        RedisModel redisModelInfo = (RedisModel)map.get(key);
        log.info("获取的结果是：" + redisModelInfo.toString());
        log.info("获取成功");
        return "key-map获取成功";
    }

    @RequestMapping(value = "insertList.do", method = RequestMethod.POST)
    public String insertList(@RequestBody RedisModel redisModel){
        log.info("key-list存储");
        String key = redisModel.getKey();
        List<Object> list = new ArrayList<>();
        list.add(redisModel);
        redisService.lSet(key, list);
        log.info("存储成功");
        return "key-list存储成成功";
    }

    @RequestMapping(value = "insertObjectList.do", method = RequestMethod.POST)
    public String insertObjectList(@RequestBody RedisModel redisModel){
        log.info("key-list存储");
        String key = redisModel.getKey();
        Object object = redisModel.getObject();
        redisService.lSet(key, object);
        log.info("存储成功");
        return "key-list存储成成功";
    }

    @RequestMapping(value = "insertGetList.do", method = RequestMethod.POST)
    public String insertGetList(@RequestBody RedisModel redisModel){
        log.info("key-list获取");
        String key = redisModel.getKey();
        int num = redisModel.getNum();
        RedisModel redisModelInfo = (RedisModel)redisService.lGetIndex(key, num);
        log.info("获取的结果集：" + redisModelInfo.toString());
        log.info("获取成功");
        return "key-list获取成功";
    }
}
