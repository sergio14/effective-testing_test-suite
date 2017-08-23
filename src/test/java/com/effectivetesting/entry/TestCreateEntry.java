package com.effectivetesting.entry;

import static com.github.restdriver.serverdriver.RestServerDriver.get;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.effectivetesting.entities.Entry;
import com.effectivetesting.entities.User;
import com.effectivetesting.pageobject.LoginPageObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.restdriver.serverdriver.http.response.Response;

public class TestCreateEntry {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	private static final String ID = "23";
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Test
	public void postIsSuccessfull() throws JsonParseException, JsonMappingException, IOException {
        Response response = get(DEFAULT_BASE_URL + "/entry");

        ObjectMapper mapper = new ObjectMapper();
        Entry entry= mapper.readValue(response.asText(), Entry.class);
        System.out.println(entry.getObjects().get(0).getId());
        
        
//		loginPage = new LoginPageObject(driver);
//		String currentMessage = loginPage
//				.login("userx@gmail.com", "userx")
//				.goToCreateEntry()
//				.createEntry("My newest post", "This is a post.")
//				.getResultMessage();
//		
//		assertTrue(currentMessage.contains("Entry 'My newest post' created successfully."));
	}
	
	@Before
	public void setUp() throws JsonProcessingException {
//		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.get("localhost:5000");
//		
//		User user = createTestObject();
//		ObjectMapper mapper = new ObjectMapper();
//
//		String jsonInString = mapper.writeValueAsString(user);
//		
//		post(DEFAULT_BASE_URL + "/user", body(jsonInString, "application/json"));
	}

	@After
	public void teardDown() {
		/*driver.get("http://localhost:5000/admin/entry/");
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/form")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   
	    alert.accept();
	    
	    WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
	    waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));*/
//        delete(DEFAULT_BASE_URL + "/user/" + ID);
//        
//
//        
//        driver.quit();
	}
	
	private User createTestObject() {

		User user = new User();

		user.setId(ID);
		user.setEmail("userx@gmail.com");
		user.setpassword_hash("userx");
		user.setName("John Doe");
		
		return user;

	}
}
