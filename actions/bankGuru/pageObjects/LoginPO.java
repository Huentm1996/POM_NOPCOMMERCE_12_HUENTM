package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.LoginPageUI;
import bankGuru.pageUIs.RegisterPageUI;
import commons.AbstractPageObject;

public class LoginPO extends AbstractPageObject {
	WebDriver driver;
	public LoginPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}
	public String getLoginPageUrl() {
		return getPageCurrentUrl();
	}
	public RegisterPO clickToHereLink() {
		waitToElementVisible(LoginPageUI.HERE_LINK);
		ClickToElement(LoginPageUI.HERE_LINK);
		return BankGuruPageGeneratorManager.getRegisterPage(driver);
	}
	public void inputuserIDtextbox(String userID) {
		waitToElementVisible(LoginPageUI.USER_ID_TEXTBOX);
		sendkeyToElement(LoginPageUI.USER_ID_TEXTBOX, userID);
		
	}
	public void inputpasswordtextbox(String passwordID) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, passwordID);
		
	}
	public HomePO clickToSubmitButton() {
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		ClickToElement(LoginPageUI.LOGIN_BUTTON);
		return BankGuruPageGeneratorManager.getHomePage(driver);
	}



}
