package dev.fvames.dao;

import dev.fvames.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 17:14
 */

public interface OrderMapper {

	Order selectOrderWithUserAndDetailItemByOrderNumberOfNested(@Param("orderNumber") String orderNumber);

	Order selectOrderWithUserAndDetailItemByOrderNumberOfAssociation(@Param("orderNumber") String orderNumber);

}
