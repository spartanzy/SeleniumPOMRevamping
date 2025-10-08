package DipModulePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;
import Utility.configManager;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);


	}
	String username = configManager.getUsername();
    String password = configManager.getPassword();
	
	@FindBy(id = "okta-signin-username")
	public WebElement Login_field;
	
	@FindBy(id = "okta-signin-password")
	public WebElement Password_field;
	
	@FindBy(id = "okta-signin-submit")
	public WebElement Login_Button;
	
	@FindBy(xpath = "//a[text()='Sign In As Employee']")
	public WebElement EmployeeSignIn_Link;
	
	@FindBy(id = "truste-consent-button")
	public WebElement AcceptCookies_Button;
	
	public ExternalDashboardPage loginExternalUser() {
		
		Login_field.sendKeys(username);
		Password_field.sendKeys(password);
		AcceptCookies_Button.click();
		Login_Button.click();
		
		return new ExternalDashboardPage(driver);
		
	}

}
