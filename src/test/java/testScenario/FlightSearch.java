package testScenario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import testObjectRepository.flightSearch_ElementsPage;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ScreenShot;

public class FlightSearch extends DriverSetup {
	
	public static String browser;
	public static List<WebElement> origins,destinations,flightName,flightNumber,flights;
	public static WebDriver driver;
	public static WebElement from,to,date,Today,type,travelClass,Search;
	
	//launch Browser
	public static void launchBrowser(String browser)
    {
	 	//Instantiate driver 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the browser type(To open in Chrome give '1' and to open in Edge give '2')");
		String browserType = sc.nextLine();
    	driver=DriverSetup.driverInstantiate(browserType); 
    	
    }
    public void openURL()
    {
		
		//Open the URL 
    	driver.get(baseUrl);
    	
    }
	
	public static void checkURL()
	{
        String act_url = driver.getCurrentUrl();
		
		if(act_url.equals(baseUrl)) {
			System.out.println("Opened URL is correct");
		}
		else
		{
			System.out.println("Opened URL is wrong");
		}
		
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Flight_Search_Page");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void setOrigin(String origin) throws InterruptedException
	{
		
		
		//From
		WebElement from = flightSearch_ElementsPage.origin(driver);
		from.sendKeys(origin);
		//Thread.sleep(5000);
	
		List<WebElement> origins = flightSearch_ElementsPage.from_places(driver);
				
		for(int i=0; i<origins.size(); i++)
		{
			
			String chosing_op = origins.get(i).getText();
					
			if(chosing_op.contains("HYD"))
			{
				origins.get(i).click();
			}
		}
		
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Selecting_Origin");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void setDestination(String Destination)
	{
		
		//To
		WebElement to =  flightSearch_ElementsPage.destination(driver) ;
		to.sendKeys(Destination);
								
		List<WebElement> destinations = flightSearch_ElementsPage.to_places(driver);
				
		for(int j=0; j<destinations.size(); j++)
		{
			String chosing_to = destinations.get(j).getText();
					
			if(chosing_to.contains("Pune"))
			{
				destinations.get(j).click();
			}
		}
		
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Selecting_Destination");
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		
	}
	
	
	public static void setDate()
	{
		
		WebElement date = flightSearch_ElementsPage.Date(driver);
		date.click();
		
		WebElement Today = flightSearch_ElementsPage.today(driver);
		Today.click();
		
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Selecting_Date");
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	
	public static void setClass()
	{
		
		WebElement type = flightSearch_ElementsPage.ticket(driver);
		type.click();
		
		WebElement travelClass = flightSearch_ElementsPage.travelClass(driver);
		
		Select Tclass = new Select(travelClass);
		Tclass.selectByVisibleText("Business");
		
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Selecting_Travel_Class");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void search()
	{
		WebElement Search = flightSearch_ElementsPage.search(driver);
		Search.click();
		
		try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Search_Inputs");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void verify()
	{
		//Origin
		String exp_from_city = "Hyderabad (HYD)";
		String act_from_city = flightSearch_ElementsPage.act_fr_city(driver).getAttribute("value");
		
		//Destination
		String exp_to_city = "Pune (PNQ)";
		String act_to_city =  flightSearch_ElementsPage.act_to_city(driver).getAttribute("value");
		
		//Date		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate currentDate = LocalDate.now();
		String exp_Date = currentDate.format(formatter);
		String act_Date = flightSearch_ElementsPage.act_date(driver).getAttribute("value");
		
		if(exp_from_city.equals(act_from_city)  || exp_to_city.equals(act_to_city) || exp_Date.equals(act_Date))
		{
			System.out.println("Searched flights are correct for given city and date");
		}
		else
		{
			System.out.println("Searched flights are not correct for given city and date");
		}	
		
	}
	
	public static void flight_name()
	{
		
        List<WebElement> flightName = flightSearch_ElementsPage.FlightName(driver);
        List<WebElement> flightNumber = flightSearch_ElementsPage.FlightNumber(driver);
		
		for(int i=0 ;i<flightName.size(); i++)
		{
		    System.out.println("Name of the flight-> " +flightName.get(i).getText()+" " +flightNumber.get(i).getText() );
		    
		}
		
	}
	
	
	public static int no_of_flights()
	{
        List<WebElement> flights = flightSearch_ElementsPage.no_of_flights(driver);
		
		//System.out.println("Number of flights avaiable " +flights.size());
        
        try {
			// Take screen shot
			ScreenShot.screenShotTC(driver,"Available_Flights");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return flights.size();
        
        
	}
	
	public static void closeBrowser()
	{
		DriverSetup.driverTearDown();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		launchBrowser(browser);
		checkURL();
	    setOrigin("Hyd");
	    setDestination("Pune");
	    setDate();
	    setClass();
	    search();
	    verify();
	    flight_name();
	    System.out.println("Number of flights available are "+ no_of_flights());
	    closeBrowser();
	    
	    
		
		

	}

}