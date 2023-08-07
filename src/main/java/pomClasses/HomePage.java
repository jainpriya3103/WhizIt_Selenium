package pomClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import generiUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
@FindBy(xpath = "//img[@alt='Logo']")
private WebElement logo;

@FindBy(xpath = "//h3[contains(text(),'Whiz IT')]")
private WebElement homePageTitle;

@FindBys(@FindBy(xpath = "//img[@src='https://whizitglobal.com/wp-content/uploads/2022/10/Paython-1024x513.png']/ancestor::section/descendant::img"))
private List<WebElement> allTechImagesSection1;

@FindBys(@FindBy(xpath = "//img[@src='https://whizitglobal.com/wp-content/uploads/2022/10/logo-tech-23-1024x513.png']/ancestor::section/descendant::img"))
private List<WebElement>allTechImagesSection2;

public HomePage (WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
	}

public WebElement getHomePageTitle() {
	return homePageTitle;
}


public WebElement getLogo() {
	return logo;
}

public List<WebElement> getAllTechImagesSection1() {
	return allTechImagesSection1;
}

public List<WebElement> getAllTechImagesSection2() {
	return allTechImagesSection2;
}

public void clickOnLogo()
{
	logo.click();
	System.out.println("logo clicked");
}

public String getHomePageTitleText()
{
	return homePageTitle.getText();
}

public void clickOnMenuOption(WebDriver driver,String menuOption)
{
	System.out.println("pom class menu" +menuOption);
	driver.findElement(By.xpath("//span[.='"+menuOption+"']")).click();
}

public boolean checkLogo(WebDriver driver)
{
	WebElement logoImg = logo;
	 // Javascript executor to check image
    Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", logoImg);
    return p;
}

public List<String> checkAllTechnologyImages(WebDriver driver,int value)
{
	List<WebElement> allTechImgs = new ArrayList<WebElement>()  ;
	switch(value)
	{
	case 1:
		allTechImgs.addAll(allTechImagesSection1);
		break;
	case 2:
		allTechImgs.addAll(allTechImagesSection2);
		break;
	}
	
	 List<String> imgSrc = new ArrayList<String>()  ;
	
	for(WebElement techImage :allTechImgs)
	{
	    //imgExist = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img);
		imgSrc.add(techImage.getAttribute("src"));
	}
	return imgSrc;
	
	}


}
