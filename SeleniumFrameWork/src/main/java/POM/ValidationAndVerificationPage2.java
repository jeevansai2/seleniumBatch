package POM;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage2
{
public ValidationAndVerificationPage2(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[@id='dtlview_Product']")
	private WebElement actualProductData;
	
	
	public WebElement getActualProductData() {
		return actualProductData;
	}
	
	public void productValidation(WebDriver driver,String productdata)
	{
		String actData = actualProductData.getText();
		if(actData.contains(productdata))
	     {
	     	System.out.println("product Pass");
	     }
	     else
	     {
	     	System.out.println("Product fail");
	     }
	     
	
}
}