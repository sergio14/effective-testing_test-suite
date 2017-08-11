package com.effectivetesting.entry;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDraftState {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("localhost:5000");
	}
	
	@Test
	public void DraftStateShouldNotBeVisibleForVisitors() {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("admin1");
		driver.findElement(By.id("btn-submit")).click();

		driver.findElement(By.id("create_post")).click();
		driver.findElement(By.id("title")).sendKeys("My newest post");
		driver.findElement(By.id("body")).sendKeys("This is a post.");
		
		Select dropdown = new Select(driver.findElement(By.id("status")));
		dropdown.selectByVisibleText("Draft");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form/div[5]/div/button")).click();
		
		WebDriverWait waitForMessage = new WebDriverWait(driver, 20);
		waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[1]/div/span")));
		
		driver.findElement(By.id("logout")).click();
		
		WebDriverWait waitForLogout = new WebDriverWait(driver, 20);
		waitForLogout.until(ExpectedConditions.presenceOfElementLocated(By.id("notification")));
		
		driver.get("localhost:5000/entries");
		
		WebElement entryList = driver.findElement(By.id("content_title"));
		System.out.println(entryList.getText());
		
		assertFalse(entryList.getText().contains("My newest post"));
	}
	
	@After
	public void teardDown() {
		driver.get("http://localhost:5000");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("admin1");
		driver.findElement(By.id("btn-submit")).click();
		
		driver.get("http://localhost:5000/admin/entry/");
		
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/form")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   
	    alert.accept();
	    
	    WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
	    waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));
	    
	    driver.quit();
	}

}
