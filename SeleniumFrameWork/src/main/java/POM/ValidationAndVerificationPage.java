package POM;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage 
{
 public ValidationAndVerificationPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
	 
 }
 //Declaration
 //@FindBy(css="span.dvHeaderText")
 @FindBy(xpath="//span[@id='dtlview_Organization Name']")
 private WebElement actualOrganizationData;
 
 //getter method
public WebElement getActualOrganizationData() {
	return actualOrganizationData;
}

//bussiness logics
public String organisationValidation(WebDriver driver,String data)
{
	String actdata=actualOrganizationData.getText();

if(actdata.contains(data))
{
	System.out.println("pass");
}
else
{
	System.out.println("fail");
	
}
return actdata;

	
}

}
