package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.ReadData;
import Utility.UtilityMethod;

public class InventoryPage extends TestBase {
	
	//TC1 -verify the visibility of small logo
	//TC2 -verify the visibility of big logo
	//TC3 -Add 6 product in cart
	//TC4 -Remove 2 product from cart
	//TC5 -verify the visibility of twitter logo(Assignment)
	//TC6 -verify the visibility of facebook logo(Assignment)
	//TC7 -verify the visibility of linkedin logo(Assignment)
	
	//Object Repository
	@FindBy(xpath = "//div[@class='peek']") private WebElement smallLogo;
	@FindBy(xpath = "//img[@class='footer_robot']") private WebElement bigLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement sorterDropdown;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") 
	private WebElement tshirtBlackProduct16;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") 
	private WebElement jacketProduct50;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
	private WebElement tshirtProduct8;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") 
	private WebElement tshirtRedProduct16;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement ProductCountIcon;
	@FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[@href='https://www.facebook.com/saucelabs']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[@href='https://www.linkedin.com/company/sauce-labs/']") 
	private WebElement linkedinLogo;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") 
	private WebElement removeBackpack;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") 
	private WebElement removebikelight;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement ProductCountIcon1;
	
	//Constructor
	public InventoryPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Methods
	public boolean verifySmallLogo()
	{
		return smallLogo.isDisplayed();
	}
	
	public boolean verifyBigLogo()
	{
		return bigLogo.isDisplayed();
	}
	
	public String add6Product() throws Exception
	{
//		Select s = new Select(sorterDropdown);
//		s.selectByVisibleText(ReadData.readExcelFile(0,0));
		UtilityMethod.selectClass(sorterDropdown, ReadData.readExcelFile(0,0));
		backpackProduct.click();
		bikeLightProduct.click();
		tshirtBlackProduct16.click();
		jacketProduct50.click();
		tshirtProduct8.click();
		tshirtRedProduct16.click();
		 String count = ProductCountIcon.getText();
		 return count;
	}
	
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	public boolean verifyLinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
	}
	
	public String remove2Product()
	{
		Select s1 = new Select(sorterDropdown);
		s1.selectByVisibleText("Price (low to high)");
		removeBackpack.click();
		removebikelight.click();
		String count2 = ProductCountIcon1.getText();
		return count2;
	}
	
	
}

