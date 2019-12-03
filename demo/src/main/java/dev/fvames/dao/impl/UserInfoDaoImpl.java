package dev.fvames.dao.impl;

import dev.fvames.dao.UserInfoDao;
import dev.fvames.domain.UserInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/26 16:45
 */

public class UserInfoDaoImpl implements UserInfoDao {
	public SqlSession sqlSession;

	public UserInfoDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public UserInfo selectById(Long id) {
		return sqlSession.selectOne("UserInfoDaoMapper.selectById", id);
	}

	@Override
	public List<UserInfo> selectAll() {
		return sqlSession.selectList("UserInfoDaoMapper.selectAll");
	}

	@Override
	public void insert(UserInfo userInfo) {
		sqlSession.insert("UserInfoDaoMapper.insert", userInfo);
	}

	@Override
	public void update(UserInfo userInfo) {
		sqlSession.update("UserInfoDaoMapper.update", userInfo);
	}

	@Override
	public void deleteById(Long id) {
		sqlSession.delete("UserInfoDaoMapper.deleteById", id);
	}
}
