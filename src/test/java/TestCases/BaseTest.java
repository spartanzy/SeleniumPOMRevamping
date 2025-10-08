package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import Utilities.ProjectListener;

public class BaseTest {
	
	public WebDriver webdriver;
	long waitTime = 30;
	public static WebDriverWait wait;
	WebDriverListener listener = new ProjectListener();			
	public WebDriver driver;
	
	
	public BaseTest() {
		// ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless=new"); // Modern headless mode in Chrome
//	        options.addArguments("--window-size=1920,1080"); // Optional: Set screen size
		webdriver = new ChromeDriver();
		driver = new EventFiringDecorator<WebDriver>(listener).decorate(webdriver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		driver.manage().window().maximize();
		
		driver.get("https://stage.mycargill.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		
	}
	
	@BeforeSuite
	public void BeforeSuite() {
		
		
	}
		
	@AfterTest
	public void teardown() {
		
		driver.close();
		if(driver!=null)
		driver.quit();
	}

}
