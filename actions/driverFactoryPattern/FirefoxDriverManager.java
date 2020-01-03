package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.glass.ui.View.Capability;

public class FirefoxDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
//		String rootFolder = System.getProperty("user.dir");
//		FirefoxProfile profile = new FirefoxProfile();
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		profile.setAcceptUntrustedCertificates(false);
//		profile.setAssumeUntrustedCertificateIssuer(true);
//		profile.setPreference("dom.webnotification.enabled", false);
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//		profile.setPreference("browser.dowload.manager.showWhenStarting", false);
//		profile.setPreference("browser.download.dir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.download.Dir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.download.Dir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext.text/plan,text/html,application/plain");
//		capability = DesiredCapabilities.firefox();
//		capability.setCapability(FirefoxDriver.PROFILE,profile);
//		driver = new FirefoxDriver(capability);
		
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\FirefoxLogs.txt");
		driver = new FirefoxDriver();
		
		
	}

}
