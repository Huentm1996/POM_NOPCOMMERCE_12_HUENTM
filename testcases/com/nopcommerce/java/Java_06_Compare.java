package com.nopcommerce.java;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Java_06_Compare {
	
		JavascriptExecutor javascript;
		WebDriver driver;
		
		@BeforeClass
		public void before() {
			driver = new FirefoxDriver();
			javascript = (JavascriptExecutor) driver;
		
		
	}
	public static void clickToElement(String locator, String... params) {
		locator = String.format(locator, (Object[]) params);
		System.out.println("Locator after = " + locator);
	}
//	public String getMacbookPrice(String productName) {
//		String locator = "//tr[@class='product-price']/td[%s]";
////		locator = String
//	}
	
//	public int getIndexFromProductName(String productName) {
//		
//	}

}
