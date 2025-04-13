package AjAutomateHttpRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;


import org.testng.annotations.Test;

public class HttpRequests 
{
	int id;
	@Test(priority = 1)
	void getUsers()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	@Test(priority = 2)
	void createUser()
	{
		HashMap createUser = new HashMap();
		createUser.put("name", "Pawan");
		createUser.put("job", "Engineer");
		id=given()
			.contentType("application/json")
			.body(createUser)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then()
		//	.statusCode(201)
			//.log().all();
	}
	
	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap createUser = new HashMap();
		createUser.put("name", "Aman");
		createUser.put("job", "Software Engineer");
		given()
			.contentType("application/json")
			.body(createUser)
		.when()
			.put("https://reqres.in/api/users/"+id)
			//.jsonPath().getInt("Id");
		.then()
			.statusCode(200)
			.log().all();
	}
}
