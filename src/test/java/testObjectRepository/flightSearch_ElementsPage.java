package testObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flightSearch_ElementsPage {
	
	
	public static WebElement element = null;
	public static WebDriver driver;
	
	
	public static WebElement origin(WebDriver driver)
	{
		element =driver.findElement(By.id("stationFrom"));
    	return element;
	}
	
	public static List<WebElement> from_places(WebDriver driver)
	{
		List<WebElement> placeFr = driver.findElements(By.xpath("//ul[@id='ui-id-1']//div"));
		return placeFr;
	}
	
	public static WebElement destination(WebDriver driver)
	{
		element= driver.findElement(By.id("stationTo"));
		return element;	
	}
	
	public static List<WebElement> to_places(WebDriver driver)
	{
		List<WebElement> placeTo = driver.findElements(By.xpath("//ul[@id='ui-id-2']//div"));
		return placeTo;
	}
	
	public static WebElement Date(WebDriver driver)
	{
		element= driver.findElement(By.id("originDate"));
		return element;	
	}
	
	public static WebElement today(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//span[contains(@class, 'act active-red')]"));
		return element;	
	}
	
	public static WebElement ticket(WebDriver driver)
	{
		element= driver.findElement(By.id("noOfpaxEtc"));
		return element;	
	}
	
	public static WebElement travelClass(WebDriver driver)
	{
		element= driver.findElement(By.id("travelClass"));
		return element;	
	}
	
	public static WebElement search(WebDriver driver)
	{
		element= driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		return element;	
	}
	
	public static WebElement act_fr_city(WebDriver driver)
	{
		element= driver.findElement(By.name("From"));
		return element;	
	}
	
	public static WebElement act_to_city(WebDriver driver)
	{
		element= driver.findElement(By.name("To"));
		return element;	
	}
	
	public static WebElement act_date(WebDriver driver)
	{
		element= driver.findElement(By.id("originDate"));
		return element;	
	}
	
	
	public static List<WebElement> FlightName(WebDriver driver)
	{
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='right-searchbarbtm-in']//div[2]//b"));
		return name;
	}
	
	
	public static List<WebElement> FlightNumber(WebDriver driver)
	{
		List<WebElement> number = driver.findElements(By.xpath("//div[@class='right-searchbarbtm-in']//div/div[2]//span"));
		return number;
	}
	
	public static List<WebElement> no_of_flights(WebDriver driver)
	{
		List<WebElement> flights = driver.findElements(By.xpath("//div[@class='right-searchbarbtm-in']"));
		return flights;
	}
}