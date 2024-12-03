package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QALegendLoginPageTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void invalidLogin()  {
		loginpage.loginWithInvalidCredentials(properties.getProperty("invalid_email"), properties.getProperty("invalid_password"));
	    Assert.assertEquals(loginpage.checkAuthentication(), true);     
	}
}
