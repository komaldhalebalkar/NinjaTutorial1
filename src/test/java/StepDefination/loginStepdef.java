package StepDefination;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginStepdef extends BaseClass {
//	WebDriver driver;
//	public HomePage hp;
//	public LoginPage lp;
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
lp=new LoginPage (driver);
log.fatal("Setup1 executed...");
	}

@AfterStep
public void teardown(Scenario sc) throws IOException
{
//	if(sc.isFailed()==true)
//	{
//		String path="C:\\Users\\A1\\project\\NinjaTutorial\\ScreenShot\\scrnshot.png";
//		TakesScreenshot scrn=((TakesScreenshot)driver);
//		File from=scrn.getScreenshotAs(OutputType.FILE);
//		File to=new File(path);
//		FileUtils.copyFile(from, to);
//		log.info("Screenshot Capture........");
//		
//	}}

	if(sc.isFailed()==true)
	{
	final byte[]scrn=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	sc.attach(scrn, "image.png", sc.getName());
}}
@After
public void teardown1() { 
	driver.close();
	}
@When("^user enters the valid emailid (.+)$")
public void user_enters_the_valid_emailid(String Email) {
	
	hp.MyAccount();
	hp.Login();
	lp.Email(Email);
	log.info("valid email inserted........"); 
	}


@Given("user nevigate to application url")
public void user_nevigate_to_application_url() {
	driver.get("http://www.tutorialsninja.com/demo/");
	log.info("Application open........");
    
}


@When("^user enters the valid password (.+)$")
public void user_enters_the_valid_password(String pass) {
	lp.Password(pass);
	log.info("Passwrd inserted........");
	  
}

@When("user click on login button")
public void user_click_on_login_button() {
	lp.LoginBtn();
	log.info("Login Button click........");
	    
}

@Then("user should login successfully")
public void user_should_login_successfully() {
	log.info("Login successfully........");
}

@When("user enters the invalid password {string}")
public void user_enters_the_invalid_password(String invpass) {
	lp.Password(invpass);
	log.info("invalid pass inserted........");

}

@Then("user should get proper warning massage")
public void user_should_get_proper_warning_massage() {
	lp.WarnMsg();
	log.warn("warning display........");
	
    
}

@When("user enters the invalid emailid {string}")
public void user_enters_the_invalid_emailid(String invEmail) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	hp.MyAccount();
	hp.Login();
	lp.Email(invEmail);
	log.info("invalid email inserted........");
}

@When("user enters the empty emailid {string}")
public void user_enters_the_empty_emailid(String em) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	hp.MyAccount();
	hp.Login();
	lp.Email(em);
	log.info("empty email inserted........");
}

@When("user enters the empty password {string}")
public void user_enters_the_empty_password(String ps) {
	lp.Password(ps);
	log.info("empty password inserted........");
    
}

}
