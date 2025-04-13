package AjAutomateHttpRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import net.minidev.json.JSONObject;

public class postUsingGetterSetter
{
	String id;
	@Test(priority=2)
	void postPOJOMethod()
	{
		PostPOJO data = new PostPOJO();
		data.setName("Aman");
		data.setLocation("Chandigarh");
		data.setPhone("76635623");
		String[] coursArr = {"C", "C++"};
		
		data.setCourses(coursArr);
		
		id= given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/Students")
		.then()
			.statusCode(201)
			.body("name", equalTo("Aman"))
			.body("location", equalTo("Chandigarh"))
			.body("phone", equalTo("76635623"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", equalTo("application/json"))
			.log().all()
			.extract()
			.jsonPath().getString("id");
	}
	@Test(priority=2, dependsOnMethods = {"postPOJOMethod"})
	void deleteMethode()
	{
		given()
		.when()
			.delete("http://localhost:3000/Students/"+id)
		.then()
			.log().all();
	}
	
}
