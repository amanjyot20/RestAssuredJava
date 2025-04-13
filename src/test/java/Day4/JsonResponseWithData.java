package Day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class JsonResponseWithData {

	//multiple approaches 
	void JsonResponseWithDataMathod()
	{
		given()
			.contentType("ContentType.json")
		.when()
			.get("http://localhost:3000/Test")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("x.Students[5].Name", equalTo("Suman Jyoti"))
			.log().all();
	}
}
