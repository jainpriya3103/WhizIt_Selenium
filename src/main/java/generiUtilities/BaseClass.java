package generiUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import generiUtilities.ExcelFileUtility;
import generiUtilities.PropertyFileUtility;
import generiUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all basic configuration annotations of TestNG
 * @author Priya Jain
 *
 */
public class BaseClass {
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sDriver ; 
	@BeforeSuite()
	public void bsConfig()
	{
		System.out.println("====== DB Connection SuccessFull ======");
	}
	
	@BeforeClass() // or we can write alwaysRun = true instead of writing group
	public void bcConfig() throws IOException
	{
  
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "====== Browser Launched ======");
		} 
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "====== Browser Launched ======");
		} 
		else 
		{
			System.out.println("====== Invalid Browser Name ======");
		}

		sDriver = driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	

	
	@AfterClass()

	public void acConfig()
	{
		driver.quit();
		System.out.println("====== Browser Closed ======");
	}
	
	
	@AfterSuite()
	public void asConfig()
	{
		System.out.println("====== DB Connection Closed ======");
	}

}
