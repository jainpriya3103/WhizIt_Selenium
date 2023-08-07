package whizit.TestHomePage;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generiUtilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomClasses.HomePage;
@Listeners(generiUtilities.ListenerImplementation.class)
public class Section1AllTechnologiesImageTest extends BaseClass {
	@Test()
	public void section1AllTechnologiesImageTest() throws EncryptedDocumentException, IOException 
	{
		 HomePage hp = new HomePage(driver);
		 Boolean imgSrcExists= false;
		    List<String> imgSrcList = hp.checkAllTechnologyImages(driver,1);
			System.out.println("imgSrcList" +imgSrcList);
			
		Object[][] SrcId = eUtil.readMultipleData("Section1TechImgs");
	
		String value = "";
		for(int row = 1;row<SrcId.length;row++)
		{
			for(int col =0;col<SrcId[row].length;col++)
			{
				value = SrcId[row][col].toString();
				 //System.out.println("value"+value);
			}
			
			imgSrcExists = imgSrcList.contains(value);
			if (imgSrcExists) {
				System.out.println("img exists" );
				
			} else {

				System.out.println("img not exist" +value);
				
			}
		}
	   
		   
		
	}
	
	
}
