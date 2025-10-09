package DipModulePages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class ShippingPageOpen extends BasePage{

	public ShippingPageOpen(WebDriver driver) {
		super(driver);


	}
	
	@FindBy(xpath = "//h1")
	public WebElement PageHeader;
	
	@FindBy(id = "global-search")
	public WebElement SearchTextField;
	
	@FindBy(id = "search-filter")
	public WebElement SearchBy_DropDown;
	
	//appears to be svg element, might not be interactable with selenium
	@FindBy(css = "#search-filter option")
	public List<WebElement> DropdownValues;	
	
	@FindBy(className = "clear-btn")
	public List<WebElement> ClearButton;
	
	@FindBy(xpath = "//div[@class='label eta b' and contains(.,'Contract')]")
	public WebElement contract_card;
	
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
