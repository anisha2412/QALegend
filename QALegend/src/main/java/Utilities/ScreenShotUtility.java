package Utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class ScreenShotUtility {
	
	public void captureFailedScreenShots(WebDriver driver, String testcasename) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot)driver;                                      // webdriver conversion to take ss
		File screenshot = scrShot.getScreenshotAs(OutputType.FILE);                             // stored ss in a temp file
		File f1 = new File(System.getProperty("user.dir")+ "\\output-screenshots");             // store to permanent storage 
		if(!f1.exists()) 
		{
			f1.mkdir();
		}
		File final_destination = new File(System.getProperty("user.dir")+ "\\output-screenshots\\" + testcasename + ".png");
		Files.copy(screenshot, final_destination);		
	}

}
