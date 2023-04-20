package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class validationAndVerificationPage1 
{
public validationAndVerificationPage1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
private WebElement actualCampaignData;



public WebElement getActualCampaignData() {
	return actualCampaignData;
}


public void campaignValidation(WebDriver driver,String CampData)
{
	String act = actualCampaignData.getText();
	 
	if(act.contains(CampData))
     {
     	System.out.println("camp pass");
     }
     else
     {
     	System.out.println("camp fail");
     }
  
}
}
