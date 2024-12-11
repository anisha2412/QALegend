package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.FakeUtility;

public class QALegendAnnouncementPageTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void addAnnouncement()  {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));
		homepage.scrollSideBar();
	    homepage.clickOnDashboardAnnouncementBtn(); 
	    announcementPage.clickOnAddAnnouncementbtn();
	    String announcementTitle = announcementPage.addAnnouncement(properties.getProperty("announcement_title") + FakeUtility.randomNumberGenerator(),
	    		properties.getProperty("announcement_startdate"),
	    		properties.getProperty("announcement_endate") );   
	    homepage.scrollSideBar();
	    homepage.clickOnDashboardAnnouncementBtn(); 
	    announcementPage.searchAnnouncement(announcementTitle); 
	    Assert.assertEquals(announcementPage.getAnnouncementTitle(), announcementTitle);   
	}
}
