package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import bankGuru.pageUIs.HomePageUI;
import commons.AbstractPageObject;

public class HomePO extends AbstractPageObject {
	WebDriver driver;
	public HomePO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}
	public boolean isWelcomeMessageDisplay() {
		waitToElementVisible(HomePageUI.WELL_MESSAGE_SUCCESS);
		return isElementDisplayed(HomePageUI.WELL_MESSAGE_SUCCESS);
	}

}
