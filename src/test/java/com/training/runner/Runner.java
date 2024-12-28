package com.training.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"D:\\Workspace\\JnaneshTraining_Oct2024\\SalesforceCucumberFramework_oct_2024\\features\\LoginTest.feature" }, glue = "com.training.steps", plugin = {
				"pretty", "html:target/cucumber-reports/cucumber.html",
				"json:target/cucumber-reports/json.html" } , tags = "@TC-1"
)

public class Runner {

}
