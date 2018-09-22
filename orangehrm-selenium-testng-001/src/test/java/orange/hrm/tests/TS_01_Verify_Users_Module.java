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
import selenium.framework.pages.LoginPage;
import selenium.framework.pages.UsersPage;
import selenium.framework.pojo.UserPojo;
import selenium.framework.validations.Error_Validations;

public class TS_01_Verify_Users_Module extends CommonMethods {
	String className = this.getClass().getSimpleName();
	LoginPage loginPage = null;
	HomePage homePage = null;
	AdminPage adminPage = null;
	UsersPage usersPage = null;
	String expected = null;
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

		usersPage = adminPage.clickOnUsersMenuButton();
		usersPage.clickOnAddUserButton();

	}

	@AfterMethod
	public void afterMethod() {

	}

	@Test(enabled=true,priority = 0, description = "This testcase is related to Add User with all fields", groups = { "mod-Admin",
			"auth-Anusha" })
	public void TC_01_ValidateaddingUserWithAllFields() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		UserPojo up = new UserPojo();
		
		// usersPage.selectUserRoleDropDown();
		usersPage.enterEmployeeNameInput(up.getEmployeeName());
		usersPage.enterUserNameInput(up.getUserName());
		// usersPage.selectStatusDropDown();
		usersPage.enterPasswordInput(up.getPassword());
		usersPage.enterConfirmPasswordInput(up.getConfirmPassword());
		usersPage.clickOnSaveButton();
		expected = up.getUserName();
		usersPage.enterQuickUserNameSearchInput(up.getUserName());
		usersPage.clickOnSearchButton();
		String actual = usersPage.getText(usersPage.VALIDATE_USERNAME, "Fetching User Name");
		usersPage.assertText(expected, actual, usersPage.VALIDATE_USERNAME, "Validating User Name");
		Assert.assertEquals(expected, actual, "Validating User NAME Failed.");

	}

	@Test(enabled=true,priority = 1, description = "This testcase is related to Add User with mandatory fields", groups = {
			"mod-Admin", "auth-Anusha" })
	public void TC_02_ValidateaddingUserWithMandatoryFields() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		UserPojo up = new UserPojo();
		//usersPage.clickOnAddUserButton();
		// usersPage.selectUserRoleDropDown();
		usersPage.enterEmployeeNameInput(up.getEmployeeName());
		usersPage.enterUserNameInput(up.getUserName());
		//usersPage.clear(usersPage.PASSWORD);
		usersPage.clickOnSaveButton();
		expected = up.getUserName();
		usersPage.enterQuickUserNameSearchInput(up.getUserName());
		usersPage.clickOnSearchButton();
		String actual = usersPage.getText(usersPage.VALIDATE_USERNAME, "Fetching User Name");
		usersPage.assertText(expected, actual, usersPage.VALIDATE_USERNAME, "Validating User Name");
		Assert.assertEquals(expected, actual, "Validating User NAME Failed.");
	}

	@Test(enabled=true,priority = 2, description = "This testcase is related to validate null value in Employee name field", groups = {
			"mod-Admin", "auth-Anusha" })
	public void TC_03_NullValueInEmployeeNameField() {
		String testcaseName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReporterTextBold("Executing Test Case : " + testcaseName);
		UserPojo up = new UserPojo();
		//up.setEmployeeName(" ");
		//usersPage.clickOnAddUserButton();
		// usersPage.selectUserRoleDropDown();
		usersPage.enterEmployeeNameInput("");
		usersPage.enterUserNameInput(up.getUserName());
		usersPage.clickOnSaveButton();
		expected = Error_Validations.USEREMPLOYEENAMEERROR;
		System.out.println(expected);
		String actual = usersPage.getText(usersPage.VALIDATE_EMPLOYEE_ERROR, "Fetching Validation Error");
		System.out.println(actual);
		usersPage.assertText(expected, actual, usersPage.VALIDATE_EMPLOYEE_ERROR, "Validating Validation Error");
		//usersPage.click(usersPage.CANCEL_BUTTON);
		Assert.assertEquals(expected, actual, "Validating Validation Error Failed.");
	}

}
