/*
 * @author priya
 */
package whizit.TestHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generiUtilities.BaseClass;
import pomClasses.HomePage;

@Listeners(generiUtilities.ListenerImplementation.class)
public class RedirectToHomePageFromOtherPageUsingLogoTest extends BaseClass{

	@Test
	
	public void redirectToHomePageFromOtherPageUsingLogoTest() throws InterruptedException, IOException
	{
		//Step 1 Open the browser
		//Step 2 Enter the url
		
		//Step 3 Click on any menu option or any link from the home page
		String menuOption = eUtil.readDataFromExcel("HomePageData", 3, 2);
		String headerText = eUtil.readDataFromExcel("HomePageData", 3, 3);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMenuOption(driver,menuOption);
		
		//Step 4 Click on logo
		hp.clickOnLogo();
		
		//Step 5 Validate for home page
		String text = hp.getHomePageTitleText();
		Assert.assertTrue(text.contains(headerText));
		
	}
}
