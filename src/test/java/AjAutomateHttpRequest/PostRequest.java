package AjAutomateHttpRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostRequest {
	
	@Test
	 void getMthod()
	{
		given()
		
		.when()
			.get ("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
		
	}

}
