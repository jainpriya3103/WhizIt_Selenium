package whizit.log4jpractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import generiUtilities.BaseClass;
import pomClasses.HomePage;

public class Log4jPracticeTest extends BaseClass{
	
	Logger log  = Logger.getLogger(Log4jPracticeTest.class);
	@Test
	
	public void checkLogoExistOrNotTest()
	
	{
	//Step 1 Open the browser
	//Step 2 Launch the url
	//Step 3 Verify the logo exist or not
	HomePage hp = new HomePage(driver);
	log.info("**************object for home page****************");//info
	log.warn("**************warning**************");//warning
	log.fatal("**************fatal**************");//fatal
	log.error("error");
	Boolean logo = hp.checkLogo(driver);
	Assert.assertTrue(logo, "Logo not present");
	}
	@Test
	public void demo()
	{
		System.out.println("demo executed");
		boolean b = true;
		Assert.assertTrue(b);
	}

}
