package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendHomePage {
	public WebDriver driver;
	private PageUtilities pageutilities;     // object
	
	@FindBy(xpath = "//span[text()='Items']")
	WebElement dashboard_itemsbtn;

	
	
	
	
	
	public QALegendHomePage(WebDriver driver) {
		this.driver=driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
		
	}



	public void clickOnDashboardItemsBtn() {
		dashboard_itemsbtn.click();   //dirct clk without using page utility | clik on items btn in homepage
	}
}
