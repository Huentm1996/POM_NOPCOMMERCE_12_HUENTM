package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class NewAccountPO extends AbstractPageObject {
	WebDriver driver;
	public NewAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
