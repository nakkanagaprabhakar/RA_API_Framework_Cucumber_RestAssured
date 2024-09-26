package Cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

//@CucumberOptions(features="src/test/java/Features", glue= {"StepDefinations"})
//@CucumberOptions(features="src/test/java/Features", glue= {"StepDefinations"}, tags = "@AddPlace")
//@CucumberOptions(features="src/test/java/Features", glue= {"StepDefinations"}, tags = "@DeletePlace")

@CucumberOptions(features="src/test/java/Features", glue= {"StepDefinations"}, 
				plugin = {"json:target/jsonReports/Cucumber_Report.json", "html:target/htmlReports/Cucumber_Report.html"})

public class TestRunner_Junit {

}
