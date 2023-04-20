package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation 
{
public ProductValidation(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//span[@class='lvtHeaderText']")
//@FindBy(xpath="//span[@id='dtlview_Product Name']")
private WebElement productData;

//getter methods
public WebElement getProductData() {
	return productData;
}
//bussiness logics
public void ProductValidation1(WebDriver driver,String actData)
{
	String actDat = productData.getText();
	 if(actData.contains(actData))
	 {
	 	System.out.println("validation pass");
	 }
	 	else
	 	{
	 		System.out.println("validation fail");
	 	}
	

}


}
