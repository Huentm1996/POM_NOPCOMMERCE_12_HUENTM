package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class HomePageFactory extends AbstractPageFactory{
	public HomePageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, HomePageFactory.class);

	}

	@FindBy(how = How.CSS, using = ".ico-register")
	private WebElement registerLink;
	
	@FindBy(how = How.CSS, using = ".ico-login")
	private WebElement loginLink;
	
	@FindBy(how = How.CSS, using = ".ico-account")
	private WebElement myAccountLink;
	
	@FindBy(how = How.CSS,using = ".ico-logout")
	private WebElement logoutLink;
	
	public void clickToRegisterLink() {
		waitToElementVisible(registerLink);
		clickToElement(registerLink);
		
	}
	public void clickToLoginLink() {
		waitToElementVisible(loginLink);
		clickToElement(loginLink);
		
	}
	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(myAccountLink);
		return isElementDisplay(myAccountLink);
		
	}
	public boolean LogoutLinkDisplay() {
		waitToElementVisible(logoutLink);
		return isElementDisplay(logoutLink);		
	}
	

}
