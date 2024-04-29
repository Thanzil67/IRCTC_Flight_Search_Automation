package userDefinedLibraries;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	
	public static String filepath =".\\ScreenShots\\";
	public static void screenShotTC(WebDriver scdriver,String fileName)throws IOException{
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
		File src=((TakesScreenshot)scdriver).getScreenshotAs(OutputType.FILE);       
		try
		{  // now copy the  screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File(filepath+fileName+"_"+dateFormat.format(date)+".png"));
			
        }catch (IOException e)      
		{
        	System.out.println(e.getMessage());      
		}
	}
}