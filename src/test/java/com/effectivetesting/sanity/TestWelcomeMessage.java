package com.effectivetesting.sanity;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWelcomeMessage {
	private WebDriver driver;
	 
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}
	
	@Test
	public void pageTitleShouldAppear() {
		String pageTitle = driver.getTitle();		  
		assertEquals("Effective Testing", pageTitle);	    
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}


