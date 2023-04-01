package StepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import PageObjectModel.RegisterPage;
import Utilities.ReadConfig;

public class BaseClass {
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	public static Logger log;
	public ReadConfig readConfig;
	public RegisterPage Rp;
	public String getEmailid()
	{
		return(RandomStringUtils.randomAlphabetic(4));
	}

}
