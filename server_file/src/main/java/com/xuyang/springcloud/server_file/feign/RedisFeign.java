package com.xuyang.springcloud.server_file.feign;

import com.xuyang.springcloud.server_file.feign.impl.RedisFeignImpl;
import com.xuyang.springcloud.server_file.feign.model.RedisModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: cypc
 * @Date: 2019-4-22 11:14
 * @Description: redis的熔断机制
 */
@FeignClient(value = "redis", fallback = RedisFeignImpl.class)
@Component
public interface RedisFeign {

    /**
     * 添加list中的单个对象
     * @param redisModel
     * @return
     */
    @RequestMapping(value = "insertObjectList.do", method = RequestMethod.POST)
    public String insertObjectList(@RequestBody RedisModel redisModel);

    /**
     * key--value添加
     * @param redisModel
     * @return
     */
    @RequestMapping(value = "insertString.do", method = RequestMethod.GET)
    public String insertString(@RequestBody RedisModel redisModel);

    /**
     * 查询单个数据
     * @param redisModel
     * @return
     */
    @RequestMapping(value = "insertGetString.do", method = RequestMethod.GET)
    public String insertGetString(@RequestBody RedisModel redisModel);
}
