package TestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonPages.Header;
import DipModulePages.ContractsPage;
import DipModulePages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class ExternalContractsTest  extends BaseTest{
	
	@Feature("Contracts listing")
	@Test
	//allure tags provided below for reporting
	@Description("search Contract Number by partial text")
	@Severity(SeverityLevel.CRITICAL)
	@Story("External user logins to check if he is able to navigate from Dashboard to contracts page")
	@Story("And also perform contracts search")
	public void ContractTest() throws InterruptedException  {
	
		
			
	
	LoginPage login = new LoginPage(driver);	
	// create object of one of the Dashboard elements
	WebElement ContractslinkinDashBoard = login.loginExternalUser().ViewContracts_Link;
	wait.until(ExpectedConditions.visibilityOf(ContractslinkinDashBoard));
	Header header = new Header(driver);
	ContractsPage contracts =header.click_Menu().click_Contracts();
	WebElement Contract_Header = contracts.PageHeader;
	wait.until(ExpectedConditions.visibilityOf(Contract_Header));
	List<String> values = contracts.dropdownvalues();
	for(String val:values) {
		System.out.println(val);
	}
	Assert.assertEquals(values.size(), 3);	
	contracts.ClearAll_Button.click();
	contracts.selectSearchBy(1);
	contracts.SearchTextField.sendKeys("2100");
	WebElement contractnum = contracts.contract_number;
	wait.until(ExpectedConditions.visibilityOf(contractnum));
	driver.quit();
	}
}
