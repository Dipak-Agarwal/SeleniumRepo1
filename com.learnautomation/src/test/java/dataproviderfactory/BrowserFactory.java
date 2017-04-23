package dataproviderfactory;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver startBrowser(String browserName) {

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Firefox")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, false);

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<String, Object>();

			prefs.put("credentials_enable_service", false);

			prefs.put("password_manager_enabled", false);

			prefs.put("profile.default_content_settings.popups", 0);

			option.setExperimentalOption("prefs", prefs);

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			cap.setCapability(ChromeOptions.CAPABILITY, option);

			//ConfigDataProvider config=new ConfigDataProvider();
			
			//System.setProperty("webdriver.chrome.driver", config.getChromePath());
			
			driver = new ChromeDriver(cap);

		} else if (browserName.equalsIgnoreCase("IE")) {

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			//ConfigDataProvider config=new ConfigDataProvider();
			
			//System.setProperty("webdriver.ie.driver", config.getIEPath());
			
			driver = new InternetExplorerDriver(cap);

		}

		return driver;
	}

	public static void closeBrowser(WebDriver ldriver) {

		ldriver.quit();
	}

}
