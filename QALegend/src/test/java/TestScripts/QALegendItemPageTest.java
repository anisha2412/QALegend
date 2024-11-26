package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakeUtility;
import Utilities.WaitUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class QALegendItemPageTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void addItem() throws InterruptedException {
		// pass email and pswd stored in ppty file
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  		 		
		homepage.clickOnDashboardItemsBtn();              // clk menu option - Items
		itemspage.clickOnAddItemsBtn();                   // clk Add item btn
		String item_title = itemspage.addItem(properties.getProperty("item_title") + FakeUtility.randomNumberGenerator(), 
				properties.getProperty("item_description"), properties.getProperty("item_rate") + FakeUtility.randomNumberGenerator()); 
		//pass values to item form to add new item
		
		Thread.sleep(4000);
	
		itemspage.searchItem(item_title);
		Assert.assertEquals(itemspage.getItemTitle(), item_title);                                            //for assertion compare 2 string values, title passed from testdata and value fetchd from added item title
	}

}
