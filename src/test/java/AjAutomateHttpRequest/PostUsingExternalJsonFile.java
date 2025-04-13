package AjAutomateHttpRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.*;

import org.json.*;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;

import org.json.JSONObject;
public class PostUsingExternalJsonFile {
	
	String id;
	@Test(priority=1)
	void postUsingExternalJsonFile() throws FileNotFoundException 
	{
		File f= new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject  data = new JSONObject (jt);

		id=given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/Students")
		.then()
			.statusCode(201)
			.body("name", equalTo("AmanAttri"))
			.body("location", equalTo("Canada"))
			.body("phone", equalTo("16442111"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("C++"))
			.header("Content-Type", equalTo("application/json"))
			.log().all()
			.extract()
			.jsonPath().getString("id");		
		
		
	}
	@Test(priority=2, dependsOnMethods = {"postUsingExternalJsonFile"})
	void deleteMethode()
	{
		given()
		.when()
			.delete("http://localhost:3000/Students/"+id)
		.then()
			.log().all();
	}

}
