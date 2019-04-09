package com.xuyang.springcloud.server_elasticsearch.elastricsearchService.impl;

import com.xuyang.springcloud.server_elasticsearch.elastricsearchService.UserService;
import com.xuyang.springcloud.server_elasticsearch.model.User;
import com.xuyang.springcloud.server_elasticsearch.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: xuy
 * @Date: 2019/4/9 00:50
 * @Description:
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        log.info("存储数据到es上去");
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        log.info("删除数据");
        userRepository.delete(user);
    }

    @Override
    public User findOne(String id) {
        log.info("根据ID查询指定数据");
        return userRepository.findById(id).get();
    }

    @Override
    public Iterable<User> findAll() {
        log.info("查询所有数据");
        return userRepository.findAll();
    }

    @Override
    public Page<User> findByAuthor(String author, PageRequest pageRequest) {
        log.info("分页查询");
        return userRepository.findByAuthor(author, pageRequest);
    }

    @Override
    public List<User> findByTitle(String title) {
        log.info("自定义查询");
        return userRepository.findByTitle(title);
    }
}
