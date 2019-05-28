package com.ibm.dsw.quote.sqo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.ibm.dsw.quote.Application;

import cucumber.api.java.en.Given;

@ContextConfiguration(classes = Application.class)
@SpringBootTest

public class Stepdefs {
	
	@Given("{string} open baidu")
	public void open_baidu(String string) {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println(string);
		System.out.format("Thread ID - %2d - %s from feature file.\n", Thread.currentThread().getId(),string);
	    
	}
}

