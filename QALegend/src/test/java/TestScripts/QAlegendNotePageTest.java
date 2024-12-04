package TestScripts;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.FakeUtility;

public class QAlegendNotePageTest extends Base {
	
	public WebDriver driver;
		
	@Test
	public void addNote() throws InterruptedException, AWTException {
	    loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
	    homepage.clickOnDashboardNotesBtn(); 
	    notepage.clickOnAddNotebtn();
	    String noteTitle = notepage.addNote(properties.getProperty("note_title") + FakeUtility.randomNumberGenerator());  
	    notepage.searchNote(noteTitle);  
	    Assert.assertEquals(notepage.getNoteTitle(), noteTitle);  
	}
	
	@Test
	public void editNote() throws AWTException  {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardNotesBtn();
		notepage.clickOnAddNotebtn();
		String addednotetitle = notepage.addNote(properties.getProperty("note_title") + FakeUtility.randomNumberGenerator()); 
		notepage.searchNote(addednotetitle);
		notepage.clickOnEditNoteiIcon();
		notepage.clearNoteTitlefield();
		String editednotetitle = notepage.editNote(properties.getProperty("edit_notetitle") + FakeUtility.randomNumberGenerator()); 
		notepage.clearSearchBox();
		notepage.searchNote(editednotetitle);
		Assert.assertEquals(notepage.getNoteTitle(), editednotetitle); 
	}
	
	@Test
	public void deleteNote() throws AWTException {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardNotesBtn(); 		
		notepage.clickOnAddNotebtn();
		String noteTitle = notepage.addNote(properties.getProperty("note_title") + FakeUtility.randomNumberGenerator());  
		notepage.searchNote(noteTitle); 				
		notepage.clickOnDeleteNoteiIcon();
		notepage.deleteNoteConfirmation();
		Assert.assertEquals(notepage.getDeletedNote(), true);  			
	}
	
}
