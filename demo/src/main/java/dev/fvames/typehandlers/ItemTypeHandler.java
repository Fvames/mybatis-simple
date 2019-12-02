package dev.fvames.typehandlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.fvames.domain.Item;
import dev.fvames.utils.DataJacksonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/2 13:59
 */

public class ItemTypeHandler implements TypeHandler<Item> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemTypeHandler.class);

	@Override
	public void setParameter(PreparedStatement ps, int i, Item parameter, JdbcType jdbcType) throws SQLException {
		LOGGER.info(">>>>>>>>>> 序列化 Item 对象");
		try {

			String serialization = DataJacksonUtils.serialization(parameter);
			ps.setString(i, serialization);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item getResult(ResultSet rs, String columnName) throws SQLException {
		LOGGER.info(">>>>>>>>>> 反序列化 Item 对象");

		String string = rs.getString(columnName);
		if (StringUtils.isNotBlank(string)) {
			try {
				Item item = DataJacksonUtils.deSerialization(string, Item.class);
				return item;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Item getResult(ResultSet rs, int columnIndex) throws SQLException {
		return null;
	}

	@Override
	public Item getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
