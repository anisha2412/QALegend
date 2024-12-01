package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtilities;


public class QALegendEventPage {
		
	public WebDriver driver;
	private PageUtilities pageutilities;     
	
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
	
	@FindBy(xpath = "(//input[@class='toggle_specific'])[2]")   
	WebElement event_sharewithfield;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement event_savebtn;
	
//	@FindBy(xpath = "//span[text()='event19035']")
//	WebElement calender_eventtitle;                                    // title for assertion
		
	@FindBy(xpath = "//span[@class='fc-title']")
	WebElement event_titletoedit;
		
	@FindBy(xpath = "//a[@title='Edit event' and contains(@class, 'btn btn-default')]")
	WebElement event_editbtn;
	
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
		pageutilities.radiobtnJSClick(event_sharewithfield);
		pageutilities.clickOnElement(event_savebtn);
		return title;                                                    // to check event_title for assertion
	}
	
	public void clickOnAddEventBtn() {
		addeventbtn.click();
	}
	
//	public String getEventTitle() {                    
//		String eventtitle = calender_eventtitle.getText();
//		System.out.println(eventtitle);
//		return eventtitle;
//	}
	
	public void clickOnEventsToEdit() {
		event_titletoedit.click();
	}
	
	public void clickOnEditEventbtn() {
		event_editbtn.click();
	}
	
	public void clearEventTitlefield() {
		event_titlefield.clear();
	}
	
	public String editEvent(String title) {
		pageutilities.enterTextOnWebElement(event_titlefield, title);
		pageutilities.clickOnElement(event_savebtn);
		return title;
	}
	


}
