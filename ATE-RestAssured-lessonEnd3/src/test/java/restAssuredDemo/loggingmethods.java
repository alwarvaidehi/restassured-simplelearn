package restAssuredDemo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
public class loggingmethods {
	Logger logger = LogManager.getLogger(loggingmethods.class);
	@Test(priority='1')
	public void loggingRestAssured(){
		
	String PMapikey = "PMAK-65447d91dca907002a13251f-35c456c5af4a6f33c69e15c9dc59c58769";
	given().baseUri("https://api.postman.com")
	.basePath("/workspaces")
	.header("X-API-Key", PMapikey)
	.when().get()
	//.then().statusCode(200).log().headers()
	//.then().log().ifError()
	//.then().statusCode(200).log().cookies();
	.then().statusCode(200).log().all();
	logger.trace("The status code is checked");
	

}
}