package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationCreationPage
{
	public OrganisationCreationPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 //Declaration
	 @FindBy(xpath="//img[@alt='Create Organization...']")
	 private WebElement organisationCreateImage;
	 
	 @FindBy(name="accountname")
	 private WebElement organisationNameTextField;
	 
	 @FindBy(xpath="(//input[@title='Save [Alt+S]'][1])")
	 private WebElement saveButton;

	 //getter methods
	public WebElement getOrganisationCreateImage() {
		return organisationCreateImage;
	}

	public WebElement getOrganisationNameTextField() {
		return organisationNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickorganisationCreateImage()
	{
		organisationCreateImage.click();
		
	}
    public void organisationNameTextField(String orgName)
    {
    	organisationNameTextField.sendKeys(orgName);
    }
    public void saveButton()
    {
    	saveButton.click();
    }
}
