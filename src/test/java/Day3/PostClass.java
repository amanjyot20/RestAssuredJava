package Day3;
	import static io.restassured.RestAssured.*;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;
	import org.testng.annotations.Test;

	import static org.hamcrest.Matchers.equalTo;

	import java.util.*;

	public class PostClass {
			//Post request using Hashmap
		String id;
		@Test
		
		void postHashMapMethod()
		{
		
			HashMap data = new HashMap();
			data.put("age", 43);
						
			given()
			        .contentType("application/json")
			        .body(data)
			    .when()
			        .put("http://localhost:3000/Test/1")        
			    .then()
			        .statusCode(200)
			        .log().all();
			        
		}	
		/*@Test(priority = 3, dependsOnMethods = {"postHashMapMethod"})
		void deleteRecord()
		{
			given()
			.when()
				.delete("http://localhost:3000/Test/"+id)
			.then()
				.statusCode(200);
			//.log().all();
		}*/
				
	}



