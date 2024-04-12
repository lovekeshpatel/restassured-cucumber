package com.sdet;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Step definitions for multi-currency conversion feature.
 * Author: Lovekesh Patel
 * Date: 04/11/2024
 */

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features",
plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class RunTest{

}
