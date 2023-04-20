package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	public HomePage(WebDriver driver)
	 
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	@FindBy(linkText="Organizations")
	private WebElement oragEdtTxt;
	
	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLinkText;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLinkText;

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	//@FindBy(linkText="Sign Out")
	//private WebElement signoutLinkText;

	public WebElement getProductLinkText() {
		return productLinkText;
	}

	public WebElement getCampaignsLinkText() {
		return campaignsLinkText;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getSignoutLinkText() {
		return signoutLinkText;
	}

	

	public WebElement getOragEdtTxt() {
		return oragEdtTxt;
	}
	
public void loginToApp()
{
	oragEdtTxt.click();
	productLinkText.click();
	campaignsLinkText.click();
	morelink.click();
	signoutImg.click();
	signoutLinkText.click();
}


	
}
