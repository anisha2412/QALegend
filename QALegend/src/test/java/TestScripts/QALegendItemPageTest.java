package TestScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class QALegendItemPageTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void addItem() {
		// pass email and pswd stored in ppty file
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardItemsBtn();
		itemspage.clickOnAddItemsBtn();
		itemspage.addItem(properties.getProperty("title"), properties.getProperty("rate"));
	}

}
