package generiUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * * This class consists of generic methods related to property file
 * 
 * @author Priya Jain
 * @throws IOException
 */

public class PropertyFileUtility {
	/**
	 * * This method will read data from property file and return value to caller
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstantUtility.popertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
