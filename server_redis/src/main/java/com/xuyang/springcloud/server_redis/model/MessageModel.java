package com.xuyang.springcloud.server_redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/21 03:50
 * @Description:
 */
@Data
@Slf4j
@ToString
public class MessageModel implements Serializable {

    private static final long serialVersionUID = 33694131737505729L;

    @JsonProperty(value = "statue")
    private String statue;

    @JsonProperty(value = "desc")
    private String desc;

    @JsonProperty(value = "type")
    private String type;

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
