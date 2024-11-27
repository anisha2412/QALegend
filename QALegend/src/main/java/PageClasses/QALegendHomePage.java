package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;     // object
				
	@FindBy(xpath = "//span[text()='Events']")
	WebElement dashboard_eventsbtn;
	
	@FindBy(xpath = "//span[text()='Notes']")
	WebElement dashboard_notesbtn;
	
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement dashboard_clientsbtn;
	
	@FindBy(xpath = "//span[text()='Projects']")
	WebElement dashboard_projectsbtn;
	
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement dashboard_allprojectsoption;          //drpdwn option
	
	@FindBy(xpath = "//span[text()='Items']")
	WebElement dashboard_itemsbtn;
	
		
	public QALegendHomePage(WebDriver driver) {
		this.driver=driver;
		this.pageutilities = new PageUtilities(driver);           // PageUtilities object initailizatn
		PageFactory.initElements(driver, this);		
	}
		
	public void clickOnDashboardEventsBtn() {
		pageutilities.clickOnElement(dashboard_eventsbtn);
	}
	
	public void clickOnDashboardNotesBtn() {
		pageutilities.clickOnElement(dashboard_notesbtn);
	}
	
	public void clickOnDashboardClientsBtn() {
		pageutilities.clickOnElement(dashboard_clientsbtn);
	}
	
	public void clickOnDashboardProjectsBtn() {
		pageutilities.clickOnElement(dashboard_projectsbtn);
	}
	
	public void clickOnDashboardAllProjectsOption() {
		pageutilities.clickOnElement(dashboard_allprojectsoption);
	}
	
	public void clickOnDashboardItemsBtn() {
		dashboard_itemsbtn.click();                        //drct clk without using pageutility | clk items btn in homepage
	}
}
