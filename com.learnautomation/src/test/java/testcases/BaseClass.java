package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataproviderfactory.BrowserFactory;

public class BaseClass {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeSuite
	public void setupReport() {
		report = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/LearnAutomation" + utility.Helper.getCurrentTime() + ".html");

	}
	
	
	@AfterMethod
    public void endTest(ITestResult result)
    {
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS,"Test Passed");
		}
		else
		{	
			String path=logger.addScreenCapture("C:\\Users\\Mukesh_50\\Desktop\\big-logo.png");
			logger.log(LogStatus.INFO, path);
			logger.log(LogStatus.FAIL, result.getThrowable());
		}
		
		
    	report.endTest(logger);
    }
	
	

	@AfterSuite
	public void generateReport() {

		report.flush();
		
	}

	@Parameters({ "Browser", "url" })
	@BeforeClass
	public void startApp(String browserName, String appURL) {
		driver = BrowserFactory.startBrowser(browserName);

		driver.get(appURL);

	}

	@AfterClass
	public void closeApp() {
		BrowserFactory.closeBrowser(driver);
	}

}
