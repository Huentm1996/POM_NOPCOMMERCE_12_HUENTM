package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

public class nopCommercePageGeneratorManager {
	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);		
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);		
	}
	
	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);		
	}
	public static HeaderMyAccountPO getHeaderMyAccountPO(WebDriver driver) {
		return new HeaderMyAccountPO(driver);
	}

	public static FooterMyAccountPO getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPO(driver);
	}
	
	public static SearchPO getSearchPage(WebDriver driver) {
		return new SearchPO(driver);
	}
	
	public static Shipping_ReturnPO getShipping_ReturnPage(WebDriver driver) {
		return new Shipping_ReturnPO(driver);
	}
	
	public static SitemapPO getSitemapPage(WebDriver driver) {
		return new SitemapPO(driver);
	}

	public static MyAccountPO getMyAccountPage(WebDriver driver) {
		return new MyAccountPO(driver);
	}

	



}
 