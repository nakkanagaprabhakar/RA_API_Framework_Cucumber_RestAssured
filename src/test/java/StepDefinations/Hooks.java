package StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void BeforeScenario() throws IOException
	{
		// execute this code only when placeID id null
		// write a code that will give you placeID
		
		APITest_StepDefination at_sd = new APITest_StepDefination();
		
		if(APITest_StepDefination.place_id == null)
		{
			at_sd.add_the_addplace_payload("Prabha", "french", "Asia");
			at_sd.user_call_add_place_api_with_post_http_request("AddPlaceAPI", "POST");
			at_sd.verify_place_id_created_maps_to_using("Prabha", "GetPlaceAPI");
		}
	}
	
	

}
