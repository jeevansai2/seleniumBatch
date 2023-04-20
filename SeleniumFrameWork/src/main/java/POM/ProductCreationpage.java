package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreationpage 
{
public  ProductCreationpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Declaration
@FindBy(xpath="//img[@alt='Create Product...']")
private WebElement productCreateImage;

@FindBy(name="productname")
private WebElement productNameTextField;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement productSaveButton;

@FindBy(id="search_txt")
private WebElement searchTextField;

@FindBy(name="search")
private WebElement searchButton;


//getter methods
public WebElement getProductCreateImage() {
	return productCreateImage;
}

public WebElement getProductNameTextField() {
	return productNameTextField;
}

public WebElement getProductSaveButton() {
	return productSaveButton;
}

public WebElement getSearchTextField() {
	return searchTextField;
}

public WebElement getSearchButton() {
	return searchButton;
}

//bussiness logics
public void clickProductCreateImage()
{
	productCreateImage.click();
}
public void productNameTextField(String prdName)
{
	productNameTextField.sendKeys(prdName);
}
public void searchTextField(String srchName)
{
	searchTextField.sendKeys(srchName);
}
public void searchButton()
{
	searchButton.click();
}
public void productSaveButton()
{
	productSaveButton.click();
}
}