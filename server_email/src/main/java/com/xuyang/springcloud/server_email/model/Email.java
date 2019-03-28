package com.xuyang.springcloud.server_email.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Auther: 许洋
 * @Date: 2019/1/6 21:51
 * @Description:
 */
@Data
@Slf4j
public class Email implements Serializable {

    private static final long serialVersionUID = -8991756927614538137L;

    @JsonProperty(value = "titleName")
    private String titleName;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "sendName")
    private String sendName;

    @JsonProperty(value = "sendNumber")
    private String sendNumber;

    @JsonProperty(value = "sendPassword")
    private String sendPassword;

    @JsonProperty(value = "receiveName")
    private String receiveName;

    @JsonProperty(value = "receiveNumber")
    private String receiveNumber;

    @JsonProperty(value = "receivePassword")
    private String receivePassword;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(String sendNumber) {
        this.sendNumber = sendNumber;
    }

    public String getSendPassword() {
        return sendPassword;
    }

    public void setSendPassword(String sendPassword) {
        this.sendPassword = sendPassword;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveNumber() {
        return receiveNumber;
    }

    public void setReceiveNumber(String receiveNumber) {
        this.receiveNumber = receiveNumber;
    }

    public String getReceivePassword() {
        return receivePassword;
    }

    public void setReceivePassword(String receivePassword) {
        this.receivePassword = receivePassword;
    }
}
