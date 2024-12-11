package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.FakeUtility;

public class QALegendClientPageTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void addClient() throws InterruptedException {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  		 		
		homepage.clickOnDashboardClientsBtn();             
		clientpage.clickOnAddClientBtn();              
		String companyname = clientpage.addClient(properties.getProperty("client_companyname") + FakeUtility.randomNumberGenerator(), 
				properties.getProperty("client_city"), 
				properties.getProperty("client_country"),
				properties.getProperty("client_website") + FakeUtility.randomNumberGenerator()); 		
		clientpage.searchClient(companyname);
		Assert.assertEquals(clientpage.getClientCompanyName(), companyname);     
	}
	

}
