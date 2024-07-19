package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
	features="FeatureFiles/customermodule.feature",
	glue = "StepDefinations",
	dryRun = false,
	plugin = {"pretty","html:Test Reports/customer_module.html"}
		
)

public class customermoduleTestcase extends AbstractTestNGCucumberTests {

}
