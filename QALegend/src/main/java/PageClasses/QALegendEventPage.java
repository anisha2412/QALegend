package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v129.webauthn.model.CredentialAsserted;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import dev.failsafe.internal.util.Assert;

public class QALegendEventPage {
		
	public WebDriver driver;
	private PageUtilities pageutilities;     // object
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addeventbtn;
	
	@FindBy(id="title")
	WebElement event_titlefield;
	
	@FindBy(id="description")
	WebElement event_descriptionfield;
	
	@FindBy(id="start_date")
	WebElement event_start_datefield;
	
	@FindBy(id="end_date")
	WebElement event_end_datefield;
	
//	@FindBy(xpath = "(//input[@class='toggle_specific'])[1]")   //radio btn - only me
//	WebElement event_sharewithfield;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement event_savebtn;
	
//	@FindBy(xpath = "//span[text()='event19035']")
//	WebElement calender_eventtitle;                  //title for assertion
	
		
	public QALegendEventPage(WebDriver driver) {
		this.driver=driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String addEvent(String title, String description, String startdate, String enddate) throws InterruptedException {		
		pageutilities.enterTextOnWebElement(event_titlefield, title);
		pageutilities.enterTextOnWebElement(event_descriptionfield, description);
		pageutilities.enterTextOnWebElement(event_start_datefield, startdate);
		pageutilities.enterTextOnWebElement(event_end_datefield, enddate);
	
//		Thread.sleep(3000);
//		pageutilities.radiobtnClick(event_sharewithfield);

		pageutilities.clickOnElement(event_savebtn);
		return title;            // to check title for assertion
	}
	
	public void clickOnAddEventBtn() {
		addeventbtn.click();
	}
	
//	public String getEventTitle() {                    
//		String eventtitle = calender_eventtitle.getText();
//		System.out.println(eventtitle);
//		return eventtitle;
//	}
	

   


}
