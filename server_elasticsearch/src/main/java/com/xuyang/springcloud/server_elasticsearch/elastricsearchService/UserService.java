package com.xuyang.springcloud.server_elasticsearch.elastricsearchService;

import com.xuyang.springcloud.server_elasticsearch.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Book;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/9 00:49
 * @Description:
 */
public interface UserService {

    User save(User user);

    void delete(User user);

    User findOne(String id);

    Iterable<User> findAll();

    Page<User> findByAuthor(String author, PageRequest pageRequest);

    List<User> findByTitle(String title);

}
