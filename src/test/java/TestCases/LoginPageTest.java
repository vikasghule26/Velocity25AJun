package TestCases;

import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import Base.TestBase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Pages.LoginPage;
import Utility.CaputureScreenshot;
import Utility.ReadData;

public class LoginPageTest extends TestBase {
	
	LoginPage login;
	
	
	//It is prerequisite to run the test case open the browser + enter URL
	//This will excute multiple times depend on number of test cases
	
    @BeforeMethod
    public void setup() throws Exception
    {
    	initialization();
        login = new LoginPage();
    }
    
    //Test case to verify visiblity of login logo
    
    @Test (enabled = true /*, dependsOnMethods = "verifyTitleTest"  , priority = 2 */ )
    public void verifyLoginLogoLogoTest()
    {
    	boolean result = login.verifyLoginLogo();
    	Assert.assertEquals(result, true);
    	System.out.println("verifyLoginLogoLogoTest");
    }
    
    //Test case to verify visibility of Bot logo
    @Test (enabled = true /*, dependsOnMethods = "verifyTitleTest" , priority = 3 */)
    public void verifyBotLogoTest()
    {
    	boolean result = login.verifyBotLogo();
    	Assert.assertEquals(result, true);
    	System.out.println("verifyBotLogoTest");
    }
    
  //Test case to login to application and verify lable
    @Test (enabled = true /*, dependsOnMethods = "verifyTitleTest" , priority = 4 */)
    public void loginToApp1Test() throws Exception
    {
    	String lable = login.loginToApp1();
    	Assert.assertEquals(lable, "PRODUCTS");
//    	Assert.assertEquals(lable,ReadData.readExcelFile(1,0));
    	System.out.println("loginToApp1Test");
    }
   
    //Test case to login to application and verify URL
    @Test (enabled = true /*, priority = 5 */)
    public void loginToApp2Test() throws Exception
    {
//      	Assert.assertEquals(login.loginToApp2(),"https://www.saucedemo.com/inventory.html");
    	Assert.assertEquals(login.loginToApp2(),ReadData.readExcelFile(1, 1));
    	System.out.println("loginToApp2Test");
     }
    
    //Test case to verify title
    @Test (enabled = true /*, priority = 0 */)
    public void verifyTitleTest() throws Exception
    {
        String title = login.verifyTitle();
        Assert.assertEquals(title,"Swag Labs" );
//      Assert.assertEquals(title,ReadData.readExcelFile(1, 2));
        System.out.println("verifyTitleTest");
    }
    
    //Test case to verify current URL
    @Test (enabled = true /*, priority = 1 */)
    public void verifyUrlTest() throws Exception
    {
    	String url = login.verifyUrl();
//    	Assert.assertEquals(url,"https://www.saucedemo.com/");
    	Assert.assertEquals(url,ReadData.readExcelFile(1, 3));
    	System.out.println("verifyUrlTest");
    }
   
    //This is post action after running the test case and will be close the browser
    //This will excute multiple times depend on number of test cases
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


//PASSED: loginToApp1Test
//PASSED: loginToApp2Test
//PASSED: verifyUrlTest
//PASSED: verifyTitleTest
//PASSED: verifyBotLogoTest
//PASSED: verifyLoginLogoLogoTest

