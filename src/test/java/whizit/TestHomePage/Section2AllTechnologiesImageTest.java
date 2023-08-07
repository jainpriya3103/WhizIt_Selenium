package whizit.TestHomePage;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generiUtilities.BaseClass;

import pomClasses.HomePage;
@Listeners(generiUtilities.ListenerImplementation.class)
public class Section2AllTechnologiesImageTest extends BaseClass {
	@Test()
	public void section2AllTechnologiesImageTest() throws EncryptedDocumentException, IOException 
	{
		 HomePage hp = new HomePage(driver);
		 Boolean imgSrcExists= false;
		    List<String> imgSrcList2 = hp.checkAllTechnologyImages(driver,2);
			System.out.println("imgSrcList" +imgSrcList2);
			
		Object[][] SrcId = eUtil.readMultipleData("Section2TechImgs");
	
		String value = "";
		for(int row = 1;row<SrcId.length;row++)
		{
			for(int col =0;col<SrcId[row].length;col++)
			{
				value = SrcId[row][col].toString();
				 System.out.println("value"+value);
			}
			
			imgSrcExists = imgSrcList2.contains(value);
			if (imgSrcExists) {
				System.out.println("img exists" );
				
			} else {

				System.out.println("img not exist" +value);
				
			}
		}
	   
		   
		
	}}
	
	


