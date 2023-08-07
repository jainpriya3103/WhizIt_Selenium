/*
 * @author priya jain
 */
package whizit.TestHomePage;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generiUtilities.BaseClass;
import pomClasses.HomePage;

@Listeners(generiUtilities.ListenerImplementation.class)
public class CheckLogoExistOrNotTest extends BaseClass{
	
	@Test
	
	public void checkLogoExistOrNotTest()
	
	{
	//Step 1 Open the browser
	//Step 2 Launch the url
	//Step 3 Verify the logo exist or not
	HomePage hp = new HomePage(driver);
	Boolean logo = hp.checkLogo(driver);
	
	if (logo) {
		Reporter.log("Logo exists" ,true);
        System.out.println("Logo present");
     } 
	else {
    	 Reporter.log("Logo does not exist" ,true);
        System.out.println("Logo not present");
     }

}
}