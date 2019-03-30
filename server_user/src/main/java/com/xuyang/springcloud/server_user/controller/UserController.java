package com.xuyang.springcloud.server_user.controller;

import com.xuyang.springcloud.server_user.model.Result;
import com.xuyang.springcloud.server_user.model.User;
import jdk.nashorn.internal.ir.RuntimeNode;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/3/30 01:05
 * @Description:
 */
@Slf4j
@RestController
public class UserController {

    /**
     * 获取用户列表：
     * 整个用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "getUserInfoList.do", method = RequestMethod.GET)
    public List<User> getUserInfoList(@RequestBody User user) {
        log.info("查询所有用户信息");
        List<User> users = new ArrayList<>();
        return users;
    }

    /**
     * 获取操作人的信息
     * @param user
     * @return
     */
    @RequestMapping(value = "getUserInfo.do", method = RequestMethod.GET)
    public User getUserInfo(@RequestBody User user) {
        log.info("查询指定用户信息");
        User userInfo = new User();
        return userInfo;
    }

    @RequestMapping(value = "insertUserInfo.do", method = RequestMethod.GET)
    public Result insertUserInfo(@RequestBody User user){
        log.info("添加用户信息");
        Result result = new Result();
        return result;
    }

    @RequestMapping(value = "updateUser.do", method = RequestMethod.GET)
    public Result updateUser(@RequestBody User user){
        log.info("修改用户信息");
        Result result = new Result();
        return result;
    }

    @RequestMapping(value = "deleteUser.do", method = RequestMethod.GET)
    public Result deleteUser(@RequestBody User user){
        log.info("禁用用户");
        Result result = new Result();
        return result;
    }
}
