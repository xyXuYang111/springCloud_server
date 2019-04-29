package com.xuyang.springcloud.server_mongodb.config;

import com.mongodb.ClientSessionOptions;
import com.mongodb.DB;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
public class MongodbConfig {

    @Bean(name = "mongoClientFactoryBean")
    public MongoClientFactoryBean mongoClientFactoryBean(){
        MongoClientFactoryBean mongoClientFactoryBean = new MongoClientFactoryBean();
        mongoClientFactoryBean.setHost("");
        mongoClientFactoryBean.setPort(111);

        //已经默认帮你配置好了
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        //香瓜你的参数
        mongoClientFactoryBean.setMongoClientOptions(builder.build());
        return mongoClientFactoryBean;
    }

    @Bean(name = "mongoDbFactory")
    public MongoDbFactory mongoDbFactory(
            @Qualifier("mongoClientFactoryBean") MongoClientFactoryBean mongoClientFactoryBean){

        return null;
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate(@Qualifier("mongoDbFactory") MongoDbFactory mongoDbFactory){
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
        return mongoTemplate;
    }
}
