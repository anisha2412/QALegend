package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.Constants;
import Utilities.ExcelUtility;

public class QALegendLoginPageTest extends Base {
	
	public WebDriver driver;
	
	@Test
	public void invalidLogin() throws IOException  {	   
		int row = Constants.EXCEL_ROWCOUNT;
		int colunm = Constants.EXCEL_COLUMNCOUNT;
		String path = Constants.EXCEL_FILEPATH;		
		String sheet_name = Constants.SHEET_NAME;		
		String email = ExcelUtility.getStringData(row, colunm, path, sheet_name);
		loginpage.loginWithInvalidCredentials(email,properties.getProperty("invalid_password"));
		Assert.assertEquals(loginpage.checkAuthentication(), true);     
	}
}
