package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaputureScreenshot;

public class FailedTest extends TestBase  {

	LoginPage login;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		 login = new LoginPage();
	}
	
	//Test case to verify visibility of login logo
	@Test
	public  void verifyloginLogoTest()
	{
		 boolean result = login.verifyLoginLogo();
         Assert.assertEquals(result, true);
		 System.out.println("verifyloginLogoTest");
	}
	
	//Test case to verify visibility of login logo
	@Test
	public void verifyBotLogoTest()
	{
	    boolean result = login.verifyBotLogo();
	    Assert.assertEquals(result, true);
	    System.out.println("verifyBotLogoTest");
	}
	 
	//Test case to login to application and verify lable
	@Test
	public void loginToApp1Test() throws Exception
	{
		String lable = login.loginToApp1();
		Assert.assertEquals(lable,"PRODUCTS");
		System.out.println("loginToApp1Test");
	}
	
	//Test case to login to application and verify URL
	@Test
	public void loginToApp2Test() throws Exception
	{
		Assert.assertEquals(login.loginToApp2(),"https://www.saucedemo.com/inventory.html");
		System.out.println("loginToApp2Test");
	}
	
	//Test case to verify current URL
	@Test
	public void verifyURLTest()
	{
		String url = login.verifyUrl();
		Assert.assertEquals(url,"https://www.saucedemo.com/");
		System.out.println("verifyURLTest");
	}
	
	//Test case to verify title
	@Test
	public void verifyTitleTest()
	{
		String title = login.verifyTitle();
		Assert.assertEquals(title, "Swag Labs");
		System.out.println("verifyTitleTest");	
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
		CaputureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}
	
}

//Total 6 TC
//2 TC passed 4 failed
