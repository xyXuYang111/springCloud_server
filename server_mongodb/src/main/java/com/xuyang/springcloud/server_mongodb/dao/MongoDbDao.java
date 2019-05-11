package com.xuyang.springcloud.server_mongodb.dao;

import com.xuyang.springcloud.server_mongodb.model.Mongodb;

import java.util.List;
import java.util.Map;

public interface MongoDbDao {

    //添加
    public void insert(Mongodb object, String collectionName);
    //根据条件查找
    public Mongodb findOne(Map<String, Object> params, String collectionName);
    //查找所有
    public List<Mongodb> findAll(Map<String, Object> params, String collectionName);
    //修改
    public void update(Map<String, Object> params, String collectionName);
    //创建集合
    public void createCollection(String collectionName);
    //根据条件删除
    public void remove(Map<String, Object> params, String collectionName);
}
