package com.cg.newbddapp.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty"},
features = "src/test/resources/Booking",
glue= "com/cg/newbddapp/stepdefs")
public class TestBookingRunner {

}
