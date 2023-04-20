package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationPage2 
{
public ProductCreationPage2(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//img[@alt='Create Product...']")
private WebElement prdCreateImage;

@FindBy(name="productname")
private WebElement prdNameTextField;

@FindBy(name="button")
private WebElement prdSaveButton;

//getter methods
public WebElement getPrdCreateImage() {
	return prdCreateImage;
}

public WebElement getPrdNameTextField() {
	return prdNameTextField;
}

public WebElement getPrdSaveButton() {
	return prdSaveButton;
}
//bussiness logic
public void clickprdCreateImage()
{
	prdCreateImage.click();
}
public void prdNameTextField(String prdtName)
{
	prdNameTextField.sendKeys(prdtName);
}
public void prdSaveButton()
{
	prdSaveButton.click();
}
}

