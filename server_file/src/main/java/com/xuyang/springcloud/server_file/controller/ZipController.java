package com.xuyang.springcloud.server_file.controller;

import com.xuyang.springcloud.server_file.model.json.ResultJson;
import com.xuyang.springcloud.server_file.model.json.XmlJson;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cypc
 * @Date: 2019-3-28 11:37
 * @Description: 文件压缩包
 */
@Data
@Slf4j
@RestController
public class ZipController {

    @RequestMapping(value = "zipWar.do", method = RequestMethod.GET)
    public ResultJson zipWar(@RequestBody XmlJson xmlJson){
        String filePath = xmlJson.getFilePath();
        return null;
    }
}
