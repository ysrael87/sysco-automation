package com.sysco.framework;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.sma.utils.Utility;

public class TestNGCustom extends TestListenerAdapter {

	// Take screen shot only for failed test case
	@Override
	public void onTestFailure(ITestResult tr) {
		// Capture screenshot on every failur
		if (!(tr.getThrowable() == null)) {
			Utility.CaptureScreenShotAndPutInResult(tr);
		}
		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		try {
			Utility.CaptureScreenShotAndPutInResult(tr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		try {
			Utility.CaptureScreenShotAndPutInResult(tr);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
