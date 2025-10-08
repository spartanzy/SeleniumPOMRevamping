package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReporter {
	
	
	public static ExtentSparkReporter sparkReport; //create HTML file and add configuration
	
	public static ExtentReports extent; //Attaching reporter, creating test cases and other system config.
	
	public static ExtentTest test; // maintaining test cases, adding logs status pass/fail/skip
	
	
	public static ExtentReports generateExtendReport() {
		
		String timestamp = Long.toString(System.currentTimeMillis());
		String FilePath = "Spark//Reports//"+timestamp+".html";
		sparkReport = new ExtentSparkReporter(FilePath);
		sparkReport.config().setEncoding("utf-8");
		sparkReport.config().setReportName("Sanity Test"+timestamp);
		sparkReport.config().setDocumentTitle("Project DIP Sanity Report");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Author", "Tanz");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Build", "Stage");
		
		return extent;
		
	}
	
}
