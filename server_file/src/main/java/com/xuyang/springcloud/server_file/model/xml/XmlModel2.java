package com.xuyang.springcloud.server_file.model.xml;

import com.xuyang.springcloud.server_file.model.xml.model.Person;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 00:44
 * @Description:
 */
@Slf4j
@Data
@ToString
@XmlRootElement(name = "xml")
public class XmlModel2 implements Serializable {

    private static final long serialVersionUID = 2065353650411546163L;

    @XmlElement(name = "person")
    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
