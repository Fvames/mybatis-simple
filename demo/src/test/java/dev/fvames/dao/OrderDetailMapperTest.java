package dev.fvames.dao;

import dev.fvames.domain.Item;
import dev.fvames.domain.OrderDetail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/2 14:44
 */

public class OrderDetailMapperTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailMapperTest.class);

	private OrderDetailMapper orderDetailMapper;
	private ItemMapper itemMapper;
	private SqlSession sqlSession;

	@Before
	public void before() {
		String resourcePath = "mybatis-config.xml";

		try (InputStream in = Resources.getResourceAsStream(resourcePath)) {

			SqlSessionFactory build = new SqlSessionFactoryBuilder().build(in);
			sqlSession = build.openSession();
			orderDetailMapper = sqlSession.getMapper(OrderDetailMapper.class);
			itemMapper = sqlSession.getMapper(ItemMapper.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectByOrderId() {

		OrderDetail orderDetail = orderDetailMapper.selectById(1L);
		LOGGER.debug(orderDetail.toString());
	}

	@Test
	public void insert() {
		Item item = new Item();
		item.setItemName("Macbook");
		item.setItemPrice((float) 15000.00);
		item.setItemDetail("Apple");
		Integer itemId = itemMapper.insert(item);

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setId(1);
		orderDetail.setItemId(itemId);
		orderDetail.setItem(item);
		orderDetail.setOrderId(2);
		orderDetail.setStatus(1);
		orderDetail.setTotalPrice(15000.00);
		orderDetailMapper.insert(orderDetail);

		sqlSession.commit();
	}
}