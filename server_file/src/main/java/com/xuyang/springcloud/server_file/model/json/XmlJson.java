package com.xuyang.springcloud.server_file.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 01:02
 * @Description:
 */
@Slf4j
@Data
@ToString
public class XmlJson implements Serializable {

    private static final long serialVersionUID = -7481970352234053826L;

    @JsonProperty(value = "six")
    private String six;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "userName")
    private String userName;

    @JsonProperty(value = "password")
    private String password;

    @JsonProperty(value = "terrace")
    private String terrace;

    @JsonProperty(value = "createTime")
    private String createTime;

    @JsonProperty(value = "fileName")
    private String fileName;

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public String getTerrace() {
        return terrace;
    }

    public void setTerrace(String terrace) {
        this.terrace = terrace;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
