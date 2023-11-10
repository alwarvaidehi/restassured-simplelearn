package restAssuredDemo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Script003PostMethod {
	@Test

	public void postmethod()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name", "harry");
		map.put("job","singer");
		
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api/users")
		.basePath("/api/users")
		.contentType("application/json")
		.body(map)
		.when().post()
		.then().statusCode(201)
		.log().all();
		
	}

}
