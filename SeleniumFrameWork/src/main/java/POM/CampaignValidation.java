package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CampaignValidation 
{
 public CampaignValidation(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 @FindBy(css="span.dvHeaderText")
 private WebElement campaignData;
 
 //getter methods
public WebElement getCampaignData() {
	return campaignData;
}
 //bussiness logics
public void camapaignValidation1(WebDriver driver,String CampData)
{
	String actdata = campaignData.getText();
	if(actdata.contains(CampData))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
		
	}
	
}
 
 
}
 