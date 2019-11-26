package dev.fvames;

import dev.fvames.domain.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/26 11:20
 */

public class UserInfoMapperTest {

	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try (InputStream inputStream = Resources.getResourceAsStream(resource)){
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();

			UserInfo user = sqlSession.selectOne("UserInfoMapper.selectUser", 1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (null != sqlSession) {
				sqlSession.close();
			}
		}
	}
}
