package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.Shipping_Return_PageUI;

public class Shipping_ReturnPO extends AbstractPageObject{
	WebDriver driverGlobal;

	public Shipping_ReturnPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
		
	}

	public FooterMyAccountPO openFooterMyAccountPage(WebDriver driverGlobal) {
		waitToElementVisible(Shipping_Return_PageUI.FOOTER_MY_ACCOUNT_LINK);
		ClickToElement(Shipping_Return_PageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driverGlobal);
	}

}
