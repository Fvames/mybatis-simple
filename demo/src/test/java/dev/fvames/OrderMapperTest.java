package dev.fvames;

import dev.fvames.dao.OrderMapper;
import dev.fvames.domain.Order;
import dev.fvames.domain.OrderDetail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
	public void selectOrderWithUserAndDetailItemByOrderNumberOfNested() {
		Order order = orderMapper.selectOrderWithUserAndDetailItemByOrderNumberOfNested("1");
		System.out.println(order.getOrderNumber());
		System.out.println("----------------");

		//System.out.println(order.getUserInfo().getUserName());
		//UserInfo userInfo = order.getUserInfo();
		//System.out.println(userInfo);

		//System.out.println("----------------");
		List<OrderDetail> detailList = order.getDetailList();
		System.out.println(detailList.get(0).getItem());
		detailList.forEach(System.out::println);
	}

	@Test
	public void selectOrderWithUserAndDetailItemByOrderNumberOfAssociation() {
		Order order = orderMapper.selectOrderWithUserAndDetailItemByOrderNumberOfAssociation("1");
		System.out.println(order);
		List<OrderDetail> detailList = order.getDetailList();
		System.out.println(detailList.get(0).getItem());
		detailList.forEach(System.out::println);
	}

}
