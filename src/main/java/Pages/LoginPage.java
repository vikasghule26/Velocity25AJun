package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

//TC-1 Verify application title
//TC-2 Verify application URL
//TC-3 Verify visibility of login logo
//TC-4 Login to application
//TC-5 Verify the URL of second page(inventory page)

public class LoginPage  extends TestBase{
	
	

		//Object Repository
	@FindBy(xpath ="//div[@class='login_logo']")private WebElement loginLogo;
	@FindBy(xpath ="//div[@class='bot_column']")private WebElement botLogo;
	@FindBy(xpath ="//input[@id='user-name']")private WebElement usernameTextbox;
	@FindBy(xpath ="//input[@id='password']")private WebElement passwordTextbox;
	@FindBy(xpath ="//input[@id='login-button']")private WebElement loginBtn;
	@FindBy(xpath ="//span[@class='title']")private WebElement productLable;
	
	//Constructor to initialize the elements of page/current class usin this keyword
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Method
	//Method to verify the current URL
    public String loginToApp2() throws Exception
    {
	    loginToApp1();
	    return driver.getCurrentUrl();
    }

  //Method to verify the title
  	public String verifyTitle()
  	{
  		return driver.getTitle();
  	}
  	
  	//Method to verify visibility og login logo
  	public boolean verifyLoginLogo()
  	{
  		return loginLogo.isDisplayed();
  	}
  	
  	//Method to verify visibility of Botloggo
  	public boolean verifyBotLogo()
  	{
  		return botLogo.isDisplayed();
  	}
  	
	//Method to login to application and verify the lable
	public String loginToApp1() throws Exception
	{
		usernameTextbox.sendKeys(ReadData.readPropertyFile("username"));	
		passwordTextbox.sendKeys(ReadData.readPropertyFile("password"));
		loginBtn.click();
		return productLable.getText();
		}
		
	//Method to verify the URL
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
}
