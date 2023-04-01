package MyRunner;

import org.testng.annotations.DataProvider;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\A1\\project\\NinjaTutorial\\src\\test\\java\\Feature\\login.feature",
		glue= {"StepDefination"},
//		plugin={"pretty","html:target/CucumberReports/CucumberReport.html"} ,
//		{"pretty", "html:target/CucumberReport/report.html",
//				"json:target/CucumberReport/ReportJson.json",
//				"junit:target/cucumberReport/Report.xml"
//				},
				plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true,
		dryRun=false
		
		)
class Runner_testNG extends AbstractTestNGCucumberTests{
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
}
 