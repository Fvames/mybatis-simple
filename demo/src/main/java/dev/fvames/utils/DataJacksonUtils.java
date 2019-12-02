package dev.fvames.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * TODO 类描述
 *
 * @author
 * @version 2019/12/2 14:24
 */

public class DataJacksonUtils {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

	public static <T>T deSerialization(String json, Class<T> clz) throws IOException {
		return OBJECT_MAPPER.readValue(json, clz);
	}

	public static String serialization(Object value) throws JsonProcessingException {
		return OBJECT_MAPPER.writeValueAsString(value);
	}

}
