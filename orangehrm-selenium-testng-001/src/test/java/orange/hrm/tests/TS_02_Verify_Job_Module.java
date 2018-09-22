package orange.hrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import selenium.framework.common.CommonMethods;
import selenium.framework.common.WebDriverManager;
import selenium.framework.pages.AdminPage;
import selenium.framework.pages.HomePage;
import selenium.framework.pages.JobPage;
import selenium.framework.pages.LoginPage;
import selenium.framework.pages.UsersPage;
import selenium.framework.pojo.JobPojo;
import selenium.framework.pojo.UserPojo;
import selenium.framework.validations.Success_Validations;

public class TS_02_Verify_Job_Module extends CommonMethods {
	String className = this.getClass().getSimpleName();
	LoginPage loginPage = null;
	HomePage homePage = null;
	AdminPage adminPage = null;
	JobPage jobPage = null;
	String expected=null;
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() throws IOException {
		driver = WebDriverManager.getWebDriver();
		System.out.println(className + " : " + driver);
		loginPage = new LoginPage(driver);
		homePage = loginPage.login();
		System.out.println("Login success");
		adminPage = homePage.clickOnAdminMenuButton();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowser();
	}

	@BeforeMethod
	public void beforeMethod() {

		jobPage=adminPage.clickOnjobMenuButton();
		
	}
	@AfterMethod
	public void afterMethod() {

	}
@Test(priority = 0, description = "This testcase is related to Add Job with all fields", groups = {
		"mod-Job", "auth-Anusha" })
public void TC_01_ValidateaddingJobWithAllFields() throws Exception
{
	String testcaseName = new Object() {
	}.getClass().getEnclosingMethod().getName();
	ReporterTextBold("Executing Test Case : " + testcaseName);
	JobPojo jp=new JobPojo();
	jobPage.clickOnAddJOBButton();
	jobPage.enterJobTitleInput(jp.getJobTitle());
	jobPage.enterJobDescriptionInput(jp.getJobDescription());
	jobPage.jobSpecificationUpload(jp.getJobSpecification());
	jobPage.enterNoteInput(jp.getNote());
	jobPage.clickOnSaveButton();
String expected = Success_Validations.JOBCREATEPOPUP;
String actual=jobPage.getText(jobPage.JOB_SUCCESSFULLY_ADDED_POPUP, "Fetching job creation popup.");
jobPage.assertText(expected, actual, jobPage.JOB_SUCCESSFULLY_ADDED_POPUP, "Validating Job Creation popup");
//Assert.assert(expected, actual, "Validating Job Creation popup Failed.");
}
}