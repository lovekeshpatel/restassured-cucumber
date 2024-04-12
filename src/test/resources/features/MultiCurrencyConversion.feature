Feature: To verify API which returns the USD rates against multiple currency. 

	Scenario: To verify API call is successful and returns valid price
		Given user has access to endpoint "/USD"
		When user makes a request to view price
		Then user should get the response code 200
		And user validates the response should have valid price

	Scenario: To Check the status code and status returned by the API response
		Given user has access to endpoint "/USD"
		When user makes a request to view price
		Then user should get the response code 200
		And user validates the result is "success"

	Scenario: To verify the USD price against the AED
		Given user has access to endpoint "/USD"
		When user makes a request to view price
		Then user should get the response code 200
		And user validates the "AED" price are in range on 3.6 – 3.7

	Scenario: To verify API response time is not less than 3 seconds
		Given user has access to endpoint "/USD"
		When user makes a request to view price
		Then user should get the response code 200
		And user validates API response time is not less than 3 seconds

	Scenario: To verify that 162 currency pairs are returned by the API
		Given user has access to endpoint "/USD"
		When user makes a request to view price
		Then user should get the response code 200
		And user validates API response returned 162 currency pairs
	
	Scenario: To verify API response matches the Json schema
		Given user has access to endpoint "/USD"
		When user makes a request to view price
		Then user should get the response code 200
		And user validates the response with JSON schema "multiCurrencySchema.json"