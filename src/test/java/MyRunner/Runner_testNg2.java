package MyRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src/test/java/Feature/Register.feature",
		glue={"StepDefination"},
		plugin={"pretty", "html:target/CucumberReport/report.html"},
		dryRun=false,
		monochrome=true,
		tags="@tag11"
		
	)

public class Runner_testNg2 extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
