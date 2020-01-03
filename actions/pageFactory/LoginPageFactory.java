package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import commons.AbstractPageObject;
import nopCommerce.pageUIs.LoginPageUI;

public class LoginPageFactory extends AbstractPageFactory{
	public LoginPageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, LoginPageFactory.class);
	}

	@FindBy(how = How.ID, using = "email")
	private WebElement emailTextbox;
	
	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.CSS, using = ".login-button")
	private WebElement logginButton;
	
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendkeyToElement(emailTextbox, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(passwordTextbox);
		sendkeyToElement(passwordTextbox, password);
	}
	
	public void clickToLoginButton() {
		waitToElementVisible(logginButton);
		clickToElement(logginButton);
	}
	

}
