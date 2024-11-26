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
		
		
//		System.out.println(title_event);
//		Thread.sleep(3000);
//		Assert.assertEquals(eventpage.getEventTitle(), title_event);  
	}
}
