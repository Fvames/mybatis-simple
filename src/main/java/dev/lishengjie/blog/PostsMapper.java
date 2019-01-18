package dev.lishengjie.blog;

import dev.lishengjie.beans.Posts;
import dev.lishengjie.beans.PostsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostsMapper {
    int countByExample(PostsExample example);

    int deleteByExample(PostsExample example);

    int insert(Posts record);

    int insertSelective(Posts record);

    List<Posts> selectByExampleWithBLOBs(PostsExample example);

    List<Posts> selectByExample(PostsExample example);

    int updateByExampleSelective(@Param("record") Posts record, @Param("example") PostsExample example);

    int updateByExampleWithBLOBs(@Param("record") Posts record, @Param("example") PostsExample example);

    int updateByExample(@Param("record") Posts record, @Param("example") PostsExample example);

    Posts selectByBlogId(int blogId);
}