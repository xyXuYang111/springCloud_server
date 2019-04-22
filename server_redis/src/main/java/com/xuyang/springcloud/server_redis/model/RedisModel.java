package com.xuyang.springcloud.server_redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 01:09
 * @Description:
 */
@Data
@Slf4j
@ToString
public class RedisModel implements Serializable {

    private static final long serialVersionUID = -5832190812949321538L;

    @JsonProperty(value = "key")
    private String key;

    @JsonProperty(value = "value")
    private String value;

    @JsonProperty(value = "object")
    private Object object;

    @JsonProperty(value = "num")
    private int num;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
