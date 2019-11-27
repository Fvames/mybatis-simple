package dev.fvames;

import dev.fvames.dao.UserInfoMapper;
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

public class UserInfoMapperTest {

	public UserInfoMapper userInfoMapper;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)){
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			this.userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
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

		userInfoMapper.insert(userInfo);

		System.out.println(userInfo);
	}

	@Test
	public void selectById() {
		UserInfo userInfo = userInfoMapper.selectById(1L);
		System.out.println(userInfo);
	}

	@Test
	public void selectAll() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(1L);

		List<UserInfo> userInfos = userInfoMapper.selectAll(userInfo);
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

		userInfoMapper.update(userInfo);

		System.out.println(userInfo);
	}

	@Test
	public void delete() {

		userInfoMapper.deleteById(40L);
	}

	@Test
	public void selectByUserNameAndPassword() {
		UserInfo userInfo = userInfoMapper.selectByUserNameAndPassword("test2", "aaaa");
		System.out.println(userInfo);
	}
}
