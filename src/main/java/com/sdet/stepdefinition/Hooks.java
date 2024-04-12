package com.sdet.stepdefinition;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * Step definitions for multi-currency conversion feature.
 * Author: Lovekesh Patel
 * Date: 04/11/2024
 */

public class Hooks {

	private static final Logger LOG = LogManager.getLogger(Hooks.class);

	@Before
	public void testStart(Scenario scenario) {
		LOG.info("*****************************************************************************************");
		LOG.info("	Scenario: " + scenario.getName());
		LOG.info("*****************************************************************************************");
	}

}
