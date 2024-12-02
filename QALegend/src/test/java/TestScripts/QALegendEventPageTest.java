package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.FakeUtility;

public class QALegendEventPageTest extends Base{
	
public WebDriver driver;
	
	@Test
	public void addEvent() throws InterruptedException {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardEventsBtn();  
		eventpage.clickOnAddEventBtn();

		String title_event = eventpage.addEvent(properties.getProperty("event_title") + FakeUtility.randomNumberGenerator(),
				properties.getProperty("event_description") + FakeUtility.randomNumberGenerator(),
				properties.getProperty("event_startdate"),
				properties.getProperty("event_endate"));
		
		
//		eventpage.printAllEventTitles();
		
		//System.out.println(new_event);
//		System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+title_event);
		//Assert.assertEquals(false, null);
	
	
	}
	
	
	@Test
	public void editEvent() throws InterruptedException {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardEventsBtn();  
		eventpage.clickOnEventsToEdit();
		eventpage.clickOnEditEventbtn();
		eventpage.clearEventTitlefield();					
		String title_event = eventpage.editEvent(properties.getProperty("edit_eventtitle") + FakeUtility.randomNumberGenerator());
				
//		System.out.println(title_event);
//		Assert.assertEquals(eventpage.getEventTitle(), title_event);  
	}
}
