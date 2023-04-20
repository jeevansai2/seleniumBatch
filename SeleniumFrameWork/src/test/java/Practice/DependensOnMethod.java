package Practice;

import org.testng.annotations.Test;

public class DependensOnMethod 
{
	@Test
public void createContact()
{
		System.out.println("contact created");
}
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modified contact");
	}
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("contact deleted");
	}
}
