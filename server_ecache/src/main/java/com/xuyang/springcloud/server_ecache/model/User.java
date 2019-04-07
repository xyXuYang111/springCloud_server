package com.xuyang.springcloud.server_ecache.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/7 23:28
 * @Description:
 */
@Data
@Slf4j
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 9092819595183153223L;

    @JsonProperty(value = "userName")
    private String userName;

    @JsonProperty(value = "password")
    private String password;

    private String sex;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
