package com.xuyang.springcloud.server_elasticsearch.controller;

import com.xuyang.springcloud.server_elasticsearch.elastricsearchService.UserService;
import com.xuyang.springcloud.server_elasticsearch.model.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/9 00:57
 * @Description:
 */
@Data
@Slf4j
@RestController
public class ElastricsearchController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "insertEsValue.do", method = RequestMethod.GET)
    public String insertEsValue(HttpServletRequest request){
        User user = new User();
        user.setId("1");
        user.setAuthor("xuyang");
        user.setTitle("xu");
        userService.save(user);
        return "es新增操作成功";
    }

    @RequestMapping(value = "findEsValue.do", method = RequestMethod.GET)
    public String findEsValue(){
        User user = userService.findOne("1");
        log.info(user.toString());
        return "es查询操作成功";
    }

    @RequestMapping(value = "findEsAllValue.do", method = RequestMethod.GET)
    public String findAllEsValue(){
        Iterable<User> userList = userService.findAll();
        User user = userList.iterator().next();
        log.info(user.toString());
        return "es查询所有操作成功";
    }

    @RequestMapping(value = "deleteEsValue.do", method = RequestMethod.GET)
    public String deleteEsValue(){
        User user = new User();
        user.setId("1");
        user.setAuthor("xuyang");
        user.setTitle("xu");
        userService.delete(user);
        return "es删除操作成功";
    }
}
