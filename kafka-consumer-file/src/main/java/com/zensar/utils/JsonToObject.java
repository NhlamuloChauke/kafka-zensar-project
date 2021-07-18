package com.zensar.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author NChauke
 * @since  18/07/2021
 *
 */
public class JsonToObject {

	public static <T> T processing(Class<T> type, String message) throws JsonMappingException, JsonProcessingException {

		// ObjectMapper instantiation
		ObjectMapper mapper = new ObjectMapper();

		message = message.replace("\\n", "");
		message = message.replaceAll("^\"|\"$|\\\\", "");

		// Deserialization into the `T type` class
		T entity = mapper.readValue(message, type);

		return entity;
	}
}
