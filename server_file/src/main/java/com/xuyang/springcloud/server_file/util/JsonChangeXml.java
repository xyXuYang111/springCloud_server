package com.xuyang.springcloud.server_file.util;

import com.xuyang.springcloud.server_file.model.json.XmlJson;
import com.xuyang.springcloud.server_file.model.xml.XmlModel;
import com.xuyang.springcloud.server_file.model.xml.XmlModel2;
import com.xuyang.springcloud.server_file.model.xml.model.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019-3-28 11:08
 * @Description:
 */
@Data
@Slf4j
public class JsonChangeXml {

    /**
     * 第一种xml报文
     * @param xmlJson
     * @return
     */
    public static XmlModel jsonChangeXmlModel(XmlJson xmlJson){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        XmlModel xmlModel = new XmlModel();
        xmlModel.setUserName(xmlJson.getUserName());
        xmlModel.setPassword(xmlJson.getPassword());
        xmlModel.setTerrace(xmlJson.getTerrace());
        xmlModel.setCreateTime(df.format(new Date()));
        return xmlModel;
    }

    /**
     * 第一种xml报文
     * @param personList
     * @return
     */
    public static XmlModel2 jsonChangeXmlModel2(List<Person> personList){
        XmlModel2 xmlModel = new XmlModel2();
        xmlModel.setPersonList(personList);
        return xmlModel;
    }
}
