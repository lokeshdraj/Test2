package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
public static Properties prop;
public static WebDriver driver;
	
	public TestBase(){
		
		 prop= new Properties();
		
			FileInputStream fa;
			try {
				fa = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Properties/Test.properties");
				prop.load(fa);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	public static void installation(){
		
		String Browsername= prop.getProperty("browser");
		if(Browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
		
		
		
		
		
	}
	
	
	
	
	
}
