package com.sdet.stepdefinition;

import com.sdet.utils.TestContext;

import static org.junit.Assert.*;

import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;

/**
 * Step definitions for multi-currency conversion feature.
 * Author: Lovekesh Patel
 * Date: 04/11/2024
 */

public class MultiCurrencyConversionStepDefinition {

	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(MultiCurrencyConversionStepDefinition.class);

	public MultiCurrencyConversionStepDefinition(TestContext context) {
		this.context = context;
	}

	@Given("user has access to endpoint {string}")
	public void user_has_access_to_endpoint(String endpoint) {
		context.session.put("endpoint", endpoint);
	}

	@When("user makes a request to view price")
	public void user_makes_a_request_to_view_price() {
		context.response = context.requestSetup().when().get(context.session.get("endpoint").toString());
		assertNotNull("Response not found!", context.response);
	}

	@Then("user should get the response code {int}")
	public void user_should_get_the_response_code(Integer responseCode) {
		assertEquals(Long.valueOf(responseCode), Long.valueOf(context.response.getStatusCode()));
	}

	@Then("user validates the response should have valid price")
	public void user_validates_the_response_should_have_valid_price() {
		Map<String, String> rates = context.response.getBody().jsonPath().getMap("rates");
		assertFalse("Valid price not returned", rates.containsValue(null) || rates.containsKey(null));

	}

	@Then("user validates API response returned {int} currency pairs")
	public void user_validates_api_response_returned_currency_pairs(Integer count) {
		Map<String, String> getCurrencyMap = context.response.getBody().jsonPath().getMap("rates");
		int currencyPairCount = getCurrencyMap.size();
		assertEquals(Long.valueOf(count), Long.valueOf(currencyPairCount));

	}

	@Then("user validates API response time is not less than {int} seconds")
	public void user_validates_api_response_time_is_not_less_then_seconds_then_current_time_in_second(int apiResTime) {
		String dateLastUpdated = context.response.getBody().jsonPath().getString("time_last_update_utc");
		String dateNextUpdated = context.response.getBody().jsonPath().getString("time_next_update_utc");
		LOG.info("time_last_update_utc : " + dateLastUpdated);
		LOG.info("time_next_update_utc : " + dateNextUpdated);
		context.response.then().assertThat().time(Matchers.greaterThan(3000L));
	}

	@Then("user validates the result is {string}")
	public void user_validates_the_result_is(String result) {
		String getResult = context.response.getBody().jsonPath().getString("result");
		assertEquals(result, getResult);
	}

	@Then("user validates the {string} price are in range on {double} – {double}")
	public void user_validates_the_price_are_in_range_on(String currency, Double r1, Double r2) {
		double getPrice = context.response.getBody().jsonPath().getDouble("rates." + currency);
		assertTrue(currency + " price is out of range ", r1 <= getPrice && getPrice <= r2);
	}

	@Then("user validates the response with JSON schema {string}")
	public void user_validates_the_response_with_json_schema(String schemaFileName) {
		context.response.then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaFileName));
		LOG.info("Successfully Validated schema from " + schemaFileName);
	}

}
