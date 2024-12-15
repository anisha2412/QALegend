package TestScripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Utilities.ExtentReportNG;


public class Listeners extends Base implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();             // calling method from ExtentReportNG cls	
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();  // threadlock | obj creatn

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);                         // rslt has full details about testcase  
		test = extent.createTest(result.getMethod().getMethodName());    // getMethodName - get crnt running TC name and give it to  createTest and it create a field for that TC in report inside feild tc pass or fail is specified
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		extenttest.get().log(Status.PASS, "Testcase Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		extenttest.get().fail(result.getThrowable());
		extenttest.get().log(Status.FAIL,"Test case Failed");		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		extenttest.get().log(Status.SKIP, "Testcase Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		extent.flush();                                                   // stop listeners monitoring
	}
	
	

}
