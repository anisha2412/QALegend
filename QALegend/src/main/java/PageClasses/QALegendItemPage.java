package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendItemPage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;     // object
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement additemsbtn;
	
	@FindBy(id = "title")
	WebElement titlefield;
	
	@FindBy(id = "item_rate")
	WebElement item_ratefield;
	
	@FindBy(id = "description")
	WebElement item_descriptionfield;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement item_savebtn;
		
	@FindBy(xpath = "//div[@id='item-table_filter']//descendant::input")
	WebElement item_searchbox;
	
	@FindBy(xpath = "//td[@class=' w20p']")
	WebElement table_itemtitle;          //  searched item title in table to fetch text value for assertion
	
	
	@FindBy(xpath = "//a[@title='Edit item' and contains(@class, 'edit')]")
	WebElement item_editicon;  
	
	@FindBy(xpath = "//a[@title='Delete' and contains(@class, 'delete')]")
	WebElement item_deleteicon;          // delete icon
	
	
//	@FindBy(xpath = "//button[@id='confirmDeleteButton']")
//	WebElement item_deleteconfirmationbtn;          // no delete cnfrmtn for item
			
	public QALegendItemPage(WebDriver driver) {
		this.driver= driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddItemsBtn() {
		additemsbtn.click();
	}
	
	public String addItem(String title, String description, String rate) {
		pageutilities.enterTextOnWebElement(titlefield, title);
		pageutilities.enterTextOnWebElement(item_descriptionfield, description);
		pageutilities.enterTextOnWebElement(item_ratefield, rate);
		pageutilities.clickOnElement(item_savebtn);
		return title;            // to check title for assertion
	}
	
	public String getItemTitle() {                    //to fetch title value
		String itemtitle = table_itemtitle.getText();
		return itemtitle;
	}
	
	public void searchItem(String title) {
		//WaitUtility.waitForVisiblityOfAnElement(driver, item_searchbox);
		pageutilities.enterTextOnWebElement(item_searchbox, title);
	}
	
	public void clickOnEditItemiIcon() {
		pageutilities.clickOnElement(item_editicon);
	}
	
	public void clearItemTitlefield() {
		titlefield.clear();
	}

	public String editItem(String title) {	
		pageutilities.clickOnElement(titlefield);		
		pageutilities.enterTextOnWebElement(titlefield, title);							
		pageutilities.clickOnElement(item_savebtn);
		return title;		
	}
	
	public void clickOnDeleteItemiIcon() {
		pageutilities.clickOnElement(item_deleteicon);
	}

}
