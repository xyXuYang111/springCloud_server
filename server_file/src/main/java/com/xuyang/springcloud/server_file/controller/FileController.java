package com.xuyang.springcloud.server_file.controller;

import com.xuyang.springcloud.server_file.model.json.ResultJson;
import com.xuyang.springcloud.server_file.model.json.XmlJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        //xmlJson转换成xmlModel2和xmlModel
        //调用相关方法，返回结果集
        return null;
    }

    /**
     * 切割文件：返回相关文件名
     * @param xmlJson
     * @return
     */
    @RequestMapping(value = "cutFile.do", method = RequestMethod.GET)
    public ResultJson cutFile(@RequestBody XmlJson xmlJson){
        //xmlJson转换成xmlModel2和xmlModel
        //调用相关方法，返回结果集
        return null;
    }

    /**
     * 合并文件，返回文件名称
     * @param xmlJson
     * @return
     */
    @RequestMapping(value = "mergeFile.do", method = RequestMethod.GET)
    public ResultJson mergeFile(@RequestBody XmlJson xmlJson){
        //xmlJson转换成xmlModel2和xmlModel
        //调用相关方法，返回结果集
        return null;
    }
}
