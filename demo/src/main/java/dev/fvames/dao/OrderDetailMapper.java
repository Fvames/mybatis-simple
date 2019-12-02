package dev.fvames.dao;

import dev.fvames.domain.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 17:14
 */

public interface OrderDetailMapper {

	OrderDetail selectByOrderId(@Param("orderId") Long orderId);

	@Select("select * from order_detail where id=#{id}")
	OrderDetail selectById(@Param("id") Long id);

	int insert(OrderDetail orderDetail);
}
