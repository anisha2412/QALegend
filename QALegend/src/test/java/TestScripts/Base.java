package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import Constants.Constants;

import PageClasses.QALegendAnnouncementPage;
import PageClasses.QALegendClientsPage;
import PageClasses.QALegendHomePage;
import PageClasses.QALegendItemPage;
import PageClasses.QALegendLoginPage;
import PageClasses.QALegendNotePage;
import PageClasses.QALegendProjectsPage;

import Utilities.ScreenShotUtility;

public class Base {
	
	public WebDriver driver;
	public Properties properties;                 // object for handling pptys file
	public FileInputStream fis;                   // for handling file opertions in ppty file
	
	QALegendLoginPage loginpage;                  // obj of each pages
	QALegendHomePage homepage;
	QALegendItemPage itemspage;
	QALegendClientsPage clientpage;
	QALegendProjectsPage  projectpage;
	QALegendNotePage notepage;
	QALegendAnnouncementPage  announcementPage;
	
	@BeforeMethod(alwaysRun = true, groups = {"NotesTest"})  // to always run this method before testcases
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
		clientpage = new QALegendClientsPage(driver);
		projectpage = new QALegendProjectsPage(driver);
		notepage = new QALegendNotePage(driver);
		announcementPage = new QALegendAnnouncementPage(driver);
		
	}
				
	@AfterMethod(alwaysRun = true)
	public void AfterMethod(ITestResult itResult) throws IOException {	
		if (itResult.getStatus()==ITestResult.FAILURE) {
			ScreenShotUtility sc = new ScreenShotUtility();
			sc.captureFailedScreenShots(driver, itResult.getName());			
		}
		if (driver!=null) {
			driver.quit();		
		}
	}
	
	
}
