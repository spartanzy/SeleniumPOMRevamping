package BasePage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonPages.Header;
import CommonPages.LeftNav;

public class BasePage {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Header header;
	public LeftNav leftNav;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		leftNav = new LeftNav(driver);
		header = new Header(driver);
		
		
	}
	
	public boolean isElementPresent(By by) {
		
		try {
		driver.findElement(by);
		return true;
		}catch(Throwable t) {
			return false;
		}
	}
	
	public boolean isElementPresent(List<WebElement> elements) {
	
	if (elements.size()>0)
	return true;
	return false;
		
		
	}
	
	public void elementScreenshot(WebElement element) {
		
		// Capture the screenshot of the element
	    File file = element.getScreenshotAs(OutputType.FILE);
	    
	    // Try to get a more meaningful name for the element, you can use any attribute like ID, Class Name, etc.
	    String nameofElement = getElementName(element);
	    
	    // Ensure the folder exists
	    File screenshotDir = new File("./screenshots");
	    if (!screenshotDir.exists()) {
	        screenshotDir.mkdir(); // Create the folder if it does not exist
	    }
	    
	    // Save the screenshot with the name of the element
	    try {
	        FileUtils.copyFile(file, new File(screenshotDir + "/" + nameofElement + ".jpg"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private String getElementName(WebElement element) {
	    // Try extracting a meaningful name from the element
	    // Example 1: Try to get element's ID or some unique attribute
	    String elementId = element.getAttribute("id");
	    if (elementId != null && !elementId.isEmpty()) {
	        return elementId;
	    }

	    // Example 2: If no ID, use the tag name or class name
	    String tagName = element.getTagName();
	    String className = element.getAttribute("class");

	    if (tagName != null && !tagName.isEmpty()) {
	        return tagName + (className != null && !className.isEmpty() ? "_" + className : "");
	    }

	    // If no ID or tag name, use a fallback
	    return "element_" + System.currentTimeMillis();
	}
	
	public void pageScreenshot()  {
		
				
		File page = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(page, new File("./screenshotDir/" +System.currentTimeMillis() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
