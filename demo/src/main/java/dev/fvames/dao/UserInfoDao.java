package dev.fvames.dao;

import dev.fvames.domain.UserInfo;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/26 16:43
 */

public interface UserInfoDao {

	public UserInfo selectById(Long id);

	public List<UserInfo> selectAll();

	public void insert(UserInfo userInfo);

	public void update(UserInfo userInfo);

	public void deleteById(Long id);
}
