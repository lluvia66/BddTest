package com.ibm.dsw.quote.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.dsw.quote.utils.CucumberReport;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

@Configuration
public class TestConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(TestConfiguration.class);

	public static WebDriver webDriver;

	@Value("${webdriver.browser.name}")
	private String browserName;

	@Bean
	public WebDriver webDriver() throws Exception {

		switch (browserName) {
		case BrowserType.FIREFOX:
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//Windows use this
			//System.setProperty("webdriver.firefox.marionette","C:\\Users\\powerHA\\Desktop\\DSW\\geckodriver-v0.9.0-win64\\geckodriver.exe");
			
			//Mac use this
			//System.setProperty("webdriver.gecko.driver","/Users/yuhe/Downloads/geckodriver");
			
			System.setProperty("webdriver.firefox.bin", "/Applications/IBM Firefox.app");
			
			
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.addArguments("disable-web-security");

			FirefoxDriverManager.getInstance().useTaobaoMirror().setup();
			
			webDriver = new FirefoxDriver(firefoxOptions);
			break;
		case BrowserType.CHROME:
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("disable-web-security");

			ChromeDriverManager.getInstance().useTaobaoMirror().setup();
			webDriver = new ChromeDriver(chromeOptions);
			break;
		case BrowserType.IE:
			InternetExplorerDriverManager.getInstance().useTaobaoMirror().setup();
			webDriver = new InternetExplorerDriver();
			break;
		default:
			ChromeDriverManager.getInstance().useTaobaoMirror().setup();
			webDriver = new ChromeDriver();
			break;
		}
		return webDriver;
	}

	@Bean
	CucumberReportBean cucumberReport() {
		return new CucumberReportBean();
	}

	private static class CucumberReportBean {

		@PostConstruct
		public void init() {
			logger.debug("init ..................");
		}

		public void doSomething() {
			logger.debug("Cucumber reporting ..................");
		}

		@PreDestroy
		public void destroy() {
			try {
				new CucumberReport().report();
			} catch (Exception e) {
				// logger.debug("destroy .................." + e);
			}
		}
	}

}
