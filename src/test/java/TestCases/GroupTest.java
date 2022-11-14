package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaputureScreenshot;

public class GroupTest extends TestBase {

	LoginPage login;
	
    @BeforeMethod(alwaysRun = true)
    public void setup() throws Exception
    {
    	initialization();
        login = new LoginPage();
    }
    
    @Test(groups= {"Sanity","Smoke","Regression"})
    public void verifyLoginLogoLogoTest()
    {
    	boolean result = login.verifyLoginLogo();
    	Assert.assertEquals(result, true);
    	System.out.println("verifyLoginLogoLogoTest");
    }
    
  
    @Test(groups= "Sanity") 
    public void verifyBotLogoTest()
    {
    	boolean result = login.verifyBotLogo();
    	Assert.assertEquals(result, true);
    	System.out.println("verifyBotLogoTest");
    }
    
    @Test(groups="Sanity")
    public void loginToApp1Test() throws Exception
    {
    	String lable = login.loginToApp1();
    	Assert.assertEquals(lable, "PRODUCTS");
    	System.out.println("loginToApp1Test");
    }
   
    @Test(groups="Smoke")
    public void loginToApp2Test() throws Exception
    {
    	Assert.assertEquals(login.loginToApp2(),"https://www.saucedemo.com/inventory.html");
    	System.out.println("loginToApp2Test");
     }
    
    @Test(groups="Sanity")
    public void verifyTitleTest() throws Exception
    {
        String title = login.verifyTitle();
        Assert.assertEquals(title,"Swag Labs" );
        System.out.println("verifyTitleTest");
    }
    
     @Test(groups="Smoke")
    public void verifyUrlTest() throws Exception
    {
    	String url = login.verifyUrl();
    	Assert.assertEquals(url,"https://www.saucedemo.com/");
    	System.out.println("verifyUrlTest");
    }
   
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult it) throws Exception
    {
    	if(ITestResult.FAILURE == it.getStatus())
    	{
    		CaputureScreenshot.screenshot(it.getName());
    	}
    	driver.close();
    }

}
