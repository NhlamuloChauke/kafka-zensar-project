package com.zensar.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author NChauke
 * @since 18/07/2021
 *
 */
public class JsonToObject {
	private static final Logger LOG = LoggerFactory.getLogger(JsonToObject.class);

	public static <T> T processing(Class<T> type, String message) {

		// ObjectMapper instantiation
		ObjectMapper mapper = new ObjectMapper();

		message = message.replace("\\n", "");
		message = message.replaceAll("^\"|\"$|\\\\", "");

		T entity = null;
		try {
			// Deserialization into the `T type` class
			entity = mapper.readValue(message, type);
		} catch (JsonProcessingException e) {
			LOG.error("Error Message Json Mapping:{}", e.getMessage());
		}
		return entity;
	}
}
