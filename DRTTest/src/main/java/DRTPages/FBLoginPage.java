package DRTPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.Utility;

public class FBLoginPage extends TestBase {

	
	public FBLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	

@FindBy(how = How.XPATH,using="//input[@name='firstname']")
 WebElement fname;

@FindBy(how = How.XPATH,using="//input[@name='lastname']")
 WebElement Sname;

@FindBy(how = How.XPATH,using="//input [@name='reg_email__']")
 WebElement MobileNum;


@FindBy(how = How.XPATH,using="//input[@type='password' and @name='reg_passwd__']")
 WebElement passWord;


public static String PageTitle(){
	String title = driver.getTitle();
	return title;
}


public  void enterNewUserDetails(){
	
	 fname.sendKeys(Utility.getDataFromExcel("Sheet1", "Firstname"));
	 Sname.sendKeys(Utility.getDataFromExcel("Sheet1", "Lastname"));
	 passWord.sendKeys(Utility.getDataFromExcel("Sheet1", "password"));
	
}



	
}
