package restAssuredDemo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Script004PayLoadJSON {

	@Test
	public void postusingjson()
	{
		JSONObject body=new JSONObject();
		body.put("name", "vaishu");
		body.put("salary", "11000");
		body.put("age", "23");
		
		int actualid =RestAssured
				.given()
				.baseUri("https://dummy.restapiexample.com/api/v1")
				.contentType(ContentType.JSON)
				.body(body.toString())
				.when().post("/create")
				.then()
                .statusCode(200)
                .log().all()
                .body("data.name", equalTo("vaishu"))
                .extract().path("data.id");
             
		System.out.println(actualid);
}
}
