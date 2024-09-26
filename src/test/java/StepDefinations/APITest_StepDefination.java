package StepDefinations;

import static io.restassured.RestAssured.given;

import PojoClasses.AddPlace_Main;
import PojoClasses.Location_Sub;
import Resources.EnumAPIClass;
import Resources.SendDataTest;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

import java.io.IOException;

public class APITest_StepDefination {
	RequestSpecification responce;
	Response response1;
	String response2;
	static String place_id;                    // this static string will applicable to 2 scenarios 
	
	SendDataTest sdt = new SendDataTest();
	Utils util = new Utils();

	@Given("Add the Addplace payload with {string} {string} {string}")
	public void add_the_addplace_payload(String name, String language, String address) throws IOException {
		
		
		responce = given().log().all().spec(util.RequestSpecification()).body(sdt.SendData(name, language, address));
		
	    
	}
	
	
	@When("user call {string} with {string} http Request")                                              // Enum Class                      
	public void user_call_add_place_api_with_post_http_request(String resource, String httpMethod) {
		
		EnumAPIClass eac = EnumAPIClass.valueOf(resource);      // this is "Object"
		System.out.println("-----------------------------------------------");
		System.out.println(eac.getResource());
		
		if(httpMethod.equalsIgnoreCase("POST"))
		{
			response1 = responce.when().post(eac.getResource())
					.then().log().all().extract().response();
		}
		else
		if(httpMethod.equalsIgnoreCase("Get"))
		{
			response1 = responce.when().get(eac.getResource())
					.then().log().all().extract().response();
		}
		else
		if(httpMethod.equalsIgnoreCase("Delete"))
		{
			response1 = responce.when().delete(eac.getResource())
					.then().log().all().extract().response();
		}
		
	   
	}
	
	
	@Then("The API call got success with Status Code {int}")
	public void the_api_call_got_success_with_status_code(Integer StatusCode) {
		
		assertEquals(response1.getStatusCode(), 200);
	    
	}
	
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyvalue, String ExpectedValue) {
		response2 = response1.asString();
		JsonPath jp = new JsonPath(response2);
		assertEquals(jp.get(keyvalue).toString(), ExpectedValue);
		
		place_id = jp.get("place_id");
	    
	}

	
	//  GetPlaceAPI
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String ExpectedName, String resource) throws IOException {
		
		responce = given().log().all().spec(util.RequestSpecification()).queryParam("place_id", place_id);      // here responce is converted into responce1 as per above code
		user_call_add_place_api_with_post_http_request(resource, "GET");
		
		String response3 = response1.asString();
		JsonPath jp = new JsonPath(response3);
		String actualName = jp.get("name");
		
		assertEquals(actualName, ExpectedName);
		System.out.println(actualName + " = " + ExpectedName );
	    
	}

	
	// DeletePlaceAPI
	
	@Given("delete the Delete Place Payload")
	public void delete_the_delete_place_payload() throws IOException {
		
		responce = given().log().all().spec(util.RequestSpecification())
					.body(sdt.deletePlacePayload(place_id));
	   
	}







	

}















