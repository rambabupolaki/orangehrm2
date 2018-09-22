package selenium.framework.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import selenium.framework.common.PageControls;

public class UsersPage extends PageControls{
	public final By ADDUSER_BUTTON=By.xpath(".//input[@id='btnAdd']");
	public final By USERROLE_DROPDOWN=By.xpath(".//select[@id='systemUser_userType']");
	public final By EMPLOYEE_NAME=By.xpath(".//input[@id='systemUser_employeeName_empName']");
	public final By USER_NAME=By.xpath(".//input[@id='systemUser_userName']");
	public final By STATUS_DROPDOWN=By.xpath(".//select[@id='systemUser_status']");
	public final By PASSWORD=By.xpath(".//input[@id='systemUser_password']");
	public final By CONFIRM_PASSWORD=By.xpath(".//input[@id='systemUser_confirmPassword']");
	public final By SAVE_BUTTON=By.xpath(".//input[@value='Save']");
	public final By CANCEL_BUTTON=By.xpath(".//input[@id='btnCancel']");
	public final By USERNAME_SEARCH_INPUT=By.xpath(".//input[@id='searchSystemUser_userName']");
	public final By SEARCH_BUTTON=By.xpath(".//input[@id='searchBtn']");
	public final By VALIDATE_USERNAME=By.xpath(".//table[@id='resultTable']/tbody/tr/td[2]/a");
	public final By VALIDATE_EMPLOYEE_ERROR=By.xpath("//input[@id='systemUser_employeeName_empName']//following-sibling::span");

	/**
	 *  Description:This is Users page constructor. It holds all the element locators in Users page
	 * @param webDriver
	 */
	public UsersPage(WebDriver driver) {
	super(driver);
	}
	/**
	 * MethodName:clickOnAddUserButton() 
	 * Description: This method is used to click on Add User button
	 */
	public void clickOnAddUserButton() 
	{
		this.click(ADDUSER_BUTTON);
		this.waitforElementnew(30);
		//waitForPageToLoad(PAGE_LOADING);
		reportInfo("Clicking on Add User Button.");
	}
	
	public String selectUserRoleDropDown(){
		String testData=this.getFirstDropDownLabel(USERROLE_DROPDOWN);
		this.selectDropdown(USERROLE_DROPDOWN, testData);
		reportInfo("Selecting Primary user role :"+testData);
		this.waitforElementnew(40);
		//this.waitForPageToLoad(PAGE_LOADING);
		return testData;
	}
	
	/**
	 * MethodName: enterEmployeeNameInput()
	 * Description: This method used to enter employee Name
	 * @param employeeName
	 */
	public void enterEmployeeNameInput(String employeeName)
	{
		this.clear(EMPLOYEE_NAME);
		this.type(EMPLOYEE_NAME , employeeName );
		this.enter(EMPLOYEE_NAME);
		this.waitforElementnew(30);
		//this.pause(1000);
		reportInfo("Entering Employee Name. :"+employeeName );
	
	 //this.getFirstDropDownLabel(EMPLOYEE_NAME);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	public void enterUserNameInput(String userName)
	{
		this.clear(USER_NAME);
		this.type(USER_NAME , userName );
		reportInfo("Entering Employee Name. :"+userName );
		this.waitforElementnew(100);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	public String selectStatusDropDown(){
		String testData=this.getFirstDropDownLabel(STATUS_DROPDOWN);
		this.selectDropdown(STATUS_DROPDOWN, testData);
		reportInfo("Selecting Primary status :"+testData);
		this.waitforElementnew(40);
		//this.waitForPageToLoad(PAGE_LOADING);
		return testData;
	}
	public void enterPasswordInput(String password)
	{
		this.clear(PASSWORD);
		this.type(PASSWORD , password );
		reportInfo("Entering Password. :"+password );
		this.waitforElementnew(30);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	public void enterConfirmPasswordInput(String confirmPasswordInput)
	{
		this.clear(CONFIRM_PASSWORD);
		this.type(CONFIRM_PASSWORD , confirmPasswordInput );
		reportInfo("Entering Confirm password. :"+confirmPasswordInput );
		this.waitforElementnew(100);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	public void clickOnSaveButton(){
		this.click(SAVE_BUTTON);
		reportInfo("Clicking On Save button." );
	//	this.waitforElementnew(30);
		//waitForPageToLoad(PAGE_LOADING);
	}
	/**
	 * MethodName: enterQuickSearchInput() 
	 * Description: This method is used to enter QuickSearch Input
	 * @param testdata
	 */
	public void enterQuickUserNameSearchInput(String testdata) {
		this.clear(USERNAME_SEARCH_INPUT);
		this.type(USERNAME_SEARCH_INPUT, testdata);
		reportInfo("Entering User name Search input :"+testdata);
		this.waitforElementnew(40);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	/**
	 * MethodName: clickOnSearchButton() 
	 * Description: This method is used to click On Serach button
	 * 
	 */
	public void clickOnSearchButton() {
		this.click(SEARCH_BUTTON);
		//this.waitForPageToLoad(PAGE_LOADING);
		this.waitforElementnew(30);
		reportInfo("Clicking On Search Button.");
	}
	public String getText(By by,String testData){
		reportInfo(testData);
		return this.getText(by);
	}
	public void assertText(String expected, String actual, By by, String message){
		if(expected.equalsIgnoreCase(actual)){
			reportPassedStatus("Expected [ "+expected+" ] : Actual [ "+actual+" ]");
			String successFilePath = elementScreenshot(by);
			reportSuccessScreenshot(successFilePath,message);
		}else{
			reportFailedStatus("Expected [ "+expected+" ] : Actual [ "+actual+" ]");
			String failureFilePath = driverScreenshot();
			reportFailureScreenshot(failureFilePath);
		}
	}	
}


