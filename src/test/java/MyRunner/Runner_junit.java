package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\A1\\project\\NinjaTutorial\\src\\test\\java\\Feature\\login.feature",
		glue= {"StepDefination"},
//		//plugin={"pretty","html:target/CucumberReports/CucumberReport.html"} ,
		plugin={"pretty", "html:target/CucumberReport/report.html",
				"json:target/CucumberReport/ReportJson.json",
				"junit:target/cucumberReport/Report.xml"
				},
				//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true,
		dryRun=false,
		tags="@tag1"
		
		)
public class Runner_junit {

} 
