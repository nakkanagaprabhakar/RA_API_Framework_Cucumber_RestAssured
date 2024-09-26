package Resources;

public enum  EnumAPIClass {                    // Enum Class
	
	AddPlaceAPI("maps/api/place/add/json"),            
	GetPlaceAPI("maps/api/place/get/json"),                // group of constants
	DeletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;
	
	//Constructor
	EnumAPIClass(String resource)         // Constructor   =  this will run first in this class
	{
		this.resource = resource;
	}
	
	
	public String getResource()
	{
		return resource;
	}

}
