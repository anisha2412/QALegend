package TestScripts;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakeUtility;
import Utilities.FileUploadUtility;
import Utilities.PageUtilities;

public class QAlegendNotePageTest extends Base {
	public WebDriver driver;
	
	@Test
	public void addNote() throws InterruptedException, AWTException {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardNotesBtn(); 
		notepage.clickOnAddNotebtn();
		String notetitle = notepage.addNote(properties.getProperty("note_title") + FakeUtility.randomNumberGenerator());
		FileUploadUtility.fileUploadUsingRobotClass(notepage.getNoteFilePath());
		Thread.sleep(4000);		
		notepage.searchItem(notetitle);
		Assert.assertEquals(notepage.getNoteTitle(), notetitle); 		
	}
	
	@Test
	public void editNote() throws InterruptedException  {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardNotesBtn(); 
		notepage.clickOnEditNoteiIcon();
		notepage.clearNoteTitlefield();
		
		String notetitle = notepage.editNote(properties.getProperty("edit_notetitle") + FakeUtility.randomNumberGenerator());
		Thread.sleep(4000);		
		notepage.searchItem(notetitle);
		Assert.assertEquals(notepage.getNoteTitle(), notetitle); 
	}
	
	@Test
	public void deleteNote() {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardNotesBtn(); 
		notepage.clickOnDeleteNoteiIcon();
		notepage.deleteNote();
		
		//notepage.getDeletedID();
	
//		Thread.sleep(4000);		
//		notepage.searchItem(notetitle);
//		Assert.assertEquals(notepage.getNoteTitle(), notetitle); 
	}


}
