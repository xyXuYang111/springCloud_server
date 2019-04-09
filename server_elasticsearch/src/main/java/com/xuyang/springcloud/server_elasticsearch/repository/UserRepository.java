package com.xuyang.springcloud.server_elasticsearch.repository;

import com.xuyang.springcloud.server_elasticsearch.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/4/9 00:46
 * @Description:
 */
@Component
public interface UserRepository extends ElasticsearchRepository<User, String> {

    Page<User> findByAuthor(String author, Pageable pageable);

    List<User> findByTitle(String title);

}
