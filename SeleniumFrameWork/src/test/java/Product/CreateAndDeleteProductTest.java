package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_utility;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductCreationPage1;
import POM.ProductCreationpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAndDeleteProductTest extends BaseClass
{
	@Test
public void CreateAndDeleteProductTest() throws Throwable
//public static void main(String[] args) throws Throwable
{
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
	
	ProductCreationPage1 prdt=new ProductCreationPage1(driver);
	//prdt.productBackButton(driver);
	//driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[.='"+productdata+"']/../preceding-sibling::td/input")).click();
	prdt.deleteProduct();
	wlib.switchToAlertAndAccpect(driver);
	prdt.verification(driver, productdata);
	//homepage.getSignoutImg().click();
	//homepage.getSignoutLinkText().click();
}
}