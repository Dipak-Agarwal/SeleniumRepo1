package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import dataproviderfactory.DataProviderFactory;
import pages.LoginPage;

public class LoginTC extends BaseClass {

	@Test
	public void loginHRM() {

		logger = report.startTest("Login to HRM");

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.verifyLoginPanel();

		logger.log(LogStatus.INFO, "Login Panel is enabled");

		login.loginToHRM(DataProviderFactory.getExcel().getData("login", 1, 0),
				DataProviderFactory.getExcel().getData("login", 1, 1));

		logger.log(LogStatus.PASS, "Login done Successfully");


	}

}
