package com.PigeonHole.Reports;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.PigeonHole.FunctionalLibrary.GenericMethods;


public class Listeners extends GenericMethods implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot 
		String s=result.getName().toString().trim();
		GenericMethods.getSnapShot(s);
		}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
