package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonPages.Header;
import DipModulePages.InvoicePage;
import DipModulePages.LoginPage;
import DipModulePages.MarketinsightsPage;

public class ExternalMarketLinkTest  extends BaseTest{
	
	
	@Test
	public void InvoiceTest() throws InterruptedException  {	
			
	
	LoginPage login = new LoginPage(driver);	
	// create object of one of the Dashboard elements
	WebElement InvoiceslinkinDashBoard = login.loginExternalUser().ViewInvoices_Link;
	wait.until(ExpectedConditions.visibilityOf(InvoiceslinkinDashBoard));
	Header header = new Header(driver);
	MarketinsightsPage MIP =header.click_Menu().clickMarketLink();
	wait.until(ExpectedConditions.visibilityOf( MIP.circles.get(0)));
	MIP.getGraphValues();
	
	
	}
}
