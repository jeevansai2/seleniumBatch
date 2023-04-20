package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample
{
	@Test(dataProvider = "dataProvider")
public void bookTickets(String src,String des)
{
		System.out.println("Book tickets from"+src+ "to" +des);

}
@DataProvider
public Object[][]dataProvider()
{
	Object[][] objarr=new Object[3][2];
	
	objarr[0][0]="Banglore";
	objarr[0][1]="Goa";
	
	objarr[1][0]="Banglore";
	objarr[1][1]="Mysore";
	
	objarr[2][0]="Banglore";
	objarr[2][1]="Hyd";
	
	return objarr;
}
}