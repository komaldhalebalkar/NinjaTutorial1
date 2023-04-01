package StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjectModel.HomePage;
import PageObjectModel.RegisterPage;
import Utilities.ReadConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDef extends BaseClass {

	@Before
	public void setup()
	{
		readConfig=new ReadConfig();
			log = LogManager.getLogger("loginStepdef");
		String Browser=readConfig.getBrowser();
		switch(Browser.toLowerCase())
		{
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	hp=new  HomePage(driver);
	Rp=new RegisterPage(driver);
	}
	
	@AfterStep
	public void teardown(Scenario sc) throws IOException
	{
//		if(sc.isFailed()==true)
//		{
//			String path="C:\\Users\\A1\\project\\NinjaTutorial\\ScreenShot\\scrnshot.png";
//			TakesScreenshot scrn=((TakesScreenshot)driver);
//			File from=scrn.getScreenshotAs(OutputType.FILE);
//			File to=new File(path);
//			FileUtils.copyFile(from, to);
//			log.info("Screenshot Capture........");
//			
//		}}

		if(sc.isFailed()==true)
		{
		final byte[]scrn=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(scrn, "image.png", sc.getName());
	}}
	@After
	public void teardown1() { 
		driver.close();
		}
@Given("user nevigate to regiter account page")
public void user_nevigate_to_regiter_account_page() {
	driver.get("http://www.tutorialsninja.com/demo/");
	hp.MyAccount();
    hp.Register();	
    
}

@Given("enter the user info details into below field")
public void enter_the_user_info_details_into_below_field(DataTable dataTable) {
	Map<String,String> listdata =dataTable.asMap(String.class,String.class);
	//for(Map<String,String> mapdata:listdata)
	Rp.Firstname(listdata.get("firstname"));
	Rp.lastnamefield(listdata.get("lastname"));
	Rp.emailidfield(listdata.get("emailid"));
	Rp.telephonefield(listdata.get("telephone"));
	Rp.passwordfield(listdata.get("password"));
	Rp.confirmpasswordfield(listdata.get("confirm password"));

}
@Given("enter the users info details into below field")
public void enter_the_users_info_details_into_below_field(DataTable dataTable) {
	List<Map<String,String>>ldata=dataTable.asMaps(String.class,String.class);
	for(Map<String,String> mdata:ldata) {
		Rp.Firstname(mdata.get("firstname"));
		Rp.lastnamefield(mdata.get("lastname"));
		Rp.emailidfield(mdata.get("emailid"));
		Rp.telephonefield(mdata.get("telephone"));
		Rp.passwordfield(mdata.get("password"));
		Rp.confirmpasswordfield(mdata.get("confirm password"));
		Rp.Checkbox();
		Rp.Submit();
		 Rp.AcctCreation();
	}
}
@Given("select privacy policy")
public void select_privacy_policy() {
	//Rp.Checkbox();
   
}

@Given("click on contineue buton")
public void click_on_contineue_buton() {
	//Rp.Submit();
}

@Then("account should successfully created")
public void account_should_successfully_created() {
	 //Rp.AcctCreation();
}


}