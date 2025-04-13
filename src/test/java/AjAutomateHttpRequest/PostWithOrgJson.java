package AjAutomateHttpRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import net.minidev.json.JSONObject;

public class PostWithOrgJson {
	String id;
	@Test(priority = 2)
	
	void postUsingJsonLibraryMethod()
	{
		JSONObject data = new JSONObject();
		data.put("name", "Aman");
		data.put("location", "Mohali");
		data.put("phone", "542234");
		String[] courArr = {"C", "C++"};
		data.put("courses", courArr);
		
		id=given()
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("http://localhost:3000/Students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Aman"))
			.body("location", equalTo("Mohali"))
			.body("phone", equalTo("542234"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", equalTo("application/json"))
			.log().all()
			.extract()
			.jsonPath().getString("id");
	}
	@Test(priority = 2, dependsOnMethods = {"postUsingJsonLibraryMethod"})
	
	void deleteMethod()
	{
	
		given()
		.when()
			.delete("http://localhost:3000/Students/"+ id)
		.then()
			.statusCode(200);
		
	
	}

}
