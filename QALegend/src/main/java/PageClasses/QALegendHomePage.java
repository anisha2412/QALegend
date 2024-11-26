package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;     // object
		
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement dashboard_itemsbtn;
		
	@FindBy(xpath = "//span[text()='Events']")
	WebElement dashboard_eventsbtn;
	
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement dashboard_clientsbtn;
	
	public QALegendHomePage(WebDriver driver) {
		this.driver=driver;
		this.pageutilities = new PageUtilities(driver);           // PageUtilities object initailizatn
		PageFactory.initElements(driver, this);		
	}

	public void clickOnDashboardItemsBtn() {
		dashboard_itemsbtn.click();   //drct clk without using pageutility | clk items btn in homepage
	}
	
	public void clickOnDashboardEventsBtn() {
		pageutilities.clickOnElement(dashboard_eventsbtn);
	}
	
	public void clickOnDashboardClientsBtn() {
		pageutilities.clickOnElement(dashboard_clientsbtn);
	}
}
