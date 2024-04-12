package com.sdet.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

/**
 * Step definitions for multi-currency conversion feature.
 * Author: Lovekesh Patel
 * Date: 04/11/2024
 */

public class ResponseHandler {

	private static final Logger logger = LogManager.getLogger(ResponseHandler.class);

	public static <T> T deserializeResponse(Response response, Class<T> T) throws CustomException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			T responseDeserialized = mapper.readValue(response.asString(), T);
			String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDeserialized); // Pretty print
			logger.info("Handling API Response: ---\n" + jsonStr);
			return  responseDeserialized;

		} catch (IOException e) {
			logger.error("Error deserializing response", e);
			throw new CustomException("Error deserializing response", e);
		}


	}
}