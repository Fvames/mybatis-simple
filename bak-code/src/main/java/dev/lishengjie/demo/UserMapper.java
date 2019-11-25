package dev.lishengjie.demo;

import org.apache.ibatis.annotations.Select;

/**
 * Created by James on 2019/1/10.
 */
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User selectUser(int id);

}
