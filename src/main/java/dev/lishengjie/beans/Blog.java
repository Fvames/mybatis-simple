package dev.lishengjie.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    private Integer id;

    private String title;

    private Date createTime;

    private Date updateTime;

    private Integer authorId;

    private String content;

    // mybatis2.0 转换查询数据时有entity参数匹配数据库列，需要处理多于数据库的情况，或者反向匹配
    //private Author author;

    //private List<Posts> posts;

}