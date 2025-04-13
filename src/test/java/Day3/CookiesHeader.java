package Day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesHeader {
	@Test(priority=1)
	void testCookies()
	{
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC", "AVcja2e1WYZcOxoHBW3kuemE8GRDxy3ap0o6mFASyjwZjq4HcMvcaxkGKiU")
			.log().all();
	}
	@Test(priority=2)
	void testCookies2()
	{
		Response res=given()
		.when()
			.get("https://www.google.com/");
		//get single cookie info
		//String cookie_value = res.getCookie("AEC");
		//System.out.print("CCCCCCCCCCookie_value"+ cookie_value);
		Map<String, String> cookies_values= res.getCookies();
	//	System.out.print(cookies_values.keySet());
		for(String k:cookies_values.keySet())
		{
			String cookies_value= res.getCookie(k);
			System.out.print(k+"   "+cookies_values);
			
		}
		
		 
	}
}
 