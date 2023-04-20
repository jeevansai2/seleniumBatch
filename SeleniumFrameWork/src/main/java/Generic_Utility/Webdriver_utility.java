package Generic_Utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Webdriver_utility 
{
	/**
	 * This method wait for page to load in GUI
	 * @param driver
	 */
 public void implicityWait(WebDriver driver)
 {
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

 }
 
/**
 * This method used for switching windows
 * @param driver
 * @param PartialWindowTitle
 * @author jeevanravi
 */
 public void switchwindow(WebDriver driver,String PartialWindowTitle)
 {
	 Set<String> allId = driver.getWindowHandles();
     Iterator<String> id = allId.iterator();
     
    while(id.hasNext())
     {
   	  String wid = id.next();//org
   	  driver.switchTo().window(wid);
   	  String title = driver.getTitle();
   	  
   	  if(title.contains("Products&action"))
   	  {
   		  break;
   	  }
     }
    
 }

 public void switchToAlertAndAccpect(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

}


	


