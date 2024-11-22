package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendLoginPage {
	
	public WebDriver driver;
	
	private PageUtilities pageutilities;     // object
	
	@FindBy(id= "email")
	WebElement emailfield;
	
	@FindBy(id= "password")
	WebElement passwordfield;
	
	@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block mt15']")
	WebElement signinbtn;
		
	//const. made by default when object initalized	
	public QALegendLoginPage(WebDriver driver) {
		this.driver= driver;		
		//object inilization | const. for PageUtilities.java will be created automatically
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, null);				
	}
		
	//method to login	
	public void loginToQALegend(String email, String password) {
		
		// enter value to txtbox using pageutility method | emailfield and emailvalue passing from testcase
		pageutilities.enterTextOnWebElement(emailfield, email);   
		pageutilities.enterTextOnWebElement(passwordfield, password);
		pageutilities.clickOnElement(signinbtn); // click on signin btn
			
	}
}
