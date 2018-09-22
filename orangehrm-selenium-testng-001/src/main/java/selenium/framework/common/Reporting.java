package selenium.framework.common;

import java.io.IOException;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

/**
 * 
 * @author Pravin Lokeshwar
 *
 */

public class Reporting extends WebDriverFactory {
	/**
	 * MethodName:reportSuccessScreenshot() Description:This method takes the
	 * Success Screenshot
	 * 
	 * @param screenshotFilePath
	 * 
	 * 
	 */

	
	
	
	public void reportSuccessScreenshot(String screenshotFilePath, String message){
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"" + screenshotFilePath + "\">ScreenShot : "+message+"<br></a>");
		System.out.println("Reporting Success Screenshot.  FilePath : "+screenshotFilePath);
		
	}
	
	
	
	

	/**
	 * MethodName: reportFailureScreenshot() Description:This method takes the
	 * Failure Screenshot
	 * 
	 * @param screenshotFilePath
	 * @throws IOException 
	 */
	public void reportFailureScreenshot(String screenshotFilePath){
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		/*
		 * Reporter.log("<a href=\"" + screenshotFilePath +
		 * "\">ScreenShot<img src=\"file:///" + screenshotFilePath +
		 * "\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
		 */
		Reporter.log("<a href=\"" + screenshotFilePath + "\">ScreenShot<br></a>");
		System.err.println("Reporting Failure Screenshot.  FilePath : "+screenshotFilePath);
		
	}
	
	public void reportFailureScreenshot(String screenshotFilePath, String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		/*
		 * Reporter.log("<a href=\"" + screenshotFilePath +
		 * "\">ScreenShot<img src=\"file:///" + screenshotFilePath +
		 * "\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
		 */
		Reporter.log("<a href=\"" + screenshotFilePath + "\">"+message+"<br></a>");
		System.err.println("Reporting Failure Screenshot.  FilePath : "+screenshotFilePath);
	}

	/**
	 * MethodName:reportInfo() Description:This method gives the information
	 * about the generated report.
	 * 
	 * @param info
	 */

	public void reportInfo(String info) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: darkblue;font-size: 14px;'>" + info + "<br></span>");
		System.out.println(info);
	}

	/**
	 * MethodName:reportPassedStatus() Description:This method gives the Passed
	 * status of a report.
	 * 
	 * @param status
	 */

	public void reportPassedStatus(String status) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: green;font-size: 14px;'>" + status + "<br></span>");
		System.out.println("PASSED :  "+status);
	}
	/**
	 * MethodName:reportFailedStatus() Description:This method gives the Passed
	 * status of a report.
	 */
	public void reportFailedStatus(String status) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: red;font-size: 18px;'><br>" + status + "<br></span>");
		System.err.println("FAILED :  "+status);
	}

	/**
	 * MethodName:reportFailedStatus() Description:This method gives the Passed
	 * status of a report.
	 */

	public void reportFailedStatus() {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: red;font-size: 14px;'><b>TEST FAILED<br></span>");
		System.err.println("FAILED");
	}
	
	public void ReporterTextBold(String info) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: darkblue;font-size: 14px;'><b>" + info + "</b><br></span>");
		System.out.println(info);
	}
	
	public void ReporterTextError(String info) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: red;font-size: 14px;'><b>" + info + "</b><br></span>");
		System.out.println(info);
	}
	
	public void ReporterTextError(Exception e) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: red;font-size: 14px;'><b>" + e + "</b><br></span>");
		System.out.println(e);
	}

}