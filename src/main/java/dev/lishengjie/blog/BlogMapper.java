package dev.lishengjie.blog;

import dev.lishengjie.beans.Blog;
import dev.lishengjie.beans.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    int countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    Blog selectByPrimaryKey(@Param("id") int id);

    Blog selectBlogAuthor(@Param("id") int i);

    Blog selectBlogAuthor嵌套结果(int i);

    List<Blog> selectBlogPosts嵌套结果(@Param("id") int i);
}