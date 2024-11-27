package PageClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QALegendNotePage {
	
	public WebDriver driver;
	private PageUtilities pageutilities;
	
	@FindBy(xpath = "//a[@class='btn btn-default']")
	WebElement note_addnotebtn;
	
	@FindBy(id = "title")
	WebElement note_titlefield;
	
	@FindBy(xpath = "//input[@class='select2-input select2-default']")
	WebElement note_label;
	
	@FindBy(xpath = "//button[text()=' Upload File']")
	WebElement note_uploadfilebtn;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement note_savbtn;
	
	@FindBy(xpath = "//div[@id='note-table_filter']//descendant::input")
	WebElement note_searchbox;
	
	@FindBy(xpath = "(//a[@class='edit'])[1]")
	WebElement note_notetitle;          // for searching 
	
	@FindBy(xpath = "//a[@title='Edit note' and contains(@class, 'edit')]")
	WebElement note_editicon;          // edit icon
	
	@FindBy(xpath = "//a[@title='Delete note' and contains(@class, 'delete')]")
	WebElement note_deleteicon;          // delete icon
	
	
	@FindBy(xpath = "//button[@id='confirmDeleteButton']")
	WebElement note_deleteconfirmationbtn;          // delete cnfrmtn btn
	
	
		
	public QALegendNotePage(WebDriver driver) {
		this.driver=driver;
		this.pageutilities = new PageUtilities(driver);
		PageFactory.initElements(driver, this);
	}
		
	public String addNote(String title) {
		pageutilities.enterTextOnWebElement(note_titlefield, title);		
		pageutilities.clickOnElement(note_label);
		pageutilities.enterKeyPress();
		pageutilities.clickOnElement(note_uploadfilebtn);			
		pageutilities.clickOnElement(note_savbtn);
		return title;		
	}
	
	public void clickOnAddNotebtn() {
		pageutilities.clickOnElement(note_addnotebtn);
	}
	
	public String getNoteTitle() {
		String note_title = note_notetitle.getText();
		return note_title;
	}
	
	public void searchItem(String title) {
		pageutilities.enterTextOnWebElement(note_searchbox, title);
	}
	
	public String getNoteFilePath() {
		String filePath = "C:\\Users\\ANISHA\\Downloads\\maxresdefault.jpg";
		return filePath;
	}
	
	public void clickOnEditNoteiIcon() {
		pageutilities.clickOnElement(note_editicon);
	}
	
	public String editNote(String title) {	
		pageutilities.clickOnElement(note_titlefield);		
		pageutilities.enterTextOnWebElement(note_titlefield, title);							
		pageutilities.clickOnElement(note_savbtn);
		return title;		
	}
	
	public void clearNoteTitlefield() {
		note_titlefield.clear();
	}
	
	public void clickOnDeleteNoteiIcon() {
		pageutilities.clickOnElement(note_deleteicon);
	}
	
	public void deleteNote() {
		pageutilities.clickOnElement(note_deleteconfirmationbtn);
	}
		
//	public String getDeletedID() {
//		String title_id = note_deleteconfirmationbtn.getAttribute("data-id");	
//		System.out.println(title_id);
//		return title_id;
//	}
//	

}
