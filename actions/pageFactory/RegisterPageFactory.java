package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class RegisterPageFactory extends AbstractPageFactory{
	public RegisterPageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, RegisterPageFactory.class);
	}
	@FindBy(how = How.ID, using = "gender-male")
	private WebElement genderMaleRadioButton;
	
	@FindBy(how = How.ID, using ="FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(how = How.ID, using ="LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(how = How.ID, using ="Email")
	private WebElement emailTextbox;
	
	@FindBy(how = How.ID, using ="Password")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.ID, using = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(how = How.CSS, using = "#register-button")
	private WebElement registerButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='result' and text()='Your registration completed']")
	private WebElement registerSuccessMessage;
	
	@FindBy(how = How.CSS, using = ".result")
	private WebElement registerSucccessText;
	
	@FindBy(how = How.CSS, using = ".ico-logout")
	private WebElement logOutLink;
	
	public void clickToMaleRadioButton() {
		waitToElementVisible(genderMaleRadioButton);
		clickToElement(genderMaleRadioButton);
		
	}
	public void inputToFirstnameTextbox(String firstNameValue) {
		waitToElementVisible(firstNameTextbox);
		sendkeyToElement(firstNameTextbox, firstNameValue);
		
	}
	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(lastNameTextbox);
		sendkeyToElement(lastNameTextbox, lastNameValue);
		
	}
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendkeyToElement(emailTextbox, email);
		
	}
	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(passwordTextbox);
		sendkeyToElement(passwordTextbox, passwordValue);
		
	}
	public void inputToComfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementVisible(confirmPasswordTextbox);
		sendkeyToElement(confirmPasswordTextbox, confirmPasswordValue);
		
	}
	public void clickToRegisterButton() {
		waitToElementVisible(registerButton);
		clickToElement(registerButton);
		
	}
	public boolean isSuccessMessageDisplayed() {
		waitToElementVisible(registerSuccessMessage);
		return isElementDisplay(registerSuccessMessage);
		
	}
	public String getSuccessMessageText() {
		waitToElementVisible(registerSucccessText);
		return getTextElement(registerSucccessText);
		
	}
	public void clickToLogoutLink() {
		waitToElementVisible(logOutLink);
		clickToElement(logOutLink);
		
	}


}
