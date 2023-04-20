package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser 
{
public static void main(String[] args) throws Throwable
{
	String key = "webdriver.chrome.driver";
	String value = "./src/main/resources/chromedriver.exe";
	System.setProperty(key, value);
	WebDriver driver=new ChromeDriver();
	

	/*String key = "webdriver.edge.driver";
	String value = "./src/main/resources/msedgedriver.exe";
	System.setProperty(key, value);
	WebDriver driver=new EdgeDriver();*/
	
	
	FileInputStream fis=new FileInputStream("./src/test/resources/PropertiesFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String url1 = pro.getProperty("url1");
		String username1 = pro.getProperty("username1");
		String password1 = pro.getProperty("password1");
		
		driver.get(url1);
		driver.findElement(By.id("username")).sendKeys(username1);
		driver.findElement(By.name("pwd")).sendKeys(password1);
		driver.findElement(By.id("loginButton")).click();
		
}
}
