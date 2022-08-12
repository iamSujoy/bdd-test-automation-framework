package com.swaglabs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/resources/features"},
        glue = {"com.swaglabs.stepdefs"},
        publish = true,
        monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
