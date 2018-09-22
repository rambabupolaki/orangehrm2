package selenium.framework.common;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

public class ExtentTestNGIReporterListener implements IReporter {

	private static final String OUTPUT_FOLDER = "build/reports/";
	protected ExtentReports extent;

	Properties prop = PropertiesFileReader.getReportingServerProperties();

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {

				ITestContext context = r.getTestContext();

				try {
					String className = context.getAllTestMethods()[0].getRealClass().getSimpleName();
					init(className);
					buildTestNodes(context.getFailedConfigurations(), Status.FAIL);
					buildTestNodes(context.getFailedTests(), Status.FAIL);
					buildTestNodes(context.getSkippedTests(), Status.SKIP);
					buildTestNodes(context.getPassedTests(), Status.PASS);
				} catch (Exception e) {
					e.printStackTrace();
				}

				extent.flush();

			}
		}

	}

	private void init(String fileName) {
		String reportFolder = OUTPUT_FOLDER + "/ExtentReports/";

		if (!new File(reportFolder).exists())
			new File(reportFolder).mkdir();

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFolder + fileName + ".html");
		htmlReporter.config().setDocumentTitle(prop.getProperty("documentTitle") + " " + getCurrentDate());
		htmlReporter.config().setReportName(prop.getProperty("reportName") + " " + getCurrentDate());

		if (prop.getProperty("serverReporting").equalsIgnoreCase("true")) {
			ExtentXReporter xReporter = new ExtentXReporter(prop.getProperty("databaseUrl").trim());
			xReporter.config().setServerUrl(prop.getProperty("appUrl").trim());
			xReporter.config().setProjectName(prop.getProperty("projectName"));
			if (fileName.contains("Verify")) {
				xReporter.config().setReportName(fileName.substring(fileName.indexOf("Verify"), fileName.length()));
			} else {
				xReporter.config().setReportName(fileName);

			}

			extent = new ExtentReports();

			extent.attachReporter(htmlReporter, xReporter);

		} else {
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

		}
	}

	private void buildTestNodes(IResultMap tests, Status status) throws IOException {
		ExtentTest test;
		if (tests.size() > 0) {
			Set<ITestResult> results = tests.getAllResults();
			SortedSet<ITestResult> ss = new TreeSet<>();
			for (ITestResult r : results) {
				ss.add(r);
			}

			for (ITestResult result : ss) {

				test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());

				for (String s : Reporter.getOutput(result)) {
					if (s.contains("./Reports/Screenshot/")) {
						String tmp = s.substring(s.indexOf("./")+1, s.indexOf(".png")+4);
						String filePath = System.getProperty("user.dir")+"build/reports/surefire-reports/html"+tmp;
						String title = s.substring(s.indexOf("ScreenShot : "), s.indexOf("</a>"));
						test.addScreenCaptureFromPath(filePath, title);
					} else {
						test.log(Status.INFO, s);
					}
				}

				for (String group : result.getMethod().getGroups()) {
					if (group.contains("mod")) {
						test.assignCategory("Module-" + group.split("-")[1]);
					} else if (group.contains("auth")) {
						test.assignAuthor(group.split("-")[1]);
					} else {
						test.assignCategory(group);
					}
				}

				if (result.getThrowable() != null) {
					

					String er = result.getThrowable().getClass().getName().replaceAll("<", "-");
					String msg = result.getThrowable().toString().replaceAll("<", "-");

					String et = "<details style=\"color: red;\"><summary><b>ERROR : " + er + "</b></summary>" + msg;

					System.err.println("ERROR : " + msg);
					System.out.println("============================");
					StackTraceElement[] err = result.getThrowable().getStackTrace();

					for (int i = 0; i < err.length; i++) {

						System.err.println("===" + err[i].toString());
						et = et + err[i].toString() + "<br>";
					}

					et = et + "</details>";
					test.log(status, et);
					test.log(status, result.getThrowable());
				}

				test.log(status,
						result.getMethod().getMethodName() + " Test " + status.toString().toLowerCase() + "ed");

				test.getModel().setStartTime(getTime(result.getStartMillis()));
				test.getModel().setEndTime(getTime(result.getEndMillis()));
			}

		}

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	private Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

}