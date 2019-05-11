package com.xuyang.springcloud.server_mongodb.dao.Impl;

import com.xuyang.springcloud.server_mongodb.dao.MongoDbDao;
import com.xuyang.springcloud.server_mongodb.model.Mongodb;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Slf4j
@Component
public class MongoDbDaoImpl implements MongoDbDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Mongodb object, String collectionName) {
        mongoTemplate.insert(object, collectionName);
    }

    @Override
    public Mongodb findOne(Map<String, Object> params, String collectionName) {
        return  mongoTemplate.findOne(new Query(Criteria.where("id").is(params.get("id"))), Mongodb.class, collectionName);
    }

    @Override
    public List<Mongodb> findAll(Map<String, Object> params, String collectionName) {
        List<Mongodb> result = mongoTemplate.find(new Query(Criteria.where("age").lt(params.get("maxAge"))), Mongodb.class,collectionName);
        return result;
    }

    @Override
    public void update(Map<String, Object> params, String collectionName) {
        mongoTemplate.upsert(new Query(Criteria.where("id").is(params.get("id"))), new Update().set("name", params.get("name")), Mongodb.class,collectionName);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoTemplate.createCollection(collectionName);
    }

    @Override
    public void remove(Map<String, Object> params, String collectionName) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(params.get("id"))), Mongodb.class,collectionName);
    }
}
