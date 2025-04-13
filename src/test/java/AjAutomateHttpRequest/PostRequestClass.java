package AjAutomateHttpRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

import java.util.*;

public class PostRequestClass {
		//Post request using Hashmap
	String id;
	@Test
	
	void postHashMapMethod()
	{
	
		HashMap data = new HashMap();
		data.put("name", "Suman Jyoti Attri");
		data.put("location", "Austria");
		data.put("phone", "16442144");
		String[] courseArr = {"Java", "Rest-API"};
		data.put("courses", courseArr);
		
		id = given()
		        .contentType("application/json")
		        .body(data)
		    .when()
		        .post("http://localhost:3000/Students")        
		    .then()
		        .statusCode(201)
		        .body("name", equalTo("Suman Jyoti Attri"))
		        .body("location", equalTo("Austria"))
		        .body("phone", equalTo("16442144"))
		        .body("courses[0]", equalTo("Java"))
		        .body("courses[1]", equalTo("Rest-API"))
		        .header("Content-Type", equalTo("application/json"))
		        .log().body()
		        .extract()  
		        .jsonPath()
		        .getString("id");
	}	
	@Test(priority = 3, dependsOnMethods = {"postHashMapMethod"})
	void deleteRecord()
	{
		given()
		.when()
			.delete("http://localhost:3000/Students/"+id)
		.then()
			.statusCode(200);
		
	}
			
}
