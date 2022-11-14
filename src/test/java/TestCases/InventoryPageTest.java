package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class InventoryPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage invent;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		invent = new InventoryPage();
		login = new LoginPage();
	}
		
	@Test (enabled = true, timeOut = 3000)
	public void verifySmallLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifySmallLogo();
		 Assert.assertEquals(result, true, "Failed zali ka????");
		 Assert.assertTrue(true);
		 Assert.assertFalse(false);
		 System.out.println("This is verifySmallLogoTest");
		 
	}
	
	@Test (enabled = true, invocationCount = 5)
	public void verifyBigLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyBigLogo();
		Assert.assertEquals(result,true);
	}
	
	@Test (enabled = true)
	public void add6ProductTest() throws Exception
	{
		login.loginToApp1();
		String result = invent.add6Product();
//		Assert.assertEquals(result,"6");
		Assert.assertEquals(result,ReadData.readExcelFile(1, 4));
	}
	
//	@Test (enabled = true)
//	public void remove2ProductTest() throws Exception
//	{
//		login.loginToApp1();
//		  String result1 = invent.remove2Product();
//		 Assert.assertEquals(result1, "2");
//	}
	
	@Test (enabled = true)
	public void verifyTwitterLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test (enabled = true)
	public void verifyFacebookLogo() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyFacebookLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test (enabled = true)
	public void verifyLinkedinLogo() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyLinkedinLogo();
		Assert.assertEquals(result,true);
	}
			
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
