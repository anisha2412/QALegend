package TestScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
    int counter = 0;
    int retryLimit = 4;                         // If a test case fails, it can be retried up to 4 times

    @Override
    public boolean retry(ITestResult result) {  // result parameter contains information about the failed test case
        
        if (counter < retryLimit) {
            counter++;                          // Increment counter variable up to the retry limit
            return true;
        }
        return false;
    }
}
