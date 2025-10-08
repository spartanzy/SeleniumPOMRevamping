package TestCases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InMobileModeTest {

	public static void main(String[] args) {

		Map<String, String> MobileEmulate = new HashMap<>();
		MobileEmulate.put("deviceName", "Samsung Galaxy S20 Ultra");
		
		ChromeOptions option = new ChromeOptions();
		
		// for ssl certification isuses
		option.setAcceptInsecureCerts(true);
		// for incognito browser mode
		option.addArguments("Incognito");
		//option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		option.setExperimentalOption("mobileEmulation", MobileEmulate);
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();

	}
	// valid list of device names which can be used in Chrome browser
	/*How to Get the Valid List of Device Names
1. From Chrome DevTools Directly

Open Chrome.

Press F12 → DevTools opens.

Toggle Device Toolbar (Ctrl+Shift+M).

In the device dropdown, you’ll see the list of emulatable devices (e.g., iPhone 14, Pixel 7, Galaxy S5, iPad Mini, etc.).*/
	String[] deviceNames = {
		    "Pixel 7",
		    "Pixel 7 Pro",
		    "Pixel 5",
		    "Pixel 4 XL",
		    "Galaxy S5",
		    "Galaxy S9+",
		    "Galaxy S10",
		    "Galaxy Note 3",
		    "iPhone 14 Pro Max",
		    "iPhone 14",
		    "iPhone 13 Pro",
		    "iPhone 12 Pro Max",
		    "iPhone 11 Pro",
		    "iPhone XR",
		    "iPhone SE",
		    "iPhone 8 Plus",
		    "iPad Air",
		    "iPad Pro",
		    "iPad Mini",
		    "Nexus 5X",
		    "Nexus 6P",
		    "Laptop with HiDPI screen",
		    "Laptop with touch",
		    "Samsung Galaxy Note II",
		    "BlackBerry Z30"
		};

}
