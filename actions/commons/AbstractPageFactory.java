package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageFactory {
	WebElement element;
	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriver DriverGlobal;
	WebDriverWait waitExplicit;
	
	public AbstractPageFactory(WebDriver driverLocal) {
		DriverGlobal = driverLocal;
		waitExplicit = new WebDriverWait(DriverGlobal, longTimeout);

	}

	public void waitToElementVisible(WebElement element) {
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	public void sendkeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	
	public void clickToElement(WebElement element) {
		element.click();
	}
	public boolean isElementDisplay(WebElement element) {
		return element.isDisplayed();
	}
	
	public String getTextElement(WebElement element) {
		return element.getText();
	}
}
