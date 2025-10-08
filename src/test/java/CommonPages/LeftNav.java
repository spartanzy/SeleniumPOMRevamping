package CommonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DipModulePages.ContractsPage;
import DipModulePages.ExternalDashboardPage;
import DipModulePages.InvoicePage;
import DipModulePages.MarketinsightsPage;
import DipModulePages.ShippingPageOpen;

public class LeftNav {
	
	public WebDriver driver;
	
	public LeftNav(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}





	@FindBy(xpath = "//*[@id=\"1001\"]/a/span")
	public WebElement Dashboard_link;

	@FindBy(xpath = "//*[@id=\"1002\"]/a/span")
	public WebElement Contract_link;
	
	@FindBy(xpath = "//*[@id=\"1004\"]/a/span")
	public WebElement Invoices_link;

	@FindBy(xpath = "//*[@id=\"1003\"]/a/span")
	public WebElement Shippings_link;
	
	@FindBy(xpath = "//*[@id=\"1011\"]/a")
	public WebElement MarketInsights_link;
	
	
	


	public ExternalDashboardPage click_Dashboard() {
		
		Dashboard_link.click();
		return new ExternalDashboardPage(driver);
	}





	public ContractsPage click_Contracts() {

		Contract_link.click();
		return new ContractsPage(driver);
		
	}





	public InvoicePage clickInvoice() {

		Invoices_link.click();
		return new InvoicePage(driver);
	}
	
	public ShippingPageOpen clickShipping() {

		Shippings_link.click();
		return new ShippingPageOpen(driver);
	}





	public MarketinsightsPage clickMarketLink() {
		
		MarketInsights_link.click();
		
		return new MarketinsightsPage(driver);
	}

}
