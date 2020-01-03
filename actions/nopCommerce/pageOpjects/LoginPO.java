package nopCommerce.pageOpjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import nopCommerce.pageUIs.LoginPageUI;

public class LoginPO extends AbstractPageObject {
	WebDriver driver;

	public LoginPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public HomePO clickToLoginButton() {
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		ClickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public boolean isLoginPageDisplayed() {
		waitToElementVisible(LoginPageUI.LOGIN_FORM);
		return isElementDisplayed(LoginPageUI.LOGIN_FORM);
	}

}
