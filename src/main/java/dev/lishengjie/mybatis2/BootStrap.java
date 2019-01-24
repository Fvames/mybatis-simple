package dev.lishengjie.mybatis2;

import dev.lishengjie.beans.Blog;

public class BootStrap {

    public static void main(String[] args) {
        TwoConfiguration configuration = new TwoConfiguration().setScanPath("");
        configuration.build();

        TwoExecutor executor = new TwoSimpleExecutor(configuration);
        TwoSqlSession sqlSession = new TwoSqlSession(configuration, executor);

        // getMapper BlogMapper.class
        TwoBlogMapper mapper = sqlSession.getMapper(TwoBlogMapper.class);
        // mapper.selectOne()
        Blog blog = mapper.selectByPrimaryKey(1);

        System.out.println("blog: " + blog);
    }
}
