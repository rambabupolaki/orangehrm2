package selenium.framework.common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * ClassName:PageControls Description:This class extends Reporting
 * 
 * @author Pravin Lokeshwar
 *
 */
public class PageControls extends Reporting {

	/**
	 * Description:This is PageControls constructor. It holds all the element
	 * locators in PageControls
	 */
	protected WebDriver driver;

	public PageControls(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * MethodName:loadUrl() Description:This method used to get the webPage url
	 * 
	 * @param url
	 */
	public void loadUrl(String url) {
		System.err.println(getDate()+"- Loading Url : "+url+" "+driver.toString());
		driver.get(url);
		System.err.println(getDate()+"- Url Loaded : "+url+" "+driver.toString());
	}

	/**
	 * MethodName:loadUrl() Description:This method used to get the current
	 * webPage url
	 * 
	 * @return String
	 */
	public String getCurrentUrl() {
		System.err.println(getDate()+"- Getting current URL."+" "+driver.toString());
		String tmp = driver.getCurrentUrl();
		System.err.println(getDate()+"- Current Url returned : "+tmp+" "+driver.toString());
		return tmp;
	}
	/**
	 * MethodName:getRowSize() Description:This method used to get Table row size 
	 * @return int
	 */
	public int getRowSize(By by){
		  int rowSize = driver.findElements(by).size();
		return rowSize;	 
		}

	/**
	 * MethodName:getPageTitle() Description:This method used to get the page
	 * title
	 * 
	 * @return String
	 */
	public String getPageTitle() {
		System.err.println(getDate()+"- Getting Page Title."+" "+driver.toString());
		String tmp = driver.getTitle();
		System.err.println(getDate()+"- Current Page Title : "+tmp+" "+driver.toString());
		return tmp;
	}

	/**
	 * MethodName:closeBrowser() Description:This method used to close the
	 * Browser
	 */
	public void closeBrowser() {
		String tmp = driver.toString();
		System.err.println(getDate()+"- Closing browser.  Thread ID : "+driver);
		driver.quit();
		System.err.println(getDate()+"- Browser Closed.  Thread ID : "+tmp);
		
	}

	/**
	 * MethodName:click() Description:This method used to click on webElement
	 * 
	 * @param by
	 */
	public void click(By by) {

		System.err.println(getDate()+"- Clicking on "+by.toString()+" - "+driver.toString());
		waitForElement(by).click();
		System.err.println(getDate()+"- Clicked on "+by.toString()+" - "+driver.toString());
	}

	/**
	 * MethodName:getText() Description:This method used to get the current
	 * webElement text
	 * 
	 * @param by
	 * @return String
	 */
	public String getText(By by) {
		System.err.println(getDate()+"- Getting Text from : "+by.toString()+" - "+driver.toString());
		String tmp = waitForElement(by).getText();
		System.err.println(getDate()+"- Got Text from : "+by.toString()+" : "+tmp);
		return tmp;
	}

	/**
	 * MethodName:check() Description:This method used to Check/UnCheck the
	 * CheckBox
	 * 
	 * @param by
	 */
	public void check(By by) {
		if (!(driver.findElement(by).isSelected()))
			waitForElement(by).click();
		System.err.println(getDate()+"- Clicked on "+by.toString()+" - "+driver.toString());
	}

	public void uncheck(By by) {
		if (driver.findElement(by).isSelected())
			waitForElement(by).click();
			pause(2000);
		System.err.println(getDate()+"- Clicked on "+by.toString()+" - "+driver.toString());
	}

	/**
	 * MethodName:type() Description:This method used to enter text to the input
	 * fields
	 * 
	 * @param by
	 * @param testdata
	 */
	public void type(By by, String testdata) {
		
		
		System.err.println(getDate()+"- Entering Data "+testdata+" on "+by.toString()+" - "+driver.toString());
		waitForElement(by).sendKeys(testdata);
		System.err.println(getDate()+"- Entered Data "+testdata+" on "+by.toString()+" - "+driver.toString());
		
	}

	public void type(By by, Keys enter) {
		System.err.println(getDate()+"- Entering Key "+enter+" on "+by.toString()+" - "+driver.toString());
		waitForElement(by).sendKeys(enter);
		System.err.println(getDate()+"- Entered key "+enter+" on "+by.toString()+" - "+driver.toString());

	}
	

	/**
	 * MethodName:clear() Description:This method used to clear text in the
	 * input fields
	 * 
	 * @param by
	 */
	public void clear(By by) {
		System.err.println(getDate()+"- Clearing value from "+by.toString()+" - "+driver.toString());
		waitForElement(by).clear();
		System.err.println(getDate()+"- Cleared value from "+by.toString()+" - "+driver.toString());


	}

	/**
	 * MethodName:moveToElement() Description:This method used to move the
	 * mouseOver to WebElement
	 * 
	 * @param by
	 */
	public void moveToElement(By by) {
		System.err.println(getDate()+"- Moving to Element "+by.toString()+" - "+driver.toString());
		
		WebElement e = driver.findElement(by);
		Actions actions = new Actions(driver);
		actions.moveToElement(e);
		System.err.println(getDate()+"- Moved to Element "+by.toString()+" - "+driver.toString());
		
	}
	public void enter(By by){
		System.err.println(getDate()+"- pressing enter key"+by.toString()+" - "+driver.toString());
		WebElement textbox = driver.findElement(by);
		
		try{
			
			textbox.sendKeys(Keys.ENTER);
			
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page",label +"is set with value" +value,"PASS");
		}catch(Exception e){
			e.printStackTrace();
		//	reportEvent.Status(el.getClassName().toString().replace("com.uhg.vbr.panels.", "")+"Page",label +"is NOT set with value" +value,"FAIL ");
		}
		System.err.println(getDate()+"- pressed enter key"+by.toString()+" - "+driver.toString());
	}
	/**
	 * MethodName:selectDropdown() Description:This method used select the value
	 * from DropDown
	 * 
	 * @param by
	 * @param testData
	 */
	public void selectDropdown(By by, String testData) {
		System.err.println(getDate()+"- Selecting Dropdown "+by.toString()+" - "+driver.toString());
		Select select = new Select(waitForElement(by));
		try {

			select.selectByValue(testData);

		} catch (Exception e) {
			select.selectByVisibleText(testData);
		}
		System.err.println(getDate()+"- Selected Dropdown "+by.toString()+" - "+driver.toString());
	}

	public String getFirstDropDownValue(By by) {
		System.err.println(getDate()+"- Selecting Dropdown "+by.toString()+" - "+driver.toString());
		int count = 0;
		Select select = new Select(waitForElement(by));
		List<WebElement> options = select.getOptions();
		for (WebElement e : options) {
			count = count + 1;
			if (count == 4) {
				return e.getAttribute("value");
			}
		}
		System.out.println("returning null");
		System.err.println(getDate()+"- Selected Dropdown "+by.toString()+" - "+driver.toString());
		return null;
	}

	public String getFirstDropDownLabel(By by) {
		System.err.println(getDate()+"- Selecting Dropdown "+by.toString()+" - "+driver.toString());
		int count = 0;
		Select select = new Select(waitForElement(by));
		List<WebElement> options = select.getOptions();
		for (WebElement e : options) {
			count = count + 1;
			if (count == 2) {
				return e.getAttribute("label");
			}
		}
		System.out.println("returning null");
		System.err.println(getDate()+"- Selected Dropdown "+by.toString()+" - "+driver.toString());
		return null;
	}

	public List<WebElement> getWebElementList(By by) {
		return driver.findElements(by);
	}

	/**
	 * MethodName:pause() Description:This method wait for specified amount of
	 * time
	 * 
	 * @param i
	 * @throws InterruptedException
	 */
	public void pause(int i) {

		try {
			System.err.println(getDate()+"- Pausing Execution for "+i+" MS - "+driver.toString());
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void elementHighlighter(By by) {
		System.err.println(getDate()+"- Highlighting Element "+by.toString()+" - "+driver.toString());
		WebElement el = waitForElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int iCnt = 0; iCnt < 10; iCnt++) {
			js.executeScript("arguments[0].style.border='4px groove green'", el);
			js.executeScript("arguments[0].style.border=''", el);
		}
		System.err.println(getDate()+"- Element Highlighted "+by.toString()+" - "+driver.toString());
	}

	/**
	 * MethodName:elementScreenshot() Description:This method takes the element
	 * Screenshot
	 * 
	 * @param by
	 * @param fileName
	 * @return String
	 */
	public String elementScreenshot(By by) {
		System.err.println(getDate()+"- Taking Screenshot "+by.toString()+" - "+driver.toString());
		String fileName = String.valueOf(System.currentTimeMillis());
		// String path = "./target/surefire-reports/html/Reports/Screenshot/";
		String path = System.getProperty("user.dir") + "/build/reports/ExtentReports/Screenshot/";

		WebElement el = waitForElement(by);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='4px groove green'", el);

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(path + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Failure in taking screenshot.");
			e.printStackTrace();
		}
		System.err.println(getDate()+"- Screenshot Captured"+by.toString()+" - "+driver.toString());
		return "./Screenshot/" + fileName + ".png";

	}

	/**
	 * MethodName:driverScreenshot() Description:This method takes the driver
	 * Screenshot
	 * 
	 * @param fileName
	 * @return
	 */
	public String driverScreenshot() {
		System.err.println(getDate()+"- Taking  Driver Screenshot "+" - "+driver.toString());
		String fileName = String.valueOf(System.currentTimeMillis());
		String path = System.getProperty("user.dir") + "/build/reports/ExtentReports/Screenshot/";

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(path + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Failure in taking screenshot.");
			e.printStackTrace();
		}
		System.err.println(getDate()+"-Driver Screenshot Captured "+" - "+driver.toString());
		return path + fileName + ".png";

	}

	/**
	 * MethodName:getAttribute() Description:This method get Attribute value
	 * 
	 * @param by
	 * @param attributeType
	 * @return String
	 */
	public String getAttribute(By by, String attributeType) {
		System.err.println(getDate()+"- Fetching Attribute Value "+by.toString()+" - "+driver.toString());
		String tmp = "";
		if (attributeType.equalsIgnoreCase("href")) {
			tmp = this.waitForElement(by).getAttribute("href");
		}
		System.err.println(getDate()+"- Returned Attribute Value "+by.toString()+" - "+driver.toString());
		return tmp;

	}

	/**
	 * MethodName:waitForElement() Description:This method wait for required
	 * WebElement
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement waitForElement(By by) throws NoSuchElementException {
		System.err.println(getDate()+" Waiting for Element to Load "+by.toString()+" - "+driver.toString());

		for (int i = 1; i < 100; i++) {
			try {
				this.driver.findElement(by).isDisplayed();
				this.driver.findElement(by).isEnabled();
				System.err.println(getDate()+" Element Found "+by.toString()+" - "+driver.toString());
				
				return this.driver.findElement(by);
			} catch (Exception e) {
				System.err.println(getDate()+" Wait for Element Exception "+e.getLocalizedMessage()+" - "+driver.toString());
				System.err.println(getDate()+" Element Not Found Waiting.");
				pause(300);
			}

		}

		ReporterTextError(new NoSuchElementException("Element Not Found : " + by));
		reportFailureScreenshot(driverScreenshot(), "SCREENSHOT : FAILED");
		System.err.println(getDate()+"- Element not found after waiting "+by.toString()+" - "+driver.toString());
		return this.driver.findElement(by);

	}

	/**
	 * MethodName:waitForPageToLoad() Description:This method wait for page to
	 * Load
	 * 
	 * @param by
	 */
	public void waitForPageToLoad(By by) {
		System.err.println(getDate()+" Waiting for Element not to be present.  "+by.toString()+" - "+driver.toString());
		
		pause(10000);
		
		/*for (int i = 1; i < 100; i++) {
			try {
				driver.findElement(by).isDisplayed();
				System.err.println(getDate()+" Element Found.  Waiting.  "+by.toString()+" - "+driver.toString());
				Thread.sleep(50);
			} catch (Exception e) {
				System.err.println(getDate()+" Element not to be present. Break. "+by.toString()+" - "+driver.toString());
				break;
			}

		}*/

	}

	public void waitForPageToLoad(By by, boolean flag) {
		System.err.println(getDate()+" Waiting for Page to Load.  "+by.toString()+" - "+driver.toString());
		if (flag) {
			for (int i = 1; i < 100; i++) {
				try {
					driver.findElement(by).isDisplayed();
					Thread.sleep(10);
				} catch (Exception e) {
					break;
				}
			}
		}
	}

	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250);");
		System.out.println("Page is Scrolling down");
	}
	
	public  void scrollToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 500);");
        
    }
	
	private Date getDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	public boolean isEnabled(By by){
		return this.driver.findElement(by).isEnabled();
	}
public void waitforElementnew(int i){
	driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
}
public void uploadFile(By by, String imagepath) throws Exception
{
	 // Specify the file location with extension
  	 StringSelection sel = new StringSelection(imagepath);
  	   // Copy to clipboard
  	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	WebElement browse=driver.findElement(by);
	browse.click();
	// Create object of Robot class
	 Robot robot = new Robot();
	 Thread.sleep(1000);
	      
	  // Press Enter
	 robot.keyPress(KeyEvent.VK_ENTER);
	 
	// Release Enter
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	  // Press CTRL+V
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 
	// Release CTRL+V
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	 Thread.sleep(1000);
	        
	        // Press Enter 
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	pause(3000);
}

}