//to handle explicit wait

package Utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Constants.Constants;

public class WaitUtility {
	
	public WebDriver driver;
	
	public void waitForClickingElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));  
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	public void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));  
		wait.until(ExpectedConditions.textToBePresentInElement(element ,text));		
	}

	public void waitForElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));  
		wait.until(ExpectedConditions.elementToBeSelected(element));		
	}

	public void waitForAttributeToBe(WebDriver driver, WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));  
		wait.until(ExpectedConditions.attributeToBe(element, attribute, value));	
	}

	public void waitForVisiblityOfAnElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));  
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void waitForAlertToBePresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICITWAIT));  
		wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	
	
	
	
	
	
	
	
	
	
}
