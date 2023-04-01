package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class RegisterPage {
	WebDriver driver;
	public RegisterPage (WebDriver driver) {
		
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
			}
	@FindBy(id="input-firstname")
	WebElement Firstnamefield;
	
	public void Firstname(String fname) {
		Firstnamefield.sendKeys(fname);
	}
	
	@FindBy(id="input-lastname")
		WebElement lastnamefield;
	
	public void lastnamefield(String lname) {
		lastnamefield.sendKeys(lname);
	}
		
		@FindBy(id="input-email")
				WebElement emailidfield;
		
		public void emailidfield(String email) {
			emailidfield.sendKeys(email);
		}
			
				
				@FindBy(id="input-telephone")
				WebElement telephonefield;
			
				public void telephonefield(String telno) {
					telephonefield.sendKeys(telno);
				}
					
				@FindBy(id="input-password")
				WebElement passwordfield;
				
				public void passwordfield(String pass) {
					passwordfield.sendKeys(pass);
				}
					
				@FindBy(id="input-confirm")
				WebElement confirmpasswordfield;

				public void confirmpasswordfield(String cpass) {
					confirmpasswordfield.sendKeys(cpass);
				}
				
				@FindBy(xpath="//input[@type='radio']")
				WebElement RadioButt;

				public void RadioButt() {
					RadioButt.click();
				}
				
				@FindBy(xpath="//input[@type='checkbox']")
				WebElement Checkbox;

				public void Checkbox() {
					Checkbox.click();
				}
				
				@FindBy(xpath="//input[@type='submit']")
				WebElement Submit;

				public void Submit() {
					Submit.click();
				}
				@FindBy(xpath="//h1[.='Your Account Has Been Created!']")
				WebElement SuccMsg;

				public void AcctCreation() {
					String actual="Your Account Has Been Created!";
					String expected=SuccMsg.getText();
					Assert.assertEquals(actual, expected);
				}
					
}
