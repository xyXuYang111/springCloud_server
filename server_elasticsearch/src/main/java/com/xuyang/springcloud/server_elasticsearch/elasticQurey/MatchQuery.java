package com.xuyang.springcloud.server_elasticsearch.elasticQurey;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Map;

@Component
@Data
@Slf4j
public class MatchQuery {

    @Autowired
    private TransportClient transportClient;

    public void matchQuery() throws Exception {
        QueryBuilder builder = QueryBuilders.matchQuery("interests", "changge");
        SearchResponse response = transportClient.prepareSearch("lib3").setQuery(builder).get();
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            //将获取的值转换成map的形式
            Map<String, Object> map = hit.getSourceAsMap();
            for (String key : map.keySet()) {
                System.out.println(key + " key对应的值为：" + map.get(key));
            }
        }
    }

    public void multiMatch() throws Exception{
        //第一个参数是查询的值，后面的参数是字段名，可以跟多个字段，用逗号隔开
        QueryBuilder builder = QueryBuilders.multiMatchQuery("changge", "address","interests");
        SearchResponse response = transportClient.prepareSearch("lib3").setQuery(builder).get();
        SearchHits hits = response.getHits();
        for(SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
            //将获取的值转换成map的形式
            Map<String, Object> map = hit.getSourceAsMap();
            for(String key:map.keySet()) {
                System.out.println(key +" key对应的值为：" +map.get(key));
            }
        }
    }

    public void term() throws Exception{
        //term查询是不进行分词的
        QueryBuilder builder = QueryBuilders.termQuery("interests", "changge");
        SearchResponse response = transportClient.prepareSearch("lib3").setQuery(builder).get();
        SearchHits hits = response.getHits();
        for(SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
            //将获取的值转换成map的形式
            Map<String, Object> map = hit.getSourceAsMap();
            for(String key:map.keySet()) {
                System.out.println(key +" key对应的值为：" +map.get(key));
            }
        }
    }

    /**
     * 当使用term查询中文时，比如查询"人类"，我们是查不出来的，因为字段设置了ik分词器，他会将“人类”分成“人”和“类”，
     * 所有针对这种情况，我们需要将该字段类型临时转成keword类型，转换成后当字段中有"人类很好"的文章，我们也查询不出来，只会查询出字段为人类的文章。
     * 如下：
     * @throws Exception
     */
    public void termReal() throws Exception {
        //term查询是不进行分词的
        QueryBuilder builder = QueryBuilders.termQuery("interests.keword", "人类");
        SearchResponse response = transportClient.prepareSearch("lib3").setQuery(builder).get();
        SearchHits hits = response.getHits();
        for(SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
            //将获取的值转换成map的形式
            Map<String, Object> map = hit.getSourceAsMap();
            for(String key:map.keySet()) {
                System.out.println(key +" key对应的值为：" +map.get(key));
            }
        }
    }

    //terms查询：与term区别在于可以在同个字段中同时匹配多个条件，但是不支持分词
    public void terms() throws Exception {
        //terms查询是不进行分词的 与term的区别在terms可以指定一个字段匹配多个查询内容
        QueryBuilder builder = QueryBuilders.termsQuery("interests", "changge","旅游");
        SearchResponse response = transportClient.prepareSearch("lib3").setQuery(builder).get();
        SearchHits hits = response.getHits();
        for(SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
            //将获取的值转换成map的形式
            Map<String, Object> map = hit.getSourceAsMap();
            for(String key:map.keySet()) {
                System.out.println(key +" key对应的值为：" +map.get(key));
            }
        }
    }

    public void range() throws Exception{
        //rangeQurey 第一个参数为字段名，后面是范围 在设置日期格式
        QueryBuilder builder = QueryBuilders.rangeQuery("birthday").from("1990-01-01").to("2000-10-10").format("yyyy-MM-dd");
        SearchResponse response = transportClient.prepareSearch("lib3").setQuery(builder).get();
        SearchHits hits = response.getHits();
        for(SearchHit hit:hits) {
            System.out.println(hit.getSourceAsString());
            //将获取的值转换成map的形式
            Map<String, Object> map = hit.getSourceAsMap();
            for(String key:map.keySet()) {
                System.out.println(key +" key对应的值为：" +map.get(key));
            }
        }
    }
}
