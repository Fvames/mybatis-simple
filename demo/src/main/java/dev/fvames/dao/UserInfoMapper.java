package dev.fvames.dao;

import dev.fvames.domain.UserInfo;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 10:29
 */

public interface UserInfoMapper {

	public UserInfo selectById(Long id);

	public List<UserInfo> selectAll();

	public void insert(UserInfo userInfo);

	public void update(UserInfo userInfo);

	public void deleteById(Long id);
}
