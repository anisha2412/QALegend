package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;                                      // ExtentReports cls obj declrd
	
	public static ExtentReports getReportObject() {                   // ExtentReports - method retrn type
		String path = System.getProperty("user.dir")+ "\\test-output\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);  // pass path to another inbuit cls through obj creatn
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Result");
		extent = new ExtentReports();                           // ExtentReports cls obj initaliztn
		extent.attachReporter(reporter);      					// attch report to specified location
		extent.setSystemInfo("Tester", "Anisha Madhu");         // role and name
		return extent;	
	}
}
