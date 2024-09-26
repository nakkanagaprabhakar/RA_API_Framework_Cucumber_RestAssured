package Resources;

import PojoClasses.AddPlace_Main;
import PojoClasses.Location_Sub;

public class SendDataTest {
	
	public AddPlace_Main SendData(String name, String language, String address)
	{
		Location_Sub ls = new Location_Sub();
		ls.setLat(-38.383494);
		ls.setLng(33.427362);
		
		AddPlace_Main apm = new AddPlace_Main();
		apm.setLocation(ls);
		apm.setAccuracy(50);
		apm.setName(name);
		apm.setPhone_number("(+91) 983 893 3937");
		apm.setAddress(address);
//		apm.setTypes(null);                               // Need to Create ArrayList but it is not importing java.utils.arrayList  
		apm.setWebsite("http: //google.com");
		apm.setLanguage(language);
		
		
		return apm;
			
	}
	

	public String deletePlacePayload(String placeID)
	{
		return "{\r\n"
				+ "\"place_id\": \""+placeID+"\"\r\n"
				+ "}";
	}
	
	
	
	
	
	
	
}
