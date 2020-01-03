package bankGuru.pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class DeleteAccountPO extends AbstractPageObject {
	WebDriver driver;
	public DeleteAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

}
