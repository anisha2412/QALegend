package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendItemPage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;     // object
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement additemsbtn;
	
	@FindBy(id = "title")
	WebElement titlefield;
	@FindBy(id = "item_rate")
	WebElement item_ratefield;
	@FindBy(className = "btn btn-primary")
	WebElement item_savebtn;
		
	
	public QALegendItemPage(WebDriver driver) {
		this.driver= driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}


	public void clickOnAddItemsBtn() {
		additemsbtn.click();
	}
	
	public void addItem(String title, String rate) {
		pageutilities.enterTextOnWebElement(titlefield, title);
		pageutilities.enterTextOnWebElement(item_ratefield, rate);
		pageutilities.clickOnElement(item_savebtn);
	}


}
