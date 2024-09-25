package TestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements  IRetryAnalyzer
{
int counter=0; int retrylimt=2;
	

  @Override
	public boolean retry(ITestResult result) {
		if (counter < retrylimt)
		{
			counter ++;
			return true;
		}
		
		return false;
	}

}
