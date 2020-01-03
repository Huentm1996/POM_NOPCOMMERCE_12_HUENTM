package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.HeaderMyAccountPageUI;
import nopCommerce.pageUIs.HomePageUI;

public class HeaderMyAccountPO extends AbstractPageObject {
	WebDriver DriverGlobal;

	public HeaderMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		DriverGlobal = driverLocal;
	}

	public SitemapPO openSiteMapPage(WebDriver driver) {
		waitToElementVisible(HeaderMyAccountPageUI.FOOTER_SITEMAP_LINK);
		ClickToElement(HeaderMyAccountPageUI.FOOTER_SITEMAP_LINK);
		return PageGeneratorManager.getSitemapPage(driver);
	}



}
