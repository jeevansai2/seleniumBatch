package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility 
{
	/**
	 * This method is used to Launch the Application
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author jeevanravi
	 */
 public String getkeyValue(String key) throws Throwable
 {
	 FileInputStream fis=new FileInputStream("./src/test/resources/PropertiesFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
 }
}
