package whizit.TestHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generiUtilities.BaseClass;
import pomClasses.HomePage;
@Listeners(generiUtilities.ListenerImplementation.class)
public class RedirectToHomePageWithLogoTest extends BaseClass{

	@Test
	public void redirectToHomePageWithLogoTest() throws InterruptedException, IOException
	{
		String homePageTitle = eUtil.readDataFromExcel("HomePageData", 1, 2);
		//Step 1 open the browser
		//Step 2 Enter the url
		
		//Step 3 Click on logo
		HomePage hp = new HomePage(driver);
		hp.clickOnLogo();
		
		//Step 4 Validate for home page
		System.out.println(homePageTitle);
		String headerText = hp.getHomePageTitleText();
		Assert.assertTrue(headerText.contains(homePageTitle));
		
				
		
		
	}
}
 