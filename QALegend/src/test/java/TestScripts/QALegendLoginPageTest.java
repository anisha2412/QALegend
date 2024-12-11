package TestScripts;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constants.Constants;
import Utilities.ExcelUtility;

public class QALegendLoginPageTest extends Base {
	
	public WebDriver driver;
	
	@Test(retryAnalyzer = TestScripts.RetryAnalyser.class )
	public void invalidLogin() throws IOException  {	   		
		String path = Constants.EXCEL_FILEPATH;		
		String sheet_name = Constants.SHEET_NAME;		
		String email = ExcelUtility.getStringData(0, 1, path, sheet_name);
		String password = ExcelUtility.getIntegerData(1, 1, path, sheet_name);
		loginpage.loginWithInvalidCredentials(email,password);
		Assert.assertEquals(loginpage.checkAuthentication(), true);     
	}
}
