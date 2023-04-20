package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreationPage 
{
public CampaignCreationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Declaration
@FindBy(xpath="//img[@alt='Create Campaign...']")
private WebElement campaignCreateImage;

@FindBy(name="campaignname")
private WebElement campaignNameTextField;

@FindBy(xpath="//img[@alt='Select']")
private WebElement campaignSaveButton;


//getter methods
public WebElement getCampaignCreateImage() {
	return campaignCreateImage;
}

public WebElement getCampaignNameTextField() {
	return campaignNameTextField;
}

public WebElement getCampaignSaveButton() {
	return campaignSaveButton;
}

//bussiness logics

public void clickcampaignCreateImage() 
{
	campaignCreateImage.click();
}
public void campaignNameTextField(String campName)
{
	campaignNameTextField.sendKeys(campName);
}
public void campaignSaveButton()
{
	campaignSaveButton.click();
}
	

}
