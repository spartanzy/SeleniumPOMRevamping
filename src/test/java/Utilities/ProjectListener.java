package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ProjectListener implements WebDriverListener, ITestListener{
	
	public static ExtentTest test;
	public static ExtentReports Extent;
	public void afterClick(WebElement element) {
		
		System.out.println("Clicked on element "+element);
		test.log(Status.INFO, "Clicked on Element "+element);
	}
	
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		
		if (result.getText()!="")
		test.log(Status.INFO, " Finding Element using locator"+locator + "was \"" + result.getText());
		test.log(Status.INFO, " Finding Element using locator"+locator + "was " + result.getTagName());
	}
	
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		
		test.log(Status.INFO, "Value entered in text field "+element.getText() + " was " + keysToSend);
	}
	
	public void afterMaximize(WebDriver.Window window) {
		
		System.out.println("Window is maximized for execution " + window);
	}
	
	public void onStart(ITestContext context) {
	    
		Extent = ExtendReporter.generateExtendReport();
		
		
		
	  }
	
	public void onTestStart(ITestResult result) {
			
			test = Extent.createTest(result.getTestClass().getTestName()+ ": TestCase: "+result.getMethod().getMethodName());
		
	  }
	
	public void onTestFailure(ITestResult result) {
			String MethodName = result.getMethod().getMethodName();
			if(result.getStatus() == ITestResult.FAILURE ) {			
				String logtext = "<b>"+ "TestCase : - "+MethodName.toUpperCase() +" Failed" +"</b>";
				Markup m = MarkupHelper.createLabel(logtext, ExtentColor.RED);
				test.fail(m);
				
			}else if(result.getStatus() == ITestResult.SKIP ) {
				String logtext = "<b>"+ "TestCase : - "+MethodName.toUpperCase() +" Skipped" +"</b>";
				Markup m = MarkupHelper.createLabel(logtext, ExtentColor.AMBER);
				test.skip(m);
				
			}else if(result.getStatus() == ITestResult.SUCCESS ) {
				String logtext = "<b>"+ "TestCase : - "+MethodName.toUpperCase() +" Passed" +"</b>";
				Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
				test.pass(m);
				
			}		
		
	}
	
	public void onFinish(ITestContext context) {
	    
		if (Extent!=null)
			Extent.flush();
	  }
	
}
