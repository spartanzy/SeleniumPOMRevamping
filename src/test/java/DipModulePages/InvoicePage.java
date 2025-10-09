package DipModulePages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class InvoicePage extends BasePage{

	public InvoicePage(WebDriver driver) {
		super(driver);


	}
	
	@FindBy(xpath = "//h1")
	public WebElement PageHeader;
	
	@FindBy(id = "global-search")
	public WebElement SearchTextField;
	
	@FindBy(id = "search-filter-selectBox")
	public WebElement SearchBy_DropDown;
	
	@FindBy(css = "#search-filter-selectBox option")
	public List<WebElement> DropdownValues;	
	
	@FindBy(css = "#Invoice-clear-all")
	public List<WebElement> ClearButton;
	
	@FindBy(xpath = "//span[contains(.,'2100')][1]")
	public WebElement contract_number;
	
	public List<String> dropdownvalues(){
		
		List<String> values = new ArrayList<>();
		for(WebElement e: DropdownValues) {
			
			values.add(e.getText());
		}
		return values;
	}
	
	public void selectSearchBy(String dropdownvalues) {
		
		Select select = new Select(SearchBy_DropDown);
		select.selectByValue(dropdownvalues);
	}
	
	public void selectSearchBy(int index) {
		
		Select select = new Select(SearchBy_DropDown);
		select.selectByIndex(index);
	}
	
	
 	
	

}
