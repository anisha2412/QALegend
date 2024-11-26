package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v129.network.model.WebTransportConnectionEstablished;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	
	public WebDriver driver;
		
	public PageUtilities(WebDriver driver) {
		this.driver=driver;                // set driver 				
	}
		
	public void clickOnElement(WebElement element) {
		element.click();
	}	
	public void enterTextOnWebElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	public void selectByVisibleText(WebElement dropdown, String visibletext) {
		Select drp = new Select(dropdown);
		drp.selectByVisibleText(visibletext);
	}	
	public void selectByValue(WebElement dropdown, String value) {
		Select drp = new Select(dropdown);
		drp.selectByValue(value);
	}	
	public void selectByIndex(WebElement dropdown, int index) {
		Select drp = new Select(dropdown);
		drp.selectByIndex(index);
	}
	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();
	}
	public void hoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void rightClick() {
		Actions actions = new Actions(driver);
		actions.contextClick().build().perform();
	}	
	public void rightClickOnWebElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}	
	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("window.scrollBy(0,2000)");			
	}
	public boolean isElementDisplayed(WebElement element) {
		return(element.isDisplayed());			 // return result back
	}
	
//task	
	public void clickOnCtrlKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL).build().perform();
	}
	public void clickOnEscKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}
	public void clickOnAltKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ALT).build().perform();
	}	
	public void clickOnEnterKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}	
	public boolean isElementEnabled(WebElement element) {
		return(element.isEnabled());			
	}	
	public void holdKey() {
		Actions action = new Actions(driver);
		action.keyDown(Keys.BACK_SPACE).build().perform();
	}	
	public void releaseKey() {
		Actions action = new Actions(driver);
		action.keyUp(Keys.BACK_SPACE).build().perform();
	}
	public void clickHiddenElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver ;
		js.executeScript("arguments[0].click()",element);
	}	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	public void getTextAlert() {
		driver.switchTo().alert().getText();
	}		
	public void enterValueInAlert(String text) {
		driver.switchTo().alert().sendKeys(text);		
	} 
	public void checkBoxClick(WebElement element) {
		element.click();
	}		
	public void radiobtnClick(WebElement element) {
		element.click();
	}
	public void doubleClick() {
		Actions action = new Actions(driver);
		action.doubleClick().build().perform();
	}
	public void doubleClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	
	
	
	
	
	
}
