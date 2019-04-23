package com.xuyang.springcloud.note.feign.impl;

import com.xuyang.springcloud.note.feign.RedisFeign;
import com.xuyang.springcloud.note.feign.model.RedisModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Auther: cypc
 * @Date: 2019-4-22 11:26
 * @Description:
 */
@Data
@Slf4j
@Component
@Service
public class RedisFeignImpl implements RedisFeign {


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
