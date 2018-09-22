package selenium.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.framework.common.PageControls;

public class AdminPage extends PageControls
{
	public final By USERMANAGEMENT=By.linkText(".//a[@id='menu_admin_UserManagement']");
	public final By USER_BUTTON=By.linkText(".//a[@id='menu_admin_viewSystemUsers']");
	
	
	/**
	 *  Description:This is Admin page constructor. It holds all the element locators in Admin page
	 * @param webDriver
	 */
	public AdminPage(WebDriver driver) {
	super(driver);
	}
	
	
	/*public void clickOnUsers()
	{
		this.moveToElement(USERMANAGEMENT);
		reportInfo("Move to user management");
		this.click(USER_BUTTON);
		//this.waitForPageToLoad(PAGE_LOADING);
	}*/
	public UsersPage clickOnUsersMenuButton(){
		String tmp = getCurrentUrl();
		String tmp1 = tmp.substring(0, tmp.lastIndexOf("/viewSystemUsers"));
		driver.navigate().to(tmp1+"/viewSystemUsers");
		System.out.println("Redirecting to Users page.");
		//waitForPageToLoad(PAGE_LOADING);
		return new UsersPage(driver);
	}
	public JobPage clickOnjobMenuButton(){
		String tmp = getCurrentUrl();
		String tmp1 = tmp.substring(0, tmp.lastIndexOf("/viewSystemUsers"));
		driver.navigate().to(tmp1+"/viewJobTitleList");
		System.out.println("Redirecting to Job page.");
		//waitForPageToLoad(PAGE_LOADING);
		return new JobPage(driver);
	}
}