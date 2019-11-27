package dev.fvames.dao;

import dev.fvames.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 10:29
 */

public interface UserInfoMapper {

	public UserInfo selectById(Long id);

	public List<UserInfo> selectAll(UserInfo userInfo);

	public void insert(UserInfo userInfo);

	public void update(UserInfo userInfo);

	public void deleteById(Long id);

	public UserInfo selectByUserNameAndPassword(@Param(value = "userName") String userName, @Param(value = "password") String password);
}
