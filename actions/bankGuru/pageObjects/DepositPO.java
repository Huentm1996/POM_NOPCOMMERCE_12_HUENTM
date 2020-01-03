package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class DepositPO extends AbstractPageObject {
	WebDriver driver;
	public DepositPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
