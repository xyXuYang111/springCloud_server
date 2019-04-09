package com.xuyang.springcloud.server_elasticsearch.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Auther: xuy
 * @Date: 2019/4/9 00:32
 * @Description: indexName:数据库， type：表
 */
@Data
@Slf4j
@ToString
@Document(indexName = "mkyong", type = "books")
public class User implements Serializable {

    private static final long serialVersionUID = 8113996602181773031L;

    @Id
    private String id;
    private String title;
    private String author;
    private String releaseDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
