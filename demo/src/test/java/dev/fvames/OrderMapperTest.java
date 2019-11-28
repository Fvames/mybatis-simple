package dev.fvames;

import dev.fvames.dao.OrderMapper;
import dev.fvames.domain.Order;
import dev.fvames.domain.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 17:35
 */

public class OrderMapperTest {

	private OrderMapper orderMapper;
	private SqlSession sqlSession;

	@Before
	public void before() {
		String resourcePath = "mybatis-config.xml";

		try (InputStream in = Resources.getResourceAsStream(resourcePath)){

			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
			sqlSession = build.openSession();
			orderMapper = sqlSession.getMapper(OrderMapper.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectOrderWithUserByOrderNumber() {
		Order order = orderMapper.selectOrderWithUserByOrderNumber("1");
		System.out.println(order);
		UserInfo userInfo = order.getUserInfo();
		System.out.println(userInfo);
	}

}
