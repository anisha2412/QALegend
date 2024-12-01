package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendLoginPage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;    
	
	@FindBy(id= "email")
	WebElement emailfield;
	
	@FindBy(id= "password")
	WebElement passwordfield;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block mt15']")
	WebElement signinbtn;
		
	public QALegendLoginPage(WebDriver driver) {	      // const. made by default when loginpage object initalized	
		this.driver= driver;				
		this.pageutilities = new PageUtilities(driver);   // object inilization | const. for PageUtilities.java will be created automatically
		PageFactory.initElements(driver, this);				
	}
			
	public void loginToQALegend(String email, String password) {			// method to login		
		pageutilities.enterTextOnWebElement(emailfield, email);             // enter value to txtbox using pageutility method | emailfield and emailvalue passing from testcase
		pageutilities.enterTextOnWebElement(passwordfield, password);
		pageutilities.clickOnElement(signinbtn);                            // click on signin btn			
	}
}
