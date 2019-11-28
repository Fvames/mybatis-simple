package dev.fvames.dao;

import dev.fvames.domain.OrderDetail;
import org.apache.ibatis.annotations.Param;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 17:14
 */

public interface OrderDetailMapper {

	OrderDetail selectByOrderId(@Param("orderId") Long orderId);
}
