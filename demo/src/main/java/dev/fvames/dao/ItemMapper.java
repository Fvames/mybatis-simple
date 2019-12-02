package dev.fvames.dao;

import dev.fvames.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/11/27 17:14
 */

public interface ItemMapper {

	Order selectById(@Param("id") String id);
}
