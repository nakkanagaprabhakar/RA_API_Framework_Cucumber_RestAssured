package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification request;           // this is "static" variable serve to entire class
	
	public RequestSpecification RequestSpecification() throws IOException
	{
		if(request==null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));           // FileOutputStream is for genarating new out file with which name was given
			
	//		RestAssured.baseURI = "https://rahulshettyacademy.com";              // here it is not required as it is mentioned in RequestSpecification as "setBaseUri"
			request = new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseUrl"))
								.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
								.addFilter(RequestLoggingFilter.logRequestTo(log))
								.addFilter(ResponseLoggingFilter.logResponseTo(log))
								.build();
			
			return request;
		}
		else
			return request;
		
		
	}
	
	
	
	public String getGlobalProperties(String keyBaseUrl) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\prabh\\eclipse-workspace\\RA_API_Framework_Cucumber\\src\\test\\java\\Resources\\Global.properties");     // FileInputStream is used for read the file already present and give whatever we required    
		Properties prop = new Properties();
		prop.load(fis);
		
		String BaseUrl = prop.getProperty(keyBaseUrl);
		
		return BaseUrl;
				
	}
	
	

}













