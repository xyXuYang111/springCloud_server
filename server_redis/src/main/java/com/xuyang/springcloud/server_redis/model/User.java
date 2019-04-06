package com.xuyang.springcloud.server_redis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 00:39
 * @Description:
 */
@Data
@Slf4j
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 6014126094393682752L;

    @JsonProperty(value = "userName")
    private String userName;

    @JsonProperty(value = "password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
