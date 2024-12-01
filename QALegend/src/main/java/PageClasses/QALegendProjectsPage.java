package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QALegendProjectsPage {
	
	WebDriver driver;
	private PageUtilities pageutilities;
			
	@FindBy(xpath = "//a[@class=\"btn btn-default\"]")
	WebElement project_addprojectbtn;
	
	@FindBy(id="title")
	WebElement project_titlefield;
	
	@FindBy(id="deadline")
	WebElement project_deadlinefield;
		
//	@FindBy(xpath = "(//a[@class='select2-choice'])[3]")
//	WebElement client_dropdown;  
//	
//	//@FindBy(xpath = "//span[text()='My new client ']")                       // to get client name text
//	
//	@FindBy(xpath = "//span[@id='select2-chosen-6']")      
//	WebElement project_clientname;
//	
//	@FindBy(xpath = "(//input[@class='select2-input']//self::input)[3]")
//	WebElement clientsearch_textbox;
//			
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement project_savebtn;
	
	@FindBy(xpath = "//div[@id='project-table_filter']//descendant::input")
	WebElement project_searchbox;
	
	@FindBy(xpath = "(//tr[@class='odd']//descendant::a)[2]")
	WebElement project_title;
		
	@FindBy(xpath = "//div[@id='ajaxModal' and @style='display: none;']") 
	WebElement modal_display_none;
	
	public QALegendProjectsPage(WebDriver driver) {
		this.driver= driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
		
	public String addProject(String title, String deadline) throws InterruptedException {
		pageutilities.enterTextOnWebElement(project_titlefield, title);
		
//		String clientname = project_clientname.getText();
//		pageutilities.enterTextOnWebElement(clientsearch_textbox, "123");
//		pageutilities.clickOnEnterKey();
		
		pageutilities.enterTextOnWebElement(project_deadlinefield, deadline);
		pageutilities.clickOnElement(project_savebtn);
		return title;            
	}
	
	public void clickOnAddProjectbtn() {
		pageutilities.clickOnElement(project_addprojectbtn);
	}
	
	public String getProjectTitle() {
		String projecttitle = project_title.getText();
		return projecttitle;
	}
	
	public void searchProject(String title) {
		WaitUtility.waitForAttributeToBe(driver, modal_display_none, "style", "display: none;");
		pageutilities.enterTextOnWebElement(project_searchbox, title);
	}
	
//	public void clickOnClientDropdown() {
//		pageutilities.clickOnElement(client_dropdown);
//	}
//	
	
}

