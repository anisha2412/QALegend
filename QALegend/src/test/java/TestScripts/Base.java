package TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import Constants.Constants;
import PageClasses.QALegendAnnouncementPage;
import PageClasses.QALegendClientsPage;
import PageClasses.QALegendEventPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendItemPage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendNotePage;
import PageClasses.QALegendProjectsPage;

public class Base {
	
	public WebDriver driver;
	public Properties properties;                 // object for handling pptys file
	public FileInputStream fis;                   // for handling file opertions in ppty file
	
	QALegendLoginPage loginpage;                  // obj of each pages
	QALegendHomePage homepage;
	QALegendItemPage itemspage;
	QALegendEventPage eventpage;
	QALegendClientsPage clientpage;
	QALegendProjectsPage  projectpage;
	QALegendNotePage notepage;
	QALegendAnnouncementPage  announcementPage;
	
	@BeforeMethod(alwaysRun = true)                       // to always run this method before testcases
	@Parameters({"browser"})
	public void browserinitailzation(String browserName) throws Exception 
	{		
		properties = new Properties();                    // initalization
		fis = new FileInputStream(Constants.CONFIGFILE);  // classname.varname [to acces static var] | ppty file path
		properties.load(fis);                             // load congfig file to read
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();			
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();			
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();			
		}
		else {
			throw new Exception("Invalid Browser Name Exception!!");
		}
		driver.get(properties.getProperty("URL"));                            // application url
		driver.manage().window().maximize();                                  // window maximise  
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    // implict wait
 	
		loginpage = new QALegendLoginPage(driver);                            // page obj initalizatn | always initalize last other wise nullPointerExp error occur
		homepage = new QALegendHomePage(driver);
		itemspage = new QALegendItemPage(driver);
		eventpage = new QALegendEventPage(driver);
		clientpage = new QALegendClientsPage(driver);
		projectpage = new QALegendProjectsPage(driver);
		notepage = new QALegendNotePage(driver);
		announcementPage = new QALegendAnnouncementPage(driver);
		
	}
	
	
	//scrnsht method
	
//	public String getScreenshotPath(String testcasename) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;        // webdriver converion to take ss
//		File source = ts.getScreenshotAs(OutputType.FILE);    // ss type file
//		String destinationfile = System.getProperty("user.dir") +"\\test-output\\" + testcasename+".png";   // storing fldr destintn with extntn
//		Files.copy(source, new File(destinationfile));      // cpy file from source to destintn
//		return destinationfile;
//	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
}
