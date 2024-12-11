package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.PageUtilities;
import Utilities.WaitUtility;

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
	
	@FindBy(xpath ="//input[@id= 'website' and @name='website']")
	WebElement client_websitefield;
		
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement client_savebtn;
	
	@FindBy(xpath = "//div[@id='client-table_filter']//descendant::input")
	WebElement client_searchbox;
	
	@FindBy(xpath = "(//tr[@class='odd']//descendant ::a)[1]")
	WebElement table_client_companyname;                          //  to fetch searched company name of assrtn
			
	@FindBy(xpath = "//label[text()='Company name']")
	WebElement clientmodel_companynamelabel;                     // to hover over company name to scroll modal
	
	@FindBy(xpath = "//div[@id='ajaxModal' and @style='display: none;']") 
	WebElement modal_display_none;
	
	public QALegendClientsPage(WebDriver driver) {
		this.driver= driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}

	public String addClient(String company_name, String city, String country, String website) throws InterruptedException  {

		pageutilities.enterTextOnWebElement(client_company_namefield, company_name);
		pageutilities.enterTextOnWebElement(client_cityfield, city);
		pageutilities.enterTextOnWebElement(client_countryfield, country);
		pageutilities.scrollElement(client_websitefield);
		pageutilities.enterTextOnWebElement(client_websitefield, website);		
		pageutilities.clickOnElement(client_savebtn);
		return company_name;                                                 // to check cmpnyname for asertn
	}
	
	public void clickOnAddClientBtn() {
		addclientbtn.click();
	}
	
	public String getClientCompanyName() {                                  // to fetch cmpnyname txt from searchelist 
		String companyname = table_client_companyname.getText();
		return companyname;
	}
	
	public void searchClient(String title) {
		WaitUtility.waitForAttributeToBe(driver, modal_display_none, "style", "display: none;");
		pageutilities.enterTextOnWebElement(client_searchbox, title);
	}

}
