package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonPages.Header;
import DipModulePages.InvoicePage;
import DipModulePages.LoginPage;

public class ExternalInvoicesTest  extends BaseTest{
	
	
	@Test
	public void InvoiceTest() throws InterruptedException  {	
			
	
	LoginPage login = new LoginPage(driver);	
	// create object of one of the Dashboard elements
	WebElement InvoiceslinkinDashBoard = login.loginExternalUser().ViewInvoices_Link;
	wait.until(ExpectedConditions.visibilityOf(InvoiceslinkinDashBoard));
	Header header = new Header(driver);
	InvoicePage invoices =header.click_Menu().clickInvoice();
	WebElement Invoice_Header = invoices.PageHeader;
	wait.until(ExpectedConditions.visibilityOf(Invoice_Header));
	List<String> values = invoices.dropdownvalues();
	for(String val:values) {
		System.out.println(val);
	}
	Assert.assertEquals(values.size(), 6);
	invoices.selectSearchBy("contractNumber");
	invoices.SearchTextField.sendKeys("2100");
	invoices.elementScreenshot(invoices.SearchBy_DropDown);
	WebElement contractnum = invoices.contract_number;
	invoices.pageScreenshot();
	wait.until(ExpectedConditions.visibilityOf(contractnum));
	
	}
}
