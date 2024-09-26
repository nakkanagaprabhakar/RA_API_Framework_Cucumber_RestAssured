//package StepDefinations;
//
//import static io.restassured.RestAssured.given;
//
//import PojoClasses.AddPlace_Main;
//import PojoClasses.Location_Sub;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import static org.junit.Assert.*;
//
//public class StandAloneTest {
//	RequestSpecification responce;
//	Response response1;
//	String response2;
//	
//
//	@Given("Add the Addplace payload")
//	public void add_the_addplace_payload() {
//		
//		Location_Sub ls = new Location_Sub();
//		ls.setLat(-38.383494);
//		ls.setLng(33.427362);
//		
//		AddPlace_Main apm = new AddPlace_Main();
//		apm.setLocation(ls);
//		apm.setAccuracy(50);
//		apm.setName("Frontline house");
//		apm.setPhone_number("(+91) 983 893 3937");
//		apm.setAddress("29, side layout, cohen 09");
////		apm.setTypes(null);                               // Need to Create ArrayList but it is not importing java.utils.arrayList  
//		apm.setWebsite("http: //google.com");
//		apm.setLanguage("French-IN");
//		
//		
//		
//		RestAssured.baseURI = "https://rahulshettyacademy.com";
//		
//		responce = given().log().all().queryParam("key", "qaclick123").body(apm);
//		
//	    
//	}
//	
//	
//	@When("user call AddPlaceAPI with POST http Request")
//	public void user_call_add_place_api_with_post_http_request() {
//		
//		response1 = responce.when().post("maps/api/place/add/json")
//				.then().log().all().extract().response();
//		
//	   
//	}
//	
//	
//	@Then("The API call got success with Status Code {int}")
//	public void the_api_call_got_success_with_status_code(Integer StatusCode) {
//		
//		assertEquals(response1.getStatusCode(), 200);
//	    
//	}
//	
//	
//	@Then("{string} in response body is {string}")
//	public void in_response_body_is(String keyvalue, String ExpectedValue) {
//		response2 = response1.asString();
//		JsonPath jp = new JsonPath(response2);
//		assertEquals(jp.get(keyvalue).toString(), ExpectedValue);
//	    
//	}
//
//
//
//	
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
