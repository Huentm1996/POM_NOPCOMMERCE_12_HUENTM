package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.RegisterPageUI;
import commons.AbstractPageObject;

public class RegisterPO extends AbstractPageObject {
	WebDriver driver;
	public RegisterPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

	
	
	public void clickButtonSubmit() {
		waitToElementVisible(RegisterPageUI.SUBMIT_BUTTON);
		ClickToElement(RegisterPageUI.SUBMIT_BUTTON);
		
	}
	public String getUserIDValue() {
		waitToElementVisible(RegisterPageUI.USER_ID_TEXT);
		return getTextElement(RegisterPageUI.USER_ID_TEXT);
	}
	public String getPasswordValue() {
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(RegisterPageUI.PASSWORD_TEXT);
	}
	public LoginPO openLoginPage(String loginPageurl) {
		openUrl(loginPageurl);
		return BankGuruPageGeneratorManager.getLoginPage(driver);
	}

	public void inputEmailIDTextbox(String email) {
		waitToElementVisible(RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendkeyToElement(RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}

}
