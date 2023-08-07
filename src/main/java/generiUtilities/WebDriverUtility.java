package generiUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * This class contains web diver related utilities
 * 
 * @author Priya Jain
 *
 */
public class WebDriverUtility {
	/**
	 * This method is created to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is created to minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will wait for page to load for 10 seconds
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method will handle drop down based on index value
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * This method will handle drop down based on value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method will handle drop down based on visible text
	 * 
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	/**
	 * This method will perform mouse hover action on particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click action any where on the web page
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will perform right click action on particular element
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will perform drag and drop from sourceElement to targetElement
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDropAction(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(sourceElement, targetElement).perform();
	}

	/**
	 * This method will drag and drop from sourceElement to target element offset
	 * 
	 * @param driver
	 * @param sourceElement
	 * @param x
	 * @param y
	 */
	public void dragAndDropAction(WebDriver driver, WebElement sourceElement, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(sourceElement, x, y).perform();
	}

	/**
	 * This method will perform double click any where on the web page
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * This method will perform double click on particular web element
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will accept the alert pop-up
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}

	/**
	 * This method will dismiss the alert pop-up
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}

	/**
	 * This method will take screenshot and return absolute path
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShot\\" + screenshotName + ".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); // used for extent reports

	}

	public void switchToWindow(WebDriver driver, String partialWondowTitle) {
		// capture all window ids
		Set<String> windowIds = driver.getWindowHandles();

		// navigate through all window
		for (String winId : windowIds) {
			// switch to child window
			driver.switchTo().window(winId);
			// get window title
			String winTitle = driver.switchTo().window(winId).getTitle();
			if (winTitle.contains(partialWondowTitle)) {
				break;
			}

		}
	}

}
