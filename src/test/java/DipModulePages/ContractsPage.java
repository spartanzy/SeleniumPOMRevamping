package DipModulePages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class ContractsPage extends BasePage{

	public ContractsPage(WebDriver driver) {
		super(driver);


	}
	
	@FindBy(xpath = "//h1")
	public WebElement PageHeader;
	
	@FindBy(id = "global-search")
	public WebElement SearchTextField;
	
	@FindBy(id = "commodity-filter")
	public WebElement SearchBy_DropDown;
	
	@FindBy(css = "#commodity-filter option")
	public List<WebElement> DropdownValues;
	
	/*The difference is that . looks at all the text inside the element,
	 *  while text() only checks the first text node.
	 *   Many times, UI frameworks add invisible nodes or break the text,	 * 
	 *  so . is safer for partial text matching.*/
	@FindBy(xpath = "//p[contains(.,'2100')][1]")
	public WebElement contract_number;
	
	@FindBy(className = "clear-btn")
	public WebElement ClearAll_Button;
	
	
	
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
