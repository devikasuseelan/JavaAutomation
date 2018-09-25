package Runner;

import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Vishwam\\Desktop\\JavaFrameworkForGrabOne-master\\src\\test\\java\\Features", //the path of the feature files
		glue={"StepDefinitions"}, //the path of the step definition files
		format= {"pretty","html:test-outout"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step definition file
		)
 


public class TestRunner {

}
