package com.xuyang.springcloud.server_file.feign.impl;

import com.xuyang.springcloud.server_file.feign.RedisFeign;
import com.xuyang.springcloud.server_file.feign.model.RedisModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: cypc
 * @Date: 2019-4-22 11:26
 * @Description:
 */
@Data
@Slf4j
@Component
@Service
public class RedisFeignImpl implements RedisFeign{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String insertObjectList(RedisModel redisModel) {
        return null;
    }

    @Override
    public String insertGetString(RedisModel redisModel) {
        return null;
    }

    @Override
    public String insertString(RedisModel redisModel) {
        return null;
    }
}
