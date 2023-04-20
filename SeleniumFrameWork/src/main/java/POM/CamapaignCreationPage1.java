package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CamapaignCreationPage1 
{
public CamapaignCreationPage1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@alt='Create Campaign...']")
private WebElement campCreateImage;

@FindBy(name="campaignname")
private WebElement campNameTextField;

@FindBy(xpath="(//input[@title='Save [Alt+S]'][1])")
private WebElement campSaveButton;

public WebElement getCampCreateImage() {
	return campCreateImage;
}

public WebElement getCampNameTextField() {
	return campNameTextField;
}

public WebElement getCampSaveButton() {
	return campSaveButton;
}
public void clickcampCreateImage()
{
	campCreateImage.click();
}
public void campNameTextField(String camName)
{
	campNameTextField.sendKeys(camName);
}
public void campSaveButton()
{
	campSaveButton.click();

}
}
