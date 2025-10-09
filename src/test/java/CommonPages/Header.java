package CommonPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;

public class Header{
	
	public WebDriver driver;

	public Header(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	// Header elements
	@FindBy(xpath = "//*[@id='hamburger-menu']/span/span")
	public WebElement Menu;

	@FindBy(xpath = "//header/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/span[1]")
	public WebElement Country_DropDown;
	
	
	@FindBy(xpath = "//*[@id=\"5001\"]/span")
	public WebElement Accounts_DropDown;
	
	
	@FindBy(xpath = "(//a/span/img)[1]")
	public WebElement Cargill_Img;	
	
	@FindBy(className = "user-name")
	public WebElement UserName_Link;
	
	@FindBy(id = "edit-profile-page-link")
	public WebElement Editprofile_Link;
	
	@FindBy(id = "notification-preference-page-link")
	public WebElement NotificationPref_Link;
	
	@FindBy(xpath = "//header/div[2]/div/div[1]/div[3]/span/div/div[2]/div/div[3]")
	public WebElement Logout_link;
	
	@FindBy(className = "notification-badge")
	public WebElement Notifications_Icon;

	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	public LeftNav click_Menu() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(Menu));	
		Thread.sleep(10);
		Menu.click();
		return new LeftNav(driver);
		
		
	}
	
	public void click_CountryDropDown() {
		
		Country_DropDown.click();
	}
	
	public void click_AccountsDropdown() {
		Accounts_DropDown.click();
	}
	
	public void click_UserName_Link() {
		UserName_Link.click();
	}
}
