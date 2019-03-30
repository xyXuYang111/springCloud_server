package com.xuyang.springcloud.server_file.controller;

import com.xuyang.springcloud.server_file.model.json.ResultJson;
import com.xuyang.springcloud.server_file.model.json.XmlJson;
import com.xuyang.springcloud.server_file.model.xml.XmlModel;
import com.xuyang.springcloud.server_file.util.FileUtil;
import com.xuyang.springcloud.server_file.util.JsonChangeXml;
import com.xuyang.springcloud.server_file.util.ResultUtil;
import com.xuyang.springcloud.server_file.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/3/28 01:01
 * @Description:
 */
@Slf4j
@RestController
public class FileController {

    /**
     * 将报文转换成xml，写到文本中
     * 将用户信息通过报文写到文本中
     * @param xmlJson
     * @return
     */
    @RequestMapping(value = "writeUserInfoInFile.do", method = RequestMethod.GET)
    public ResultJson writeUserInfoInFile(@RequestBody XmlJson xmlJson){
        try {
            String filePath = xmlJson.getFilePath();
            //xmlJson转换成xmlModel
            XmlModel xmlModel = JsonChangeXml.jsonChangeXmlModel(xmlJson);
            //将xml转换成字符串
            String xml = XmlUtil.convertObjectToXmlStr(xmlModel);
            log.info("报文结构:"+xml);
            //xml字符串写到文档中
            FileUtil.valueWriteInFile(xml, filePath);

            //调用相关方法，返回结果集
            return ResultUtil.successResult(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorResult(e.getMessage());
        }
    }

}
