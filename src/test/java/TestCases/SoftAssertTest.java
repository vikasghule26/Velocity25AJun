package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;

public class SoftAssertTest extends TestBase {
	
	LoginPage login;
	InventoryPage invent;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		invent = new InventoryPage();
		login = new LoginPage();
	}
		
	@Test 
	public void verifySmallLogoTest() throws Exception
	{
		SoftAssert s = new SoftAssert();
		System.out.println("Excution started");
		login.loginToApp1();
		boolean result = invent.verifySmallLogo();
		s.assertEquals(result, true);
		System.out.println("Excution ended");
		s.assertAll();
		 
	}
	
	@Test (enabled = true)
	public void verifyBigLogoTest() throws Exception
	{
		SoftAssert s1 = new SoftAssert();
		login.loginToApp1();
		boolean result = invent.verifyBigLogo();
		s1.assertEquals(result, true);
		s1.assertAll();
		}
	
	@Test (enabled = false)
	public void add6ProductTest() throws Exception
	{
		login.loginToApp1();
		String result = invent.add6Product();
	}
	
//	@Test (enabled = true)
//	public void remove2ProductTest() throws Exception
//	{
//		login.loginToApp1();
//		  String result1 = invent.remove2Product();
//	}
	
	@Test (enabled = false)
	public void verifyTwitterLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyTwitterLogo();
		
	}
	
	@Test (enabled = false)
	public void verifyFacebookLogo() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyFacebookLogo();
		
	}
	
	@Test (enabled = false)
	public void verifyLinkedinLogo() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyLinkedinLogo();
		
	}
			
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
