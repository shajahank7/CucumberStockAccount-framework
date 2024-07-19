package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions
(
		features ="FeatureFiles/AdminLoginWithInvalidinputs.feature",
		glue = "StepDefinations",
		dryRun = false,
		//tags ="@tags1",
		plugin = {"pretty","html:Test Reports/LoginWIthValidinputs.html"}
		
		
		
	)

public class AdminLoginwithInvalidInputs extends AbstractTestNGCucumberTests{

}
