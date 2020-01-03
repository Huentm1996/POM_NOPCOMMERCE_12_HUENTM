package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.FooterMyAccountPageUI;

public class FooterMyAccountPO extends AbstractPageObject {
	WebDriver DriverGlobal;

	public FooterMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		DriverGlobal = driverLocal;
	}

	public SearchPO opensearchPage(WebDriver driverLocal) {
		waitToElementVisible(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		ClickToElement(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driverLocal);
	}
	
	public Shipping_ReturnPO openShipping_ReturnPO(WebDriver driverLocal) {
		waitToElementVisible(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		ClickToElement(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getShipping_ReturnPage(driverLocal);
	}



}
