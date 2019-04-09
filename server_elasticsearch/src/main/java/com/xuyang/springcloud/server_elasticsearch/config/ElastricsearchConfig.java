package com.xuyang.springcloud.server_elasticsearch.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

/**
 * @Auther: xuy
 * @Date: 2019/4/9 00:19
 * @Description:
 */
@Data
@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.xuyang.springcloud.server_elasticsearch.repository")
public class ElastricsearchConfig {

    private String EsHost = "127.0.0.1";

    private int EsPort = 9300;

    private String EsClusterName = "mkyong-cluster";

    @Bean(name = "elasticsearchClient")
    public TransportClient elasticsearchClient() throws Exception {
        TransportClientFactoryBean factory = new TransportClientFactoryBean();
        factory.setClusterName(EsClusterName);
        return factory.getObject();
    }

    @Bean(name = "elasticsearchTemplate")
    public ElasticsearchTemplate elasticsearchTemplate(TransportClient client) {
        return new ElasticsearchTemplate(client);
    }
}
