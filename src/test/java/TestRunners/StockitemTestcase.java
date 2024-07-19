package TestRunners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
	features={"FeatureFiles/AddingStockItem.feature"},
	glue ={"StepDefinations"},
	dryRun = false,
	plugin = {"pretty","html:Test Reports/Stockitemrepot.html"}
	
		
		)

public class StockitemTestcase extends AbstractTestNGCucumberTests{

}
