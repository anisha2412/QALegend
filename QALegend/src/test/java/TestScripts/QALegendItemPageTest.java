package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.FakeUtility;
import org.openqa.selenium.WebDriver;

public class QALegendItemPageTest extends Base {
	
	public WebDriver driver;
	
	@Test(priority = 1)
	public void addItem()  {		
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));   // pass email and pswd stored in ppty file		 		
		homepage.clickOnDashboardItemsBtn();                                                              // clk menu option - Items
		itemspage.clickOnAddItemsBtn();                                                                   // clk Add item btn
		String item_title = itemspage.addItem(properties.getProperty("item_title") + FakeUtility.randomNumberGenerator(), 
				properties.getProperty("item_description"), 
				properties.getProperty("item_rate"));   			
		itemspage.searchItem(item_title);
		Assert.assertEquals(itemspage.getItemTitle(), item_title);                            // for assertion compare 2 string values, title passed from testdata and value fetchd from added item title
	}
	
	@Test(priority = 2)
	public void editItem() {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  		 		
		homepage.clickOnDashboardItemsBtn();  		
		itemspage.clickOnAddItemsBtn();                                                                   // clk Add item btn
		String addeditem_title = itemspage.addItem(properties.getProperty("item_title") + FakeUtility.randomNumberGenerator(), 
				properties.getProperty("item_description"), 
				properties.getProperty("item_rate"));   			
		itemspage.searchItem(addeditem_title);				
		itemspage.clickOnEditItemiIcon();
		itemspage.clearItemTitlefield();
		String editeditem_title = itemspage.editItem(properties.getProperty("edit_itemtitle") + FakeUtility.randomNumberGenerator()); 			
	    itemspage.clearSearchBox();
		itemspage.searchItem(editeditem_title);
		Assert.assertEquals(itemspage.getItemTitle(), editeditem_title);                                           
	}
	
	@Test(priority = 3)
	public void deleteItem() {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardItemsBtn(); 
		itemspage.clickOnAddItemsBtn();                                                                   
		String item_title = itemspage.addItem(properties.getProperty("item_title") + FakeUtility.randomNumberGenerator(), 
				properties.getProperty("item_description"), 
				properties.getProperty("item_rate"));  		
		itemspage.searchItem(item_title);
		itemspage.clickOnDeleteItemiIcon();
		Assert.assertEquals(itemspage.getDeletedItem(), true);  
	}
}
