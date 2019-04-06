package com.xuyang.springcloud.server_file.feign.ribbon;

import com.xuyang.springcloud.server_file.feign.UserInter;
import com.xuyang.springcloud.server_file.model.user.AccountUser;
import com.xuyang.springcloud.server_file.model.user.Result;
import com.xuyang.springcloud.server_file.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/3/30 01:25
 * @Description: 熔断机制：请求失败
 */
@Slf4j
@Service
@Component
public class UserInterImpl implements UserInter {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getUserInfoList(User user) {
        return null;
    }

    @Override
    public User getUserInfo(User user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/getUserInfo.do",User.class);
    }

    @Override
    public Result insertUserInfo(User user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/insertUserInfo.do",Result.class);
    }

    @Override
    public Result updateUser(User user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/updateUser.do",Result.class);
    }

    @Override
    public Result deleteUser(User user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/deleteUser.do",Result.class);
    }

    @Override
    public List<AccountUser> getAccountUserInfoList(AccountUser user) {
        return null;
    }

    @Override
    public AccountUser getAccountUserInfo(AccountUser user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/getAccountUserInfo.do",AccountUser.class);
    }

    @Override
    public Result insertAccountUserInfo(AccountUser user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/insertAccountUserInfo.do",Result.class);
    }

    @Override
    public Result updateAccountUser(AccountUser user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/updateAccountUser.do",Result.class);
    }

    @Override
    public Result deleteAccountUser(AccountUser user) {
        log.info("通过熔断的方式重新去掉用服务");
        return restTemplate.getForObject("http://user/deleteAccountUser.do",Result.class);
    }
}
