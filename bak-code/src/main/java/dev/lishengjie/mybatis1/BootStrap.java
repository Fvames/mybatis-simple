package dev.lishengjie.mybatis1;

import dev.lishengjie.beans.Blog;

public class BootStrap {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectById(1);
        System.out.println("blog: " + blog);

    }
}
