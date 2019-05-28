package com.ibm.dsw.quote;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ibm.dsw.quote.configuration.TestConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * tags = {"@SQO"}
 * 
 *
 */
@RunWith(Cucumber.class)



@CucumberOptions(strict = false,features = "src/main/resources", plugin = { "pretty", "html:target/html",
"json:target/cucumber.json" }, glue = {"com.ibm.dsw.quote.sqo"} )

public class CucumberTest {
	private static final Logger logger = LoggerFactory.getLogger(CucumberTest.class);

	@AfterClass
	public static void tearDown() {
		logger.debug("tearDown ...");
		//TestConfiguration.webDriver.quit();
	
	}

}
