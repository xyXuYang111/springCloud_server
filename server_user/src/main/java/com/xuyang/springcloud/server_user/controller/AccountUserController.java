package com.xuyang.springcloud.server_user.controller;

import com.xuyang.springcloud.server_user.model.AccountUser;
import com.xuyang.springcloud.server_user.model.Result;
import com.xuyang.springcloud.server_user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/3/30 01:17
 * @Description:
 */
@Slf4j
@RestController
public class AccountUserController {

    /**
     * 获取用户列表：
     * 整个用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "getAccountUserInfoList.do", method = RequestMethod.GET)
    public List<AccountUser> getAccountUserInfoList(@RequestBody AccountUser user) {
        log.info("查询用户其他平台账号");
        List<AccountUser> users = new ArrayList<>();
        return users;
    }

    /**
     * 获取操作人的信息
     * @param user
     * @return
     */
    @RequestMapping(value = "getAccountUserInfo.do", method = RequestMethod.GET)
    public AccountUser getAccountUserInfo(@RequestBody AccountUser user) {
        log.info("查询指定平台账号信息");
        AccountUser userInfo = new AccountUser();
        return userInfo;
    }

    @RequestMapping(value = "insertAccountUserInfo.do", method = RequestMethod.GET)
    public Result insertAccountUserInfo(@RequestBody AccountUser user){
        log.info("添加用户账号信息");
        Result result = new Result();
        return result;
    }

    @RequestMapping(value = "updateAccountUser.do", method = RequestMethod.GET)
    public Result updateAccountUser(@RequestBody AccountUser user){
        log.info("修改用户账号信息");
        Result result = new Result();
        return result;
    }

    @RequestMapping(value = "deleteAccountUser.do", method = RequestMethod.GET)
    public Result deleteAccountUser(@RequestBody AccountUser user){
        log.info("删除用户账号信息");
        Result result = new Result();
        return result;
    }
}
