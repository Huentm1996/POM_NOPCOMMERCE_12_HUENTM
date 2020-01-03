package com.nopcommerce.java;

public class Java_01_DynamicLocator {

	static String HOME_PAGE_LINK = "//a[text()='HomePage']";
	static String SITE_MAP_LINK = "//a[text()='Sitemap']";
	static String SHIPPING_LINK = "//a[text()='Shipping & Return']";
	static String MY_ACCOUNT_LINK = "//a[text()='My Account']";
//	1 parameter
	static String DYNAMIC_LINK = "//a[text()='%s']";
	
//	2 parameter
	static String DYNAMIC_COUNTRY_DYNAMIC_BUTTON = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	
//	3 parameter
	static String DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_BUTTON = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";

	public static void main(String[] args) {
		clickToElement(DYNAMIC_LINK, "Home Page");
		clickToElement(DYNAMIC_LINK, "Login Page");
		clickToElement(DYNAMIC_LINK, "Register Page");
//		clickToElement(DYNAMIC_LINK, "My Account");
		
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_BUTTON, "Vietnam", "edit");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_BUTTON, "Vietnam", "remove");
		
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_BUTTON, "Uzbekistan", "edit");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_BUTTON, "Uzbekistan", "remove");
		
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_BUTTON, "Vietnam","1320000", "edit");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_BUTTON, "Vietnam","1320000", "remove");
	}
//	Khi co them 1 tham so moi thi phai tao ra them 1 ham(+1 tham so)
//	public static void clickToElement(String locator, String param) { 
//		System.out.println("Locator before = " + locator);
//		System.out.println("Page name = " + param);
//		locator = String.format(locator, param);
//		System.out.println("Locator after = " + locator);		
//	}
//	
//	public static void clickToElement(String locator, String firstParam, String secondParam) { 
//		System.out.println("Locator before = " + locator);
//		locator = String.format(locator, firstParam,secondParam);
//		System.out.println("Locator after = " + locator);		
//	}
//	
//	public static void clickToElement(String locator, String firstParam, String secondParam, String thirdParam) { 
//		System.out.println("Locator before = " + locator);
//		locator = String.format(locator, firstParam,secondParam,thirdParam);
//		System.out.println("Locator after = " + locator);		
//	}
//	Apply Rest Parameter để xử lý cho n tham số
	
	public static void clickToElement(String locator, String... params) {
		System.out.println();
		locator = String.format(locator, (Object[]) params);
		System.out.println("Locator after = " + locator);
	}
	

	

}
