package DRTTest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import Base.TestBase;
import DRTPages.FBLoginPage;




public class LoginTest extends TestBase  {

	public static FBLoginPage fp;
	
	
	
	
	public LoginTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public static void SetUp(){
		installation();
		fp= new FBLoginPage();
		
		
	}
	
	@Test
	public static void TestTitle(ITestResult result){
	
		String title= FBLoginPage.PageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
		
		
	}
	
	@Test
	public static void EnterUserDetails(ITestResult result){
			fp.enterNewUserDetails();
		
		
		
	}
	
	
	@AfterMethod
	public void TearDown(){
		driver.close();
	
		
	}
	
	
	
	
	
	
	
	
}
