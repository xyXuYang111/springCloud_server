package com.xuyang.springcloud.server_file.model.xml;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/3/26 23:40
 * @Description:
 */
@Slf4j
@ToString
@Data
@XmlRootElement(name = "xml")
public class XmlModel implements Serializable {

    private static final long serialVersionUID = 6933129608009206001L;

    @XmlAttribute(name = "userName")
    private String userName;

    @XmlAttribute(name = "password")
    private String password;

    @XmlAttribute(name = "terrace")
    private String terrace;

    @XmlAttribute(name = "createTime")
    private String createTime;

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
}
