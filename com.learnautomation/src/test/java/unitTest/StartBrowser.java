package unitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataproviderfactory.BrowserFactory;
import dataproviderfactory.DataProviderFactory;

public class StartBrowser {

	@Test(enabled = false)
	public void testBrowser() {
		WebDriver driver = BrowserFactory.startBrowser("Chrome");
		driver.get("http://chromedriver.storage.googleapis.com/index.html?path=2.29/");
		BrowserFactory.closeBrowser(driver);
	}

	@Test(enabled = false)
	public void testConfigFile() {

		String chromepath = DataProviderFactory.getConfig().getChromePath();

		System.out.println(chromepath);

		Assert.assertTrue(chromepath.contains("chromedriver"));
	}

	@Test(enabled = false)
	public void testExcelFile() {

		String data = DataProviderFactory.getExcel().getData("login", 1, 0);
		
		Assert.assertTrue(!data.equals(null));

	}
}
