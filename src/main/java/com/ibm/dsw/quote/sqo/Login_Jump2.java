//package com.ibm.dsw.quote.sqo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import com.ibm.dsw.quote.Application;
//import com.ibm.dsw.quote.sqo.service.SQOLoginService;
//
//import cucumber.api.java.en.Given;
//
//@ContextConfiguration(classes = Application.class)
//@SpringBootTest
//public class Login_Jump {
//
//	private final Logger logger = LoggerFactory.getLogger(Login_Jump.class);
//	
//	@Autowired
//	private SQOLoginService sqoLoginService;
//	
//	//---------submit----------
//	
//	@Given("^\"([^\"]*)\" jump to Login SQO$")
//    public void SQOJumpLogin(String arg1)  {
//	    // Write code here that turns the phrase above into concrete actions	
//		sqoLoginService.SQOJumpLogin(arg1);
//	}
//	
//}
