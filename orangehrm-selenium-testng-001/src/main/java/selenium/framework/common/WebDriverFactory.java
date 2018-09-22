package selenium.framework.common;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

public class WebDriverFactory {

	public static Properties CONFIG = null;
	public static URL remoteAddress;
	private static String browser, url;
	 static ExtentTest test;
	static WebDriver createInstance() {
		   WebDriver driver = null;
		   
        CONFIG = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			CONFIG.load(fs);
			if(CONFIG.getProperty("remoteAddress") != null){
			remoteAddress = new URL(CONFIG.getProperty("remoteAddress"));
			}
		
			browser = CONFIG.getProperty("browser");
			url = CONFIG.getProperty("url");
		} catch (Exception e) {
			
			new Reporting().ReporterTextError(e);
			
		}

	//	System.out.println(browser);
		if (browser.equals("firefox"))
			driver = getFirefoxDriver();
		else if (browser.equals("ie"))
			driver = getInternetExplorerDriver();
		else if (browser.equals("chrome")) {
			driver = getChromeDriver();
		} else if (browser.equals("phantomjs")) {
			driver = getPhantomjsDriver();
		}

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
    }

	public void getBrowserInstance() {

		

	}

	/**
	 * Create an instance of InternetExplorerDriver
	 * 
	 * @return
	 */
	private static WebDriver getInternetExplorerDriver() {
		System.out.println("Launching IE Driver.");
		if (remoteAddress != null) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			return new RemoteWebDriver(remoteAddress, capabilities);
		} else {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			// caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			caps.setCapability("ensureCleanSession", true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			return new InternetExplorerDriver(caps);
		}
	}

	/**
	 * Create an instance of FirefoxDriver
	 * 
	 * @return
	 */
	private static WebDriver getFirefoxDriver() {
		System.out.println("Launching Firefox Driver.");
		if (remoteAddress != null) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, new FirefoxProfile());
			return new RemoteWebDriver(remoteAddress, capabilities);
		} else {
			FirefoxProfile profile = new FirefoxProfile();
			return new FirefoxDriver(profile);
		}
	}

	/**
	 * Create an instance of ChromeDriver
	 * 
	 * @return
	 */
	private static WebDriver getChromeDriver() {
		System.out.println("Launching Chrome Driver.");
		if (remoteAddress != null) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			return new RemoteWebDriver(remoteAddress, capabilities);
		} else {
			Map<String, Object> prefs = new HashMap<String, Object>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.default_content_setting_values.notifications", 2);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.setExperimentalOption("prefs", prefs);
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			return new ChromeDriver(options);
		}
	}

	/**
	 * Create an instance of PhantomJs Driver
	 * 
	 * @return
	 */
	private static WebDriver getPhantomjsDriver() {
		System.out.println("Opening phantom js driver");
		if (remoteAddress != null) {
			DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
			return new RemoteWebDriver(remoteAddress, capabilities);
		} else {

			System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "/drivers/phantomjs.exe");
			return new PhantomJSDriver();
		}
	}
	
	
	
}