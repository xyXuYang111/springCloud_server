package com.xuyang.springcloud.server_file.util;

import com.github.pagehelper.util.StringUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 00:30
 * @Description:
 */
@Data
@Slf4j
public class XmlUtil {

    /**
     * 对象转换成xml
     * @param object
     * @return
     * @throws Exception
     */
    public static String convertObjectToXmlStr(Object object) throws Exception {

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshal = context.createMarshaller();

        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化输出
        marshal.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 编码格式,默认为utf-8
        marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息
        marshal.setProperty("jaxb.encoding", "utf-8");
        marshal.marshal(object, writer);

        return new String(writer.getBuffer());
    }

    /**
     * 将String类型的xml转换成对象
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file文件的xml转换成对象
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            try {
                fr = new FileReader(xmlPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }


}
