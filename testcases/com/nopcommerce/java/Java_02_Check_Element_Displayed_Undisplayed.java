package com.nopcommerce.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Java_02_Check_Element_Displayed_Undisplayed {
	WebDriver driver;
	WebDriverWait waitExplicit;
	Actions action;
	long shortTimeout = 5;
	long longTimeout = 30;
	
	
  @BeforeClass
  public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		waitExplicit = new WebDriverWait(driver, longTimeout);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		}
  
  @Test
  public void TC_01_Check_element_displayed() throws Exception {
//	  ==== ELEMENT CO TRONG DOM
//	  Check 01- Check login Page displayed
	  boolean loginPageStatus = isElementDisplayed("//a[@class='ico-login']");
	  System.out.println("Login Page = " + loginPageStatus);
	  Assert.assertTrue(loginPageStatus);
	  
//	  Step 02: Check mini-cart un-displayed( leave mouse)
	  System.out.println("Before :" + getDateTime());
	  waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='count']")));
	  System.out.println("After :" + getDateTime());

	  
	  boolean MiniCartUnStatus = isElementDisplayed("//div[@class='count']");
	  System.out.println("mini cart " + MiniCartUnStatus);
	  Assert.assertFalse(MiniCartUnStatus);
	  
	  Assert.assertTrue(isControlUndisplayed("//div[@class='count']"));
	  
//	  Step 03: Check mini-cart displayed (houver mouse)
	  action.moveToElement(driver.findElement(By.xpath("//a[@class='ico-cart']"))).perform();
	  Thread.sleep(2000);
	  boolean MiniCartDisplayedStatus = isElementDisplayed("//div[@class='count']");
	  System.out.println("mini cart " + MiniCartDisplayedStatus);
	  Assert.assertTrue(MiniCartDisplayedStatus);
	  
//	  === ELEMENT KHONG CO TRONG DOM
//	  step 04: check My account page un-displayed
	  waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class='ico-account']")));
	  
	  boolean MyaccountPage = isElementDisplayed("//a[@class='ico-account']");
	  System.out.println("Myaccount Page = " + MyaccountPage);
	  Assert.assertFalse(MyaccountPage);
	  Assert.assertTrue(isControlUndisplayed("//a[@class='ico-account']"));


//	  Step 05: Open Login Page -> Check Nivo Image Un-Displayed
	  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
	  
	  boolean NivoImageStatus = isElementDisplayed("//a[@class='nivo-imageLink']");
	  System.out.println("Nivo Image = " + NivoImageStatus);
	  Assert.assertFalse(NivoImageStatus);
	  Assert.assertTrue(isControlUndisplayed("//a[@class='nivo-imageLink']"));


	  
  }
  public boolean isElementDisplayed(String locator) {
//		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);

	  try {
		  WebElement element = driver.findElement(By.xpath(locator));
//		  1- Element có trong DOM và hiển thị ở trên UI
//		  2- Element có trong DOM và ko hiển thị ở trên UI
//			driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);  
		  return element.isDisplayed();
		
	} catch (NoSuchElementException e) {
//		3- Element ko có trong DOM
//		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);  
		return false;
	}
  }


 public boolean isControlUndisplayed(String locator) {
	  Date date = new Date();
	  System.out.println("Start time =" + getDateTime());
	  List<WebElement> elements = driver.findElements(By.xpath(locator));
	  
	  if (elements.size()==0) {
		  System.out.println("Element not in DOM");
		  System.out.println("End time =" + getDateTime());
		  return true;
	  }else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
		  System.out.println("Element in DOM but not visible/displayed");
		  System.out.println("End time = "+ getDateTime());
		  return true;
	  } else {
		  System.out.println("Element in DOM and visible");
		  return false;
	  }
 }
 
 @AfterClass
 public void afterClass() {
	 driver.quit();
 }
 public String getDateTime() {
	 Date date = new Date();
	 return date.toString();
 }
}