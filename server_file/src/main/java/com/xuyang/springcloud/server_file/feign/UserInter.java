package com.xuyang.springcloud.server_file.feign;

import com.xuyang.springcloud.server_file.model.user.AccountUser;
import com.xuyang.springcloud.server_file.model.user.Result;
import com.xuyang.springcloud.server_file.model.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/3/30 01:24
 * @Description:
 */
@FeignClient(value = "", fallback = UserInterImpl.class)
@Component
public interface UserInter {

    @RequestMapping(value = "getUserInfoList.do", method = RequestMethod.GET)
    public List<User> getUserInfoList(@RequestBody User user);

    @RequestMapping(value = "getUserInfo.do", method = RequestMethod.GET)
    public User getUserInfo(@RequestBody User user);

    @RequestMapping(value = "insertUserInfo.do", method = RequestMethod.GET)
    public Result insertUserInfo(@RequestBody User user);

    @RequestMapping(value = "updateUser.do", method = RequestMethod.GET)
    public Result updateUser(@RequestBody User user);

    @RequestMapping(value = "deleteUser.do", method = RequestMethod.GET)
    public Result deleteUser(@RequestBody User user);

    @RequestMapping(value = "getAccountUserInfoList.do", method = RequestMethod.GET)
    public List<AccountUser> getAccountUserInfoList(@RequestBody AccountUser user);

    @RequestMapping(value = "getAccountUserInfo.do", method = RequestMethod.GET)
    public AccountUser getAccountUserInfo(@RequestBody AccountUser user);

    @RequestMapping(value = "insertAccountUserInfo.do", method = RequestMethod.GET)
    public Result insertAccountUserInfo(@RequestBody AccountUser user);

    @RequestMapping(value = "updateAccountUser.do", method = RequestMethod.GET)
    public Result updateAccountUser(@RequestBody AccountUser user);

    @RequestMapping(value = "deleteAccountUser.do", method = RequestMethod.GET)
    public Result deleteAccountUser(@RequestBody AccountUser user);
}
