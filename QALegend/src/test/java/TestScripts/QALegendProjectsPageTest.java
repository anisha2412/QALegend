package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.FakeUtility;

public class QALegendProjectsPageTest extends Base{
	
	public WebDriver driver;
	
	@Test
	public void addProject() throws InterruptedException {
		loginpage.loginToQALegend(properties.getProperty("email"), properties.getProperty("password"));  
		homepage.clickOnDashboardProjectsBtn();  
		homepage.clickOnDashboardAllProjectsOption();
		projectpage.clickOnAddProjectbtn();
		
//		projectpage.clickOnClientDropdown();
		
		String title_project = projectpage.addProject(properties.getProperty("project_title") + FakeUtility.randomNumberGenerator(),
				properties.getProperty("project_deadline"));	
		projectpage.searchProject(title_project);
		Assert.assertEquals(projectpage.getProjectTitle(), title_project); 
	}

}
