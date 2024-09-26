Feature: Validating Place APIs

	@AddPlace  @Regression     # tag
	Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI or not
		Given Add the Addplace payload with "<Name>" "<Language>" "<Address>"
		When user call "AddPlaceAPI" with "POST" http Request                   
		Then The API call got success with Status Code 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
		And verify place_id created maps to "<Name>" using "GetPlaceAPI"
		
		Examples:                                                     # This is "Data Driven Testing"   through cucumber feature file
						| Name      | Language | Address |
						| Prabhakar | English  | Kalluru |
  					| Nakka     | Telugu   | Tenali  |
  			    | Naga      | Hindi    | Delhi   |
		
	
	@DeletePlace   @Regression   # tag
	Scenario: Verify if Delete Place Functunality working or not
			Given delete the Delete Place Payload	
			When user call "DeletePlaceAPI" with "Delete" http Request
			Then The API call got success with Status Code 200
		  And "status" in response body is "OK"
		
		