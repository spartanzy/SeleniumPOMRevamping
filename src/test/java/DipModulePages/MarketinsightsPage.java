package DipModulePages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;

public class MarketinsightsPage extends BasePage{

	public MarketinsightsPage(WebDriver driver) {
		super(driver);


	}
	
	@FindBy(xpath = "//h1")
	public WebElement PageHeader;
	
	@FindBy(xpath = "//*[local-name()='strong']")
	public WebElement Xaxis;
	
	@FindBy(xpath = "//*[local-name()='strong'][2]")
	public WebElement Yaxis;
	
	@FindBy(xpath = "(//*[name()='svg' and @role='img'])//*[local-name()='circle']")
	public List<WebElement> circles;	
	
	@FindBy(xpath = "//*[name()='svg' and @role='img']")
	public WebElement graph;
	
	Actions action = new Actions(driver);
	
	public List<String> getGraphValues(){
		
		action.moveToElement(graph).perform();;
		
		List<String> values = new ArrayList<>();
		for(WebElement e: circles) {
			try {
			action.moveToElement(e).perform();
			
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print("The value of x is "+Xaxis.getText() + ", The value of y is "+Yaxis.getText());			
			System.out.println();
			
		}
		return values;
	}
	
	
	
	
	
	
 	
	

}
