package PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
			WebDriver driver;
		public HomePage (WebDriver driver) {
			
				driver = driver;
				PageFactory.initElements(driver,this);
				
				}
		@FindBy(xpath="//span[text()='My Account']")
		 private WebElement MyAcct;
		public void MyAccount()
		{
			MyAcct.click();
		}

		@FindBy(xpath="//a[text()='Login']")
		 private WebElement login1;
		public void Login()
		{
			login1.click();
		}
		@FindBy(xpath="//a[.='Register']")
		 private WebElement Register;
		public void Register()
		{
			Register.click();
		}
		

}
