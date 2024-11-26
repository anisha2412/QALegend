package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendClientsPage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;    
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement addclientbtn;
	
	@FindBy(id="company_name")
	WebElement client_company_namefield;
	
	@FindBy(id="city")
	WebElement client_cityfield;
	
	@FindBy(id="country")
	WebElement client_countryfield;
	
	//@FindBy(xpath ="//input[@id='website']")
	
	@FindBy(id ="website")
	WebElement client_websitefield;
		
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement client_savebtn;
	
	@FindBy(xpath = "//div[@id='client-table_filter']//descendant::input")
	WebElement client_searchbox;
	
	@FindBy(xpath = "(//tr[@class='odd']//descendant ::a)[1]")
	WebElement table_client_companyname;          //  searched company name
	
	public QALegendClientsPage(WebDriver driver) {
		this.driver= driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public String addClient(String company_name, String city, String country, String website) throws InterruptedException  {		
		pageutilities.enterTextOnWebElement(client_company_namefield, company_name);
		pageutilities.enterTextOnWebElement(client_cityfield, city);
		pageutilities.enterTextOnWebElement(client_countryfield, country);
//		pageutilities.scrollPage();
//		Thread.sleep(2000);
		pageutilities.enterTextOnWebElement(client_websitefield, website);
		pageutilities.clickOnElement(client_savebtn);
		return company_name;            // to check company_name for assertion
	}
	
	public void clickOnAddClientBtn() {
		addclientbtn.click();
	}
	
	public String getClientCompanyName() {                    //to fetch companyname text value searched 
		String companyname = table_client_companyname.getText();
		return companyname;
	}
	
	public void searchItem(String title) {
		//WaitUtility.waitForVisiblityOfAnElement(driver, item_searchbox);
		pageutilities.enterTextOnWebElement(client_savebtn, title);
	}

	



}
