package com.xuyang.springcloud.server_freemarker.controller;

import com.xuyang.springcloud.server_freemarker.util.FreemarkerUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@RestController
public class FreemarkerController {

    @ResponseBody
    @RequestMapping(value = "fileToWeb", method = RequestMethod.POST)
    public String fileToWeb(){
        log.info("生成word返回到界面上");
        Map<String, Object> map = new HashMap<>();
        try {
            //生成到本地
            FreemarkerUtil.createDoc(map, "D://text.docx", "1.ftl");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "模板生成成功";
    }
}
