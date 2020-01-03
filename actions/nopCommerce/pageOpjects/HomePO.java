  package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.HomePageUI;
import nopCommerce.pageUIs.RegisterPageUI;

public class HomePO extends AbstractPageObject {
	WebDriver DriverGlobal;

	public HomePO(WebDriver driverLocal) {
		super(driverLocal);
		DriverGlobal = driverLocal;
	}

	public RegisterPO clickToRegisterLink() {
		waitToElementVisible(HomePageUI.HEADER_REGISTER_LINK);
		ClickToElement(HomePageUI.HEADER_REGISTER_LINK);
//		ClickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(DriverGlobal);
	}

	public LoginPO clickToLoginLink() {
		waitToElementVisible(HomePageUI.HEADER_LOGIN_LINK);
		ClickToElement(HomePageUI.HEADER_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(DriverGlobal);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(HomePageUI.HEADER_MY_ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplay() {
		waitToElementVisible(HomePageUI.HEADER_LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_LOGOUT_LINK);
	}

//	public HeaderMyAccountPO openHeaderMyAccountPage(WebDriver driver) {
//		waitToElementVisible(HomePageUI.HEADER_MY_ACCOUNT_LINK);
//		ClickToElement(HomePageUI.HEADER_MY_ACCOUNT_LINK);
//		return PageGeneratorManager.getHeaderMyAccountPO(driver);
//	}
	
	public boolean isRegisterLinkUndisplayed() {
		waitToElementInvisible(HomePageUI.HEADER_REGISTER_LINK);
		return isElementDisplayed(HomePageUI.HEADER_REGISTER_LINK);
	}
	
	public boolean isLoginLinkUndisplayed() {
		waitToElementInvisible(HomePageUI.HEADER_LOGIN_LINK);
		return isElementDisplayed(HomePageUI.HEADER_LOGIN_LINK);
	}

	public LoginPO openLoginPage() {
		waitToElementVisible(HomePageUI.HEADER_LOGIN_LINK);
		ClickToElement(HomePageUI.HEADER_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(DriverGlobal);		
	}


}
