package datadriven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;

public class DDF {
	WebDriver driver;
	ExcelDataProvider excel;
	ArrayList<String> list;

	@BeforeClass
	public void startApp() {
		list = new ArrayList<String>();
		excel = new ExcelDataProvider();
		System.out.println("==== Starting the Browser====");

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		System.out.println("====  Browser Started====");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

		excel.startWriteExcel();

		int row = excel.getRowCount("login");

		for (int i = 1; i < row; i++) {

			String result = list.get(i - 1);

			excel.writeData("login", i, 2, result);
		}

		excel.closeExcel();

		System.out.println("==== Closing the Browser====");
	}

	@Test(dataProvider = "LoginData")
	public void loginApp(String uname, String pass) throws InterruptedException {

		driver.get("http://opensource.demo.orangehrmlive.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("txtUsername")).sendKeys(uname);

		driver.findElement(By.id("txtPassword")).sendKeys(pass);

		driver.findElement(By.id("btnLogin")).click();

		boolean status = false;
		try {
			status = driver.findElement(By.xpath("//a[text()='Welcome Admin']")).isDisplayed();
			list.add("PASS");
			status = true;

		} catch (Exception e) {
			list.add("FAIL");
		}

		Assert.assertTrue(status);

		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

	@DataProvider(name = "LoginData")
	public Object[][] dataGenerator() {
		System.out.println("Test Data is getting Ready");

		int row = excel.getRowCount("login");

		Object[][] arr = new Object[row - 1][2];

		for (int i = 1; i < row; i++) {
			arr[i - 1][0] = excel.getData("login", i, 0);
			arr[i - 1][1] = excel.getData("login", i, 1);
		}

		System.out.println("Test Data is  Ready for Test Automation");

		return arr;

	}

}
