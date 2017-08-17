package com.effectivetesting.user;

import static com.github.restdriver.serverdriver.Matchers.hasStatusCode;
import static com.github.restdriver.serverdriver.RestServerDriver.body;
import static com.github.restdriver.serverdriver.RestServerDriver.delete;
import static com.github.restdriver.serverdriver.RestServerDriver.post;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Test;

import com.effectivetesting.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.restdriver.serverdriver.http.response.Response;

public class TestCreateUser {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	private static final String ID = "23";
	
	@Test
	public void postUser() throws JsonProcessingException {
		User user = createTestObject();
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonInString = mapper.writeValueAsString(user);
		System.out.println(jsonInString);
		
		Response response = post(DEFAULT_BASE_URL + "/user", body(jsonInString, "application/json"));
        assertThat(response, hasStatusCode( 201 ));
	}

    @After
    public void tearDown() {
        Response response = delete(DEFAULT_BASE_URL + "/user/" + ID);
        assertThat(response, hasStatusCode( 204 ));
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
