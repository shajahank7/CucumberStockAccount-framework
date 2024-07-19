package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions
(
		features={"FeatureFiles/supplier.feature"},
		glue = {"StepDefinations"},
		dryRun = false,
		plugin = {"pretty","html:Test Reports/supplierrepot.html"}
		
)

public class supplier_moduletestcase  extends AbstractTestNGCucumberTests{

}
