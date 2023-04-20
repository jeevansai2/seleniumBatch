package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{




public static WebDriver sdriver;

public WebDriver driver;
	@BeforeSuite(groups = {"smoketest","regressiontest","sanitytest"})
public void BS()
{
		System.out.println("DataBase Connection");
}
	@BeforeTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void BT()
	{
		System.out.println("Parallel execution");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoketest","regressiontest","sanitytest"})
	//public void BC(String BROWSER) throws Throwable
	public void BC() throws Throwable
	{
		
		Property_Utility plib1=new Property_Utility();
		String BROWSER = plib1.getkeyValue("broswer");
		
		//WebDriver driver=null;
		 // WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		System.out.println("Launching browser");
		sdriver=driver;
	}
	@BeforeMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void BM() throws Throwable
	{
		driver.manage().window().maximize();
		Property_Utility plib1=new Property_Utility();
		 String URL = plib1.getkeyValue("url");
		String USERNAME = plib1.getkeyValue("username");
		String PASSWORD = plib1.getkeyValue("password");
		driver.get(URL);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApp(USERNAME,PASSWORD );
		System.out.println("Login Application");
	}
	@AfterMethod(groups = {"smoketest","regressiontest","sanitytest"})
	public void AM()
	{
		HomePage homepage=new HomePage(driver);
		homepage.getSignoutImg().click();
	    homepage.getSignoutLinkText().click();
		System.out.println("Logout Application");
	}
	@AfterClass(groups = {"smoketest","regressiontest","sanitytest"})
	public void AC()
	{
		//driver.quit();
		System.out.println("Browser Closed");
	}
	@AfterTest(groups = {"smoketest","regressiontest","sanitytest"})
	public void AT()
	{
		System.out.println("Parallel Execution Done");
	}
	@AfterSuite(groups = {"smoketest","regressiontest","sanitytest"})
	public void AS()
	{
		System.out.println("DataBase Connection Close");
	}
	
}
