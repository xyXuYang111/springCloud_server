package com.xuyang.springcloud.server_file.model.xml.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 00:57
 * @Description:
 */
@Slf4j
@Data
@ToString
@XmlRootElement(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = -2277482673972742860L;

    @XmlAttribute(name = "userName")
    private String userName;

    @XmlAttribute(name = "six")
    private String six;

    @XmlAttribute(name = "phone")
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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
}
