package userDefinedLibraries;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	
	public static WebDriver driver;	
	public static String baseUrl = "https://www.air.irctc.co.in/";
	public static String browsertype;
	public static WebDriver driverInstantiate(String browser) {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("1")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("2")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);		
		return driver;
	}
	public static void driverTearDown() {
		driver.quit();
	}

	
}