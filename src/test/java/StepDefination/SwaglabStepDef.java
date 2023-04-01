package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;


import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class SwaglabStepDef {
	XSSFWorkbook ExcelWbook=null;
	 XSSFSheet Excelsheet;
		WebDriver driver;
		
@Given("user want to nevigate url")
public void user_want_to_nevigate_url() {
}

@When("User lagin with multiple user using excel {string}")
public void user_lagin_with_multiple_user_using_excel(String excelpath) {

	// XSSFRow row;
	 //XSSFCell cell;
	 
	File file=new File(excelpath);
	FileInputStream inputfis = null; 
try {
inputfis=new FileInputStream(file);
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
//Excel-wrokbook-sheet-row-cell
//create the object of Workbook for xlxs
try {
	ExcelWbook=new XSSFWorkbook(inputfis);
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

//to access workbooksheet
Excelsheet=ExcelWbook.getSheetAt(0);

//total counting of rows 
int	ttrow=Excelsheet.getLastRowNum()+1;
//total counting of cells
int ttcell=Excelsheet.getRow(0).getLastCellNum();

for(int currow=0;currow<ttrow;currow++)
{
	 ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		//co.setHeadless(true);
		
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies(); 
		
		//enter username
		driver.findElement(By.id("user-name")).sendKeys(Excelsheet.getRow(currow).getCell(0).toString());
		
		//enter username
		driver.findElement(By.id("password")).sendKeys(Excelsheet.getRow(currow).getCell(1).toString()); 
		
		//enter username
		driver.findElement(By.id("login-button")).click();
		
		driver.close();
}

//for(int currow=0;currow<ttrow;currow++)
//{
//	 for(int curcell=0;curcell<ttcell;curcell++)
//	 {
//		 System.out.print(Excelsheet.getRow(currow).getCell(curcell).toString());
//		 System.out.print("\t");
//	 }
//	 System.out.println();
//}
try {
	ExcelWbook.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}
