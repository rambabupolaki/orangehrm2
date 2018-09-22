package selenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import selenium.framework.common.PageControls;

public class JobPage extends PageControls{
	public final By ADDJOB_BUTTON=By.xpath(".//input[@id='btnAdd']");
	public final By JOB_TITLE=By.xpath(".//input[@id='jobTitle_jobTitle']");
	public final By JOB_DESCRIPTION=By.xpath(".//textarea[@id='jobTitle_jobDescription']");
	public final By JOB_SPECIFICATION=By.xpath(".//input[@id='jobTitle_jobSpec']");
	public final By NOTE=By.xpath(".//textarea[@id='jobTitle_note']");
	public final By SAVE_BUTTON=By.xpath(".//input[@id='btnSave']");
	public final By JOB_SUCCESSFULLY_ADDED_POPUP=By.xpath("//div[@class='message success fadable']");
	
	public JobPage(WebDriver driver) {
		super(driver);
		}
	public void clickOnAddJOBButton() 
	{
		this.click(ADDJOB_BUTTON);
		this.waitforElementnew(30);
		//waitForPageToLoad(PAGE_LOADING);
		reportInfo("Clicking on Add Job Button.");
	}
	public void enterJobTitleInput(String jobTitle)
	{
		this.clear(JOB_TITLE);
		this.type(JOB_TITLE , jobTitle );
		reportInfo("Entering Job Title. :"+jobTitle );
		this.waitforElementnew(10);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	public void enterJobDescriptionInput(String jobDescription)
	{
		this.clear(JOB_DESCRIPTION);
		this.type(JOB_DESCRIPTION , jobDescription );
		reportInfo("Entering Job Description. :"+jobDescription );
		this.waitforElementnew(10);
		//this.waitForPageToLoad(PAGE_LOADING);
	}
	public void jobSpecificationUpload(String imagepath) throws Exception
	{
		this.uploadFile(JOB_SPECIFICATION, imagepath);
		reportInfo("Selecting file. :"+imagepath );
		this.waitforElementnew(20);
	}
	public void enterNoteInput(String note)
	{
		this.clear(NOTE);
		this.type(NOTE , note );
		reportInfo("Entering Note. :"+note );
		this.waitforElementnew(80);
		
	}
	public void clickOnSaveButton(){
		this.click(SAVE_BUTTON);
		reportInfo("Clicking On Save button." );
		this.waitforElementnew(20);
		//waitForPageToLoad(PAGE_LOADING);
	}
	public String getText(By by,String testData){
		reportInfo(testData);
		return this.getText(by);
	}
	public void assertText(String expected, String actual, By by, String message){
		if(expected.contains(actual)){
			reportPassedStatus("Expected [ "+expected+" ] : Actual [ "+actual+" ]");
			String successFilePath = elementScreenshot(by);
			reportSuccessScreenshot(successFilePath,message);
		}else{
			reportFailedStatus("Expected [ "+expected+" ] : Actual [ "+actual+" ]");
			String failureFilePath = driverScreenshot();
			reportFailureScreenshot(failureFilePath);
		}
	}	
/*	public void checkingWithJobTitle()
	{
		//To locate table
		WebElement table=driver.findElement(By.xpath("//table[@id='resultTable']/tbody"));
		//To locate rows of table
		List<WebElement> rows_table=table.findElements(By.tagName("tr"));
		//To calculate number of rows in table
		int rows_count=rows_table.size();
		System.out.println(rows_count);
		for(int i=1; i<=rows_count;i++ )
		{
			System.out.println(i);
			String actualBarcode=data.getIterationData("code", excelBarcode);
			//int j=i;
			//WebElement barcodeElement=driver.findElement(By.xpath(Lab_Repository.analystWorksheet_BarcodeCell));
			WebElement barcodeElement=driver.findElement(By.xpath("//table[@class='table table-responsive table-bordered dru-table work-sheet-table ng-scope']/tbody/tr["+i+"]/td[4]"));
			String expectedBarcode=barcodeElement.getText();
			System.out.println(expectedBarcode);
			if(actualBarcode.equals(expectedBarcode))
			{
				textfield.findByXpath(("//table[@class='table table-responsive table-bordered dru-table work-sheet-table ng-scope']/tbody/tr["+i+"]/td[7]/input"));
				textfield.setValue(data.getIterationData("others", result));
				checkbox.findByXpath("//table[@class='table table-responsive table-bordered dru-table work-sheet-table ng-scope']/tbody/tr["+i+"]/td[1]/md-checkbox/div");
				checkbox.selectCheckBox();
				button.findByXpath(Lab_Repository.ANALYSTWORKSHEET_SUBMIT);
				button.click();
				Quality.verifyText2(data.getIterationData("alert message", 5));
			break;
			}	
		}
	}
	else
	{
		
	System.out.println("Message showing as "+data.getIterationData("alert message", 8)+"in Analyst Worksheet screen");
		
	}
	}*/
}
