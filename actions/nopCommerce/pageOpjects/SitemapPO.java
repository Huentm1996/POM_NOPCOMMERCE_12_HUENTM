package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.SitemapPageUI;


public class SitemapPO extends AbstractPageObject{
	WebDriver driverGlobal;

	public SitemapPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

//	public Shipping_ReturnPO openShipping_ReturnPage(WebDriver driver) {
//		waitToElementVisible(SitemapPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
//		ClickToElement(SitemapPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
//		
//		return PageGeneratorManager.getShipping_ReturnPage(driver);
//	}

}
