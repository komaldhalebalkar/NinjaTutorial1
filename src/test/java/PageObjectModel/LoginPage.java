package PageObjectModel;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
			WebDriver driver;
	public LoginPage (WebDriver driver) {
		
			driver = driver;
			PageFactory.initElements(driver,this);
			
			}
	@FindBy(id="input-email")
	 private WebElement email;
	public void Email(String em)
	{
		email.sendKeys(em);
	}
	@FindBy(id="input-password")
	 private WebElement pass;
	public void Password(String passw)
	{
		pass.sendKeys(passw);
	}
	@FindBy(xpath="//input[@type='submit']")
	 private WebElement loginbt;
	public void LoginBtn()
	{
		loginbt.click();
	}
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	 private WebElement warnmsg;
	public void WarnMsg()
	{
		Assert.assertTrue(warnmsg.getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	@FindBy(xpath="//a[text()='Edit your account information']")
	 private WebElement succmsg;
	public void SuccMsg()
	{
		String actual=succmsg.getText();
		String expected="Edit your account information1";
		Assert.assertEquals(expected, actual);
		
	    
	}


}
