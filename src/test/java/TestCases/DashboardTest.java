package TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import CommonPages.Header;
import DipModulePages.ContractsPage;
import DipModulePages.ExternalDashboardPage;
import DipModulePages.LoginPage;

public class DashboardTest extends BaseTest {

	Header header;
	ExternalDashboardPage Home;
	@Test(priority =1)
	public void DashboardLinksTest() throws InterruptedException  {


		
		LoginPage login = new LoginPage(driver);	
		// create object of one of the Dashboard elements
		WebElement ele =    login.loginExternalUser().ViewContracts_Link;
		wait.until(ExpectedConditions.visibilityOf(ele));
		header = new Header(driver);
		
		/* Validation of all links in header */		
		header.click_AccountsDropdown();
		header.click_CountryDropDown();
		header.click_UserName_Link();
		header.click_Menu();
		header.click_Menu().click_Dashboard();
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	
	@Test (priority =2)
	public void NavigatetoContractsTest() throws InterruptedException  {


		
		Home = new ExternalDashboardPage(driver);	
		// create object of one of the Dashboard elements
		WebElement ele =    Home.ViewContracts_Link;
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		ContractsPage contracts = new ContractsPage(driver);
		WebElement contractnumber = contracts.contract_number;
		wait.until(ExpectedConditions.visibilityOf(contractnumber));		
		
	}
	
	@Test (priority =3)
	public void NavigattoDashboardTest() {
		
		header.Cargill_Img.click();
		WebElement invoices_link= Home.ViewInvoices_Link;
		wait.until(ExpectedConditions.visibilityOf(invoices_link));		
	}

}
