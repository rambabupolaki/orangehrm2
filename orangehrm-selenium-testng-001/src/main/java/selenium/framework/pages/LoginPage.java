package selenium.framework.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import selenium.framework.common.PageControls;

public class LoginPage extends PageControls {
	
	
	public static final String username = "Admin";
	public static final String password = "admin123";
	
	private static final By USERNAME_INPUT = By.id("txtUsername");
	private static final By PASSWORD_INPUT = By.id("txtPassword");
	private static final By LOGIN_BUTTON = By.id("btnLogin");
	//private static final By PAGE_LOADING = By.xpath("//div[@class='loading' and style='display: block;']");

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public HomePage login(){
		type(USERNAME_INPUT, username);
		type(PASSWORD_INPUT, password);
		click(LOGIN_BUTTON); 
		//this.waitForPageToLoad(PAGE_LOADING);
		return new HomePage(driver).getInstance();
	}
	
}