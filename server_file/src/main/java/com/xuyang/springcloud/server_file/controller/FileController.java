package com.xuyang.springcloud.server_file.controller;

import com.xuyang.springcloud.server_file.model.json.ResultJson;
import com.xuyang.springcloud.server_file.model.json.XmlJson;
import com.xuyang.springcloud.server_file.model.xml.XmlModel;
import com.xuyang.springcloud.server_file.util.FileUtil;
import com.xuyang.springcloud.server_file.util.JsonChangeXml;
import com.xuyang.springcloud.server_file.util.ResultUtil;
import com.xuyang.springcloud.server_file.util.XmlUtil;
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
@RestController
public class FileController {

    /**
     * 将报文转换成xml，写到文本中
     * @param xmlJson
     * @return
     */
    @RequestMapping(value = "writeInFile.do", method = RequestMethod.GET)
    public ResultJson writeInFile(@RequestBody XmlJson xmlJson){
        try {
            String filePath = xmlJson.getFilePath();
            //xmlJson转换成xmlModel
            XmlModel xmlModel = JsonChangeXml.jsonChangeXmlModel(xmlJson);
            //将xml转换成字符串
            String xml = XmlUtil.convertObjectToXmlStr(xmlModel);
            //xml字符串写到文档中
            FileUtil.valueWriteInFile(xml, filePath);
            //调用相关方法，返回结果集
            return ResultUtil.successResult(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.errorResult(e.getMessage());
        }
    }

    /**
     * 切割文件：返回相关文件名
     * @param xmlJson
     * @return
     */
    @RequestMapping(value = "cutFile.do", method = RequestMethod.GET)
    public ResultJson cutFile(@RequestBody XmlJson xmlJson){
        try {
            String fileName = xmlJson.getFileName();
            String filePath = xmlJson.getFilePath();
            //切割
            List<String> fileNameList = FileUtil.splitDemo(filePath, fileName);
            //调用相关方法，返回结果集
            return ResultUtil.successResult(fileNameList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.errorResult(e.getMessage());
        }
    }

    /**
     * 合并文件，返回文件名称
     * @param xmlJson
     * @return
     */
    @RequestMapping(value = "mergeFile.do", method = RequestMethod.GET)
    public ResultJson mergeFile(@RequestBody XmlJson xmlJson){
        try {
            String fileName = xmlJson.getFileName();
            String filePath = xmlJson.getFilePath();
            FileUtil.sequenceDemo(fileName, filePath);
            //调用相关方法，返回结果集
            return ResultUtil.successResult(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.errorResult(e.getMessage());
        }
    }
}
