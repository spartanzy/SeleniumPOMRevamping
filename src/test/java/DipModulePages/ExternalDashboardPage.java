package DipModulePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class ExternalDashboardPage extends BasePage{
	
	
	
	public ExternalDashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(id = "view-contracts")
	public WebElement ViewContracts_Link;
	
	@FindBy(id = "paymentsLink")
	public WebElement ViewPayments_Link;

	
	@FindBy(id = "invoicesLink")
	public WebElement ViewInvoices_Link;


}
