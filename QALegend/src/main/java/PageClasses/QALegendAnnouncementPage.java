package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendAnnouncementPage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;    
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement add_announcementbtn;
	
	@FindBy(id = "title")
	WebElement announcementtitle_field;
	
	@FindBy(id = "start_date")
	WebElement announcement_startdate;
	
	@FindBy(id = "end_date")
	WebElement announcement_enddate;
	
	@FindBy(xpath = "//div[@class='panel-footer clearfix']//following-sibling::button[contains(@class, 'btn-primary')]")
	WebElement announcement_savebtn;
	
	@FindBy(xpath = "//div[@id='announcement-table_filter']//descendant::input")
	WebElement announcement_searchbox;
		
	@FindBy(xpath = "(//tr[@class='odd']//a)[1]")
	WebElement announcement_title;

	public QALegendAnnouncementPage(WebDriver driver) {
		this.driver = driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddAnnouncementbtn() {		
		pageutilities.clickOnElement(add_announcementbtn);
	}
	
	public String addAnnouncement(String title, String startdate, String enddate) {
		pageutilities.enterTextOnWebElement(announcementtitle_field, title);
		pageutilities.scrollElement(announcement_startdate);
		pageutilities.enterTextOnWebElement(announcement_startdate, startdate);
		pageutilities.enterTextOnWebElement(announcement_enddate, enddate);
		pageutilities.clickOnElement(announcement_savebtn);
		return title; 
	}
	
	public String getAnnouncementTitle() {
		String announcementtitle = announcement_title.getText();
		return announcementtitle;
	}
	
	public void searchAnnouncement(String title) {
		pageutilities.enterTextOnWebElement(announcement_searchbox, title);
	}
		
}
