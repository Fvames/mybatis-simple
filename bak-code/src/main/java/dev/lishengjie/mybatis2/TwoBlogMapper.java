package dev.lishengjie.mybatis2;

import dev.lishengjie.beans.Blog;

public interface TwoBlogMapper {

    public Blog selectByPrimaryKey(int id);
}
