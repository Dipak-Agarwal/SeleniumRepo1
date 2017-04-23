package unitTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestReport {

	@Test
	public void TestReport1() {

		ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/Reports/First1.html");
		
	    ExtentTest logger=report.startTest("Login","This Test will verify login feature with valid details");

	    logger.log(LogStatus.INFO, "Started App");
	    
	    logger.log(LogStatus.INFO, "Open App");
	    
	    logger.log(LogStatus.INFO, "Login App");
	    
	    logger.log(LogStatus.INFO, "Logout App");
	
	    report.endTest(logger);
	   
	    
	   ExtentTest logger1=report.startTest("Payment Gatw", "This test will verify the payment part");
	    
	   logger1.log(LogStatus.PASS, "Payment DOne");
	   
	   report.endTest(logger1);
	   

	  
	   ExtentTest logger2=report.startTest("Payment Gatw", "This test will verify the payment part");
	    
	   logger2.log(LogStatus.FAIL, "Payment DOne");
	   
	   report.endTest(logger2);
	   
	   report.flush(); 
	}

}
