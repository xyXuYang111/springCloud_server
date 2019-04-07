package com.xuyang.springcloud.server_ecache.ecache;

import com.xuyang.springcloud.server_ecache.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 23:27
 * @Description:
 */
@Slf4j
@Data
@Component
public class EcacheService {

    @Cacheable(value = "cacheName", key = "'ecache_'+ #key")
    public List<User> userCacheList(String key, User user){
        log.info("获取缓存数据");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }

    @CacheEvict(value = "cacheName", key = "'ecache_'+ #key")
    public void userCacheDelete(String key){
        log.info("删除缓存");
    }

    @CachePut(value = "cacheName", key = "'ecache_'+ #key")
    public List<User> userCachePut(String key, User user){
        log.info("修改缓存数据");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }
}
