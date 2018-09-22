package selenium.framework.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import selenium.framework.common.PageControls;


/**
 * ClassName:HomePage
 * Description:This class extends PageControls
 * @author Mgalla
 *
 */


public class HomePage extends PageControls{
	private static final By WELCOME_ADMIN=By.xpath(".//a[@id='welcome' and contains(.,'Welcome Admin')]");
	private static final By SIGNOUT_BUTTON=By.xpath("//a[@href='/index.php/auth/logout']");
	private static final String HOME_TITLE = "OrangeHRM";
	
	
	
//	private static final  By MEMBERS_MENU_BUTTON=By.xpath("//li[@id='redirectToMembers']//a");
//	//private static final  By SETTINGS_MENU_BUTTON=By.linkText("Settings");
//	private static final  By SEARCH_MENU_INPUT=By.id("serachMenuTextConrol");
//	private static final  By PROGRAMS_MENU_BUTTON=By.id("programs");
//	private static final  By REFERENCEDATA_MENU_BUTTON=By.xpath("//ul[@id='thelist']/li[3]/a/b/em");
//	private static final  By ANALYTICS_MENU_BUTTON=By.xpath("//ul[@id='thelist']/li[5]/a/b/em");
	private static final  By HOMEPAGE_LINK=By.xpath("//*[@id='ribbon']//*[@href='#/']");
//	private static final  By HIDECONTENT_BUTTON=By.xpath("//aside[@id='left-panel']/span/i");
//	private static final  By COLLAPSE_MENU_BUTTON=By.id("hide-menu");
//	//private static final  By SIGNOUT_BUTTON="Logout";
//	private static final By PAGE_LOADING = By.xpath("//div[@class='loading' and style='display: block;']");
//	private static final By REFERENCE_DATA_LNK = By.xpath("//a[@href='#/referenceData']");
	/**
	 * Description:This is HomePage constructor. It holds all the element locators in HomePage
	 * @param webDriver
	 */
	ExtentTest test;
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	/**
	 * MethodName:getInstance()
	 * Description: This method used get the instance of HomePage
	 * @return HomePage 
	 * @throws IOException 
	 */
	HomePage getInstance(){
		new HomePage(this.driver).homePageLoaded();
		return new HomePage(this.driver);
	}
/**
 * homePageLoaded()
	 * Description: This method wait until Welcome Admin is displayed
 * @return Boolean
 * @throws IOException 
 */
	public  boolean homePageLoaded(){
	return waitForElement(WELCOME_ADMIN).isDisplayed();
	}
	/**
	 * MethodName:clickOnDashboardMenuButton()
	 * Description:This method is used to click on dashboardMenuButton
	 * @return DashboardPage
	 */
	
	public DashboardPage clickOnDashboardMenuButton(){
		String tmp = getCurrentUrl();
		String tmp1 = tmp.substring(0, tmp.lastIndexOf("/dashboard"));
		driver.navigate().to(tmp1+"/dashboard");
		reportInfo("Redirecting to dashboard page.");
		System.out.println("Redirecting to dashboard page");
		//waitForPageToLoad(PAGE_LOADING);
		//driver.navigate().refresh();
		return new DashboardPage(this.driver);
	}
	/**
	 * MethodName:clickOnAdminMenuButton()
	 * Description:This method is used to click on AdminMenuButton
	 * @return AdminPage
	 */
	
	
	public AdminPage clickOnAdminMenuButton(){
		String tmp = getCurrentUrl();
		String tmp1 = tmp.substring(0, tmp.lastIndexOf("/dashboard"));
		driver.navigate().to(tmp1+"/admin/viewSystemUsers");
		reportInfo("Redirecting to Admin page.");
		System.out.println("Redirecting to Admin page.");
		this.waitforElementnew(30);
		//waitForPageToLoad(PAGE_LOADING);
		return new AdminPage(driver);
	}
	/**
	 * MethodName:clickOnLeaveMenuButton()
	 * Description:This method is used to click on LeaveMenuButton
	 * @return 
	 * @return LeavePage
	 */
	public LeavePage clickOnLeaveMenuButton(){
		String tmp = getCurrentUrl();
		String tmp1 = tmp.substring(0, tmp.lastIndexOf("/dashboard"));
		driver.navigate().to(tmp1+"/leave/viewLeaveList");
		reportInfo("Redirecting to programs page.");
		//waitForPageToLoad(PAGE_LOADING);
		return new LeavePage(driver);
	}
	/**
	 * MethodName:clickOnSignOutButton()
	 * Description:This method is used to click on SignOut Button
	 * @throws IOException 
	 */
	public void clickOnSignOutButton() throws IOException{
		click(WELCOME_ADMIN);
		click(SIGNOUT_BUTTON);
	}

/**
 * MethodName:verifyHomePage()
 * Description: This method is used to verify HomePage Title
 */
	public void verifyHomePage(){
		System.out.println(driver.getTitle());
		Assert.assertEquals(HOME_TITLE, driver.getTitle());
	}
	
	
	
	
	
	
	
	
	
	
	
	
/*	*//**
	 * MethodName:enterSearchMenuInput()
	 * Description:This method is used to enter search input
	 * @throws IOException 
	 *//*
	public void enterSearchMenuInput() throws IOException{
		type(SEARCH_MENU_INPUT, "ReferenceData");
	}
	
	public ReferenceDataPage clickonReferenceData(){
		String tmp = getCurrentUrl();
		String tmp1 = tmp.substring(0, tmp.lastIndexOf("#/"));
		driver.navigate().to(tmp1+"#/referenceData");
		reportInfo("Redirecting to referenceData page.");
		
		System.out.println("Redirecting to referenceData page");
		this.waitForPageToLoad(PAGE_LOADING);
		return new ReferenceDataPage(driver);
	}
	*//**
	 * MethodName:clickOnReferenceDataMenuButton()
	 * Description:This method is used to click on ReferenceDataMenuButton
	 * @return 
	 *//*
	
	*//**
	 * clickOnAnalyticsMenuButton()
	 * Description:This method is used to click on AnalyticsMenuButton
	 * @throws IOException 
	 *//*
	public void clickOnAnalyticsMenuButton() throws IOException{
		click(ANALYTICS_MENU_BUTTON);
	}
	
	*//**
	 * clickOnHideContentButton()
	 * Description:This method is used to click on HideContent Button
	 * @throws IOException 
	 *//*
	public void clickOnHideContentButton() throws IOException{
		click(HIDECONTENT_BUTTON);
	}
	*//**
	 * clickOnCollapseMenuButton()
	 * Description:This method is used to click on Collapse Button
	 * @throws IOException 
	 *//*
	public void clickOnCollapseMenuButton() throws IOException{
		click(COLLAPSE_MENU_BUTTON);
	}
	*//**
	 * MethodName:clickOnSignOutButton()
	 * Description:This method is used to click on SignOut Button
	 * @throws IOException 
	 *//*
	public void clickOnSignOutButton() throws IOException{
		click(SIGNOUT_BUTTON);
	}

*//**
 * MethodName:verifyHomePage()
 * Description: This method is used to verify HomePage Title
 *//*
	public void verifyHomePage(){
		System.out.println(driver.getTitle());
		Assert.assertEquals(HOME_TITLE, driver.getTitle());
	}
*/	
	
	
	
	
	
	
	/**
	 * MethodName:clickOnHomepageLink()
	 * Description:This method is used to click on HomePage link
	 * @throws IOException 
	 */
	public void clickOnHomepageLink() throws IOException{
		click(HOMEPAGE_LINK);
	}
}
