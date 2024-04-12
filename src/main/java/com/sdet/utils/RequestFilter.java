package com.sdet.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

/**
 * Step definitions for multi-currency conversion feature.
 * Author: Lovekesh Patel
 * Date: 04/11/2024
 */

public class RequestFilter implements Filter {
	
	private static final Logger LOG = LogManager.getLogger(RequestFilter.class);

	@Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx)  {
		 Response response = ctx.next(requestSpec, responseSpec);

		return response;
	}

}
