package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions
(
   features=	"FeatureFiles/Adminlogin.feature",
   glue = "StepDefinations",
   dryRun = false,
   
   plugin = {"pretty","html:Test Reports/loginreport.html"}
   
   
   
)

public class AdminLoginTestCase  extends AbstractTestNGCucumberTests{

}
