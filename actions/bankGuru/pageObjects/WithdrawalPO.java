package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class WithdrawalPO extends AbstractPageObject {
	WebDriver driver;
	public WithdrawalPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
