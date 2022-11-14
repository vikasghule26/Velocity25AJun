package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTest {
	
	@Test
	public void openGoogle() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void openCricbuzz() throws Exception
	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cricbuzz.com/");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void openBccitv() throws Exception
	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(); 
		driver.get("https://www.bcci.tv/");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void openAmazon() throws Exception
	{
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.safaridriver().setup();
		WebDriver driver = new SafariDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		driver.quit();
	}

}
