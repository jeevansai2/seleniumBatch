package Campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPrDefault;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_utility;
import POM.CampaignCreationPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductCreationpage;
import POM.ValidationAndVerificationPage2;
import POM.validationAndVerificationPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProdTest extends BaseClass
{
	@Test(groups = "regressiontest")
	public void createCampWithProdTest() throws Throwable
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
	
	/*Property_Utility plib=new Property_Utility();
	 String URL = plib.getkeyValue("url");
	String USERNAME = plib.getkeyValue("username");
	String PASSWORD = plib.getkeyValue("password");*/
	
	/*FileInputStream fis=new FileInputStream("./src/test/resources/PropertiesFileData.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");*/
	//driver.get(URL);

	//driver.get("http://localhost:8888/ ");
	/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();*/
	
	//LoginPage loginpage=new LoginPage(driver);
	//loginpage.loginToApp(USERNAME,PASSWORD );
	//loginpage.getSubmitBtn().click();
	
	HomePage homepage=new HomePage(driver);
	homepage.getProductLinkText().click();
	
	//driver.findElement(By.linkText("Products")).click();
	ProductCreationpage prd=new ProductCreationpage(driver);
	prd.getProductCreateImage().click();
			
	//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	
	//Random ran=new Random();
	//int RanNum = ran.nextInt(1000);
	
	Java_Utility jlib=new Java_Utility();
	int RanNum = jlib.getRandomNum();
	
	Excel_Utility elib=new Excel_Utility ();
	String productdata = elib.getExcelDataFormatter("Products", 0, 0)+RanNum;
		
	/*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet("Products");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String productdata = cell.getStringCellValue()+RanNum;*/
	
	prd.productNameTextField(productdata);
	//driver.findElement(By.name("productname")).sendKeys(productdata);
	prd.productSaveButton();
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	homepage.getMorelink().click();
	homepage.getCampaignsLinkText().click();
	//driver.findElement(By.linkText("More")).click();
	//driver.findElement(By.linkText("Campaigns")).click();
	
	CampaignCreationPage cam=new CampaignCreationPage(driver);
	cam.getCampaignCreateImage().click();
	//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

	Excel_Utility elib1=new Excel_Utility ();
	String CampData = elib1.getExcelDataFormatter("Campagins", 0, 0)+RanNum;
	
	/*FileInputStream fes1=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
	Workbook book1 = WorkbookFactory.create(fes1);
	Sheet sheet1 = book1.getSheet("Campagins");
	Row row1 = sheet1.getRow(0);
	Cell cell1 = row1.getCell(0);
	String CampData = cell1.getStringCellValue()+RanNum;*/
	
	cam.campaignNameTextField(CampData);
	//driver.findElement(By.name("campaignname")).sendKeys(CampData);
	cam.campaignSaveButton();
	 //driver.findElement(By.xpath("//img[@alt='Select']")).click();
	//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'][1])")).click();
	
 
     wlib.switchwindow(driver,"Products&action" );
    /* Set<String> allId = driver.getWindowHandles();
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
     }*/
     prd.searchTextField(productdata);
    // driver.findElement(By.id("search_txt")).sendKeys(productdata);
     prd.searchButton();
	  //driver.findElement(By.name("search")).click();
	  
	  //dynamic xpath
	  driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
	  
	  wlib.switchwindow(driver, "Campaigns&action");
	 /* Set<String> allId1 = driver.getWindowHandles();//org   //cont  //prd
     Iterator<String> id1 = allId1.iterator();
     
     while(id1.hasNext())
     {
   	  String wid1 = id1.next();//org
   	  driver.switchTo().window(wid1);
   	  String title = driver.getTitle();
   	  
   	  if(title.contains("Campaigns&action"))
   	  {
   		  break;
   	  }
     }*/
	  prd.productSaveButton();
    // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  validationAndVerificationPage1 validate=new validationAndVerificationPage1(driver);
	  validate.campaignValidation(driver, CampData);
    /* String act = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
     if(act.contains(CampData))
     {
     	System.out.println("camp pass");
     }
     else
     {
     	System.out.println("camp fail");
     }*/
	  ValidationAndVerificationPage2 validate1=new ValidationAndVerificationPage2(driver);
	  validate1.productValidation(driver, productdata);
    /* String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
     if(actData.contains(productdata))
     {
     	System.out.println("product Pass");
     }
     else
     {
     	System.out.println("Product fail");
     }*/
     //homepage.getSignoutImg().click();
    // homepage.getSignoutLinkText().click();
   // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
     //driver.findElement(By.linkText("Sign Out")).click();
     
     
     
     

     
   
}
}
