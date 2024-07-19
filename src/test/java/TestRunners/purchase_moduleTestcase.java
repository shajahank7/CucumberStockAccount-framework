package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions

(
	features="FeatureFiles/purchase_module.feature",
	glue = "StepDefinations",
	dryRun = false,
	plugin = {"pretty","html:Test Reports/purchase_moduleReport.html"}
	
		
)



public class purchase_moduleTestcase extends AbstractTestNGCucumberTests{

}
