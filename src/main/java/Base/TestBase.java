package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

//This class will be extended to all page classes and test classes
public class TestBase {
	
	//driver is defined globally by which it can be used by all page and test classes
	//Static cause single copy of driver will be used all across the classes
	public static WebDriver driver;
	
	//This method open the browser and enter the application url
	public void initialization() throws Exception
	{	
		String browser = ReadData.readPropertyFile("browser");
		if(browser.equals("chrome"))
		{
		   WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
		}
		
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://www.saucedemo.com/");
		driver.get(ReadData.readPropertyFile("url"));
	}
	
}
