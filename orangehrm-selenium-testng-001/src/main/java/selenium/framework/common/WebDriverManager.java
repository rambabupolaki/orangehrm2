package selenium.framework.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverManager {
	// Thread local variable containing reference to WebDriver instance for each
	// thread
	private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected WebDriver initialValue() {
			return WebDriverFactory.createInstance();
		}
	};

	/**
	 * Return reference to an instance of WebDriver for that specific thread.
	 * 
	 * @return the webDriver
	 */
	public static WebDriver getWebDriver() {
		return webDriver.get();
	}

	/**
	 * Removes the instance of WebDriver for that specific thread.
	 * 
	 * @return the webDriver
	 */
	static void removeWebDriver() {
		if(webDriver != null){
		webDriver.get().quit();
		webDriver.remove();
		}
	}

	/**
	 * Register a listener to given WebDriver instance.
	 * 
	 * @param webDriver
	 * @param eventListener
	 */
	static EventFiringWebDriver registerEventListener(WebDriver webDriver,
			WebDriverEventListener eventListener) {
		// Creating EventFiringWebDriver instance and Register the Listener to
		// it...
		return new EventFiringWebDriver(webDriver).register(eventListener);
	}
}
