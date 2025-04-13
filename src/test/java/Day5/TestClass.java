package Day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

//import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestClass {
	@Test
	void JsonResponseWithDataMathod()
	{
	//Aproach1
		/*given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/Book")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			//.body("size()", greaterThanOrEqualTo(6)) 			
			.body("[0].Name", equalTo("My name is Suman"))
			.log().all();*/
		Response res= given()
			.contentType("application/json")
		.when()
			.get("http://localhost:3000/Book");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		String bookname= res.jsonPath().get("[0].Name").toString();
		Assert.assertEquals(bookname, "My name is Suman");
		//.then()
			//.statusCode(200)
			//.header("Content-Type", "application/json")
			//.body("size()", greaterThanOrEqualTo(6)) 			
			//.body("[0].Name", equalTo("My name is Suman"))
		//.log().all();
	}

}
