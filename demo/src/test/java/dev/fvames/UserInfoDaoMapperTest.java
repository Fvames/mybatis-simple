package dev.fvames;

import dev.fvames.dao.UserInfoDao;
import dev.fvames.dao.impl.UserInfoDaoImpl;
import dev.fvames.domain.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/26 11:20
 */

public class UserInfoDaoMapperTest {

	public UserInfoDao userInfoDao;
	private SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)){
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			this.userInfoDao = new UserInfoDaoImpl(sqlSession);
		}
	}

	@Test
	public void insert() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("斯通纳");
		userInfo.setAge(40);
		userInfo.setBirthday(LocalDate.of(1979, 3, 15));
		userInfo.setEmail("sitongna@gmail.com");
		userInfo.setSex(1);

		userInfoDao.insert(userInfo);

		System.out.println(userInfo);
	}

	@Test
	public void selectById() {
		UserInfo userInfo = userInfoDao.selectById(1L);
		System.out.println(userInfo);
	}

	@Test
	public void selectAll() {
		List<UserInfo> userInfos = userInfoDao.selectAll();
		userInfos.forEach(System.out::println);
	}

	@Test
	public void update() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(1L);
		userInfo.setUserName("斯通纳");
		userInfo.setAge(40);
		userInfo.setBirthday(LocalDate.of(1979, 3, 15));
		userInfo.setEmail("sitongna@gmail.com");
		userInfo.setSex(1);

		userInfoDao.update(userInfo);

		System.out.println(userInfo);
	}

	@Test
	public void delete() {

		userInfoDao.deleteById(40L);
	}


	/*public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try (InputStream inputStream = Resources.getResourceAsStream(resource)){
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();

			UserInfo user = sqlSession.selectOne("UserInfoMapper.selectById", 1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
	}*/
}
