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
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/26 11:20
 */

public class UserInfoMapperTest {

	public UserInfoMapper userInfoMapper;
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)){
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		UserInfo userInfo = userInfoMapper.selectById(1L);
		System.out.println(userInfo);
		//sqlSession.commit();
		sqlSession.close();

		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper1 = sqlSession1.getMapper(UserInfoMapper.class);
		UserInfo userInfo1 = userInfoMapper1.selectById(1L);
		System.out.println(userInfo1);
	}

	@Test
	public void selectAll() {
		UserInfo userInfo = new UserInfo();
		//userInfo.setId(1L);

		List<UserInfo> userInfos = userInfoMapper.selectAll(userInfo);
		userInfos.forEach(System.out::println);
	}

	@Test
	public void update() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

		UserInfo userInfo = new UserInfo();
		userInfo.setId(1L);
		userInfo.setUserName("斯通纳7");
		userInfo.setAge(47);
		userInfo.setBirthday(LocalDate.of(1979, 3, 15));
		userInfo.setEmail("sitongna@gmail.com");
		userInfo.setSex(1);

		userInfoMapper.update(userInfo);
		sqlSession.commit();

		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		UserInfoMapper userInfoMapper1 = sqlSession.getMapper(UserInfoMapper.class);
		userInfoMapper1.selectById(1L);
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

	/**
	 * 一级缓存
	 * 同一 session， 同一查询语句，同样参数
	 */
	@Test
	public void oneCache() {
		// 仅执行一条sql语句
		userInfoMapper.selectById(1L);
		//sqlSession.clearCache();
		userInfoMapper.selectById(1L);
	}

	/**
	 * insert/update/delete 会清除一级缓存
	 */
	@Test
	public void clearOneCacheOption() {
		userInfoMapper.selectById(1L);
		//insert();
		//update();
		delete();
		// 缓存被清空,重新执行 sql 语句
		userInfoMapper.selectById(1L);
	}

	/**
	 * 二级缓存实体类需要序列化
	 */
	@Test
	public void twoCache() {
		userInfoMapper.selectById(1L);
		// 关闭或者commit后才会写入缓存
		sqlSession.close();
		//sqlSession.commit();
		// 执行报错
		//userInfoMapper.selectById(1L);

		sqlSession = sqlSessionFactory.openSession();
		userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);

		// Cache Hit Ratio 0.5(无全局设置时命中)
		userInfoMapper.selectById(1L);
	}

	@Test
	public void batchInsert() {
		List<UserInfo> userInfos = new ArrayList<>();
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("卡罗拉");
		userInfo.setAge(31);
		userInfo.setBirthday(LocalDate.of(1983, 2, 15));
		userInfo.setEmail("kaluola@gmail.com");
		userInfo.setSex(1);
		userInfos.add(userInfo);
		//userInfoMapper.insert(userInfo);

		userInfo = new UserInfo();
		userInfo.setUserName("霍兹");
		userInfo.setAge(51);
		userInfo.setBirthday(LocalDate.of(1963, 11, 25));
		userInfo.setEmail("huozi@gmail.com");
		userInfo.setSex(1);
		userInfos.add(userInfo);
		//userInfoMapper.insert(userInfo);

		userInfoMapper.batchInsert(userInfos);
	}

	@Test
	public void batchUpdate() {
		List<UserInfo> userInfos = new ArrayList<>();
		UserInfo userInfo = new UserInfo();
		userInfo.setId(1L);
		userInfo.setUserName("卡罗拉");
		userInfo.setAge(31);
		userInfo.setBirthday(LocalDate.of(1983, 2, 15));
		userInfo.setEmail("kaluola@gmail.com");
		userInfo.setSex(1);
		userInfos.add(userInfo);

		userInfo = new UserInfo();
		userInfo.setId(2L);
		userInfo.setUserName("霍兹");
		userInfo.setAge(51);
		userInfo.setBirthday(LocalDate.of(1963, 11, 25));
		userInfo.setEmail("huozi@gmail.com");
		userInfo.setSex(1);
		userInfos.add(userInfo);

		userInfoMapper.batchUpdate(userInfos);
	}

}
