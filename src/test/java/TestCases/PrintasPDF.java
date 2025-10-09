package TestCases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PrintasPDF {

	public static void main(String[] args) throws IOException, InterruptedException {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("-headless");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://stage.mycargill.com");
		Thread.sleep(10000);
		
		Pdf pdf = driver.print(new PrintOptions());
		
		Files.write(Paths.get("./selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		
		

	}

}
