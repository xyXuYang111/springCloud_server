package com.xuyang.springcloud.server_mongodb.repository;

import com.xuyang.springcloud.server_mongodb.dao.MongoDbDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MongodbRepository {

    @Autowired
    private MongoDbDao mongoDbDao;
}
