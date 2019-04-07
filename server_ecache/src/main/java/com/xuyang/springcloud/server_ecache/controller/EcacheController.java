package com.xuyang.springcloud.server_ecache.controller;

import com.xuyang.springcloud.server_ecache.ecache.EcacheService;
import com.xuyang.springcloud.server_ecache.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 23:46
 * @Description:
 */
@Data
@Slf4j
@RestController
public class EcacheController {

    @Autowired
    private EcacheService ecacheServic;

    @RequestMapping(value = "userCacheList.do", method = RequestMethod.GET)
    public String userCacheList(@RequestBody User user){
        List<User> userList = ecacheServic.userCacheList("1", user);
        log.info(userList.get(0).toString());
        return "通过缓存获取数据";
    }

    @RequestMapping(value = "userCachePut.do", method = RequestMethod.GET)
    public String userCachePut(@RequestBody User user){
        List<User> userList = ecacheServic.userCacheList("1", user);
        log.info("旧缓存：" +userList.get(0).toString());
        ecacheServic.userCachePut("1", user);
        List<User> userListNew = ecacheServic.userCacheList("1", user);
        log.info("新缓存：" + userListNew.get(0).toString());
        return "修改缓存获取数据";
    }

    @RequestMapping(value = "userCacheDelete.do", method = RequestMethod.GET)
    public String userCacheDelete(){
        ecacheServic.userCacheDelete("1");
        return "删除缓存获取数据";
    }
}
