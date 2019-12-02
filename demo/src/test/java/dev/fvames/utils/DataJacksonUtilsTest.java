package dev.fvames.utils;

import dev.fvames.domain.UserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/2 14:30
 */

public class DataJacksonUtilsTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataJacksonUtilsTest.class);

	@Test
	public void serialization() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(1L);
		userInfo.setSex(1);
		userInfo.setUserName("吉姆");
		userInfo.setRealName("埃克波");
		userInfo.setAge(35);

		String serialization = DataJacksonUtils.serialization(userInfo);
		LOGGER.debug(serialization);

		UserInfo userInfo1 = DataJacksonUtils.deSerialization(serialization, UserInfo.class);
		LOGGER.debug(userInfo1.toString());
	}
}
