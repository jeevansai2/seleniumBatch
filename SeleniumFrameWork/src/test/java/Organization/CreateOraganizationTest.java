package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.GroupShape;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_utility;
import POM.CamapaignCreationPage1;
import POM.CampaignValidation;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganisationCreationPage;
import POM.ValidationAndVerificationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_Utility.ListenerClass.class)
public class CreateOraganizationTest extends BaseClass
{
	//@Test(groups = {"smoketest","regressiontest","sanitytest"})
	@Test(retryAnalyzer = Generic_Utility.RetryExample.class)
    public void createOraganizationTest() throws Throwable
	//public static void main(String[] args) throws Throwable
	{
		/*String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();*/
		
		/*WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();*/
		
		
		//Property_Utility plib1=new Property_Utility();
		/*String BROWSER = plib1.getkeyValue("broswer");
		
		//WebDriver driver=null;
		  WebDriver driver;
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
		}*/
		
		//driver.manage().window().maximize();
		Webdriver_utility wlib=new Webdriver_utility();
		wlib.implicityWait(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Property_Utility plib=new Property_Utility();
		 /*String URL = plib.getkeyValue("url");
		String USERNAME = plib.getkeyValue("username");
		String PASSWORD = plib.getkeyValue("password");*/
		
		/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertiesFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		//driver.get(URL);
	
		//driver.get("http://localhost:8888/");
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//LoginPage loginpage=new LoginPage(driver);
		//loginpage.loginToApp(USERNAME,PASSWORD );
		//loginpage.getSubmitBtn().click();
		
		HomePage homepage=new HomePage(driver);
		homepage.getOragEdtTxt().click();
		//Assert.assertEquals(false, true);
		//homepage.getSubmitBtn1().click();
		
		//driver.findElement(By.linkText("Organizations")).click();
		OrganisationCreationPage org=new OrganisationCreationPage(driver);
		org.getOrganisationCreateImage().click();
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Random ran=new Random();
		//int RanNum = ran.nextInt(1000);
		
		Java_Utility jlib=new Java_Utility();
		int RanNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String exceldata = elib.getExcelData("Organization", 2, 1)+RanNum;
		/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Organization");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(1);
		String exceldata = cell.getStringCellValue()+RanNum;*/
		
	   org.organisationNameTextField(exceldata);
	//driver.findElement(By.name("accountname")).sendKeys(exceldata);
		org.saveButton();
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'][1])")).click();
		ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
		//validate.getActualOrganizationData().getText();
		String actDAta = validate.organisationValidation(driver, exceldata);
		/*String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(exceldata))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
			
		}*/
		//WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions act=new Actions(driver);
		//WebElement data = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//act.moveToElement(data).perform();
		//act.contextClick(data).perform();
		
		//homepage.getSignoutImg().click();
		//homepage.getSignoutLinkText().click();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertEquals(actDAta, exceldata);
	}

	}

