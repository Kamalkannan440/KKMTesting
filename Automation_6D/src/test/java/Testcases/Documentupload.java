package Testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;


public class Documentupload {

	private WebDriver driver;
	private Locators.DocumentLocators DL;
	private ExtentTest test;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setUp() throws InvalidFormatException, IOException {
		excelDataManager
				.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Excel\\TigerKrionDataSheet.xlsx");

	}

	public Documentupload() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.DL = new Locators.DocumentLocators(driver);
	}

	@Given("Select the projectname using sheetname {string} and rownumber {int}")
	public void select_the_projectname_using_sheetname_and_rownumber(String string, Integer int1) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		System.out.println("Plus button Should to be click");

		String pname = testdata.get(int1).get("Projectname");

		System.out.println(pname);

		DL = new Locators.DocumentLocators(driver);
		DL.Navigateproject();
		DL.pname(pname);
		DL.projectclik();

	}

	@Then("Navigate to project dashboard")
	public void navigate_to_project_dashboard() throws Exception {
		DL.navigatetodoc();
		System.out.println("Plus button is clicked");
	}

	@Given("Click the Upload files button")
	public void click_the_upload_files_button() throws Exception {
		driver.manage().timeouts().getPageLoadTimeout();
		DL.uploadbtn();
	}
	int count;

	@Given("Upload the documents using sheet {string} and rownumber {int} fecthing the document path from excel")
	public void upload_the_documents_using_sheet_and_rownumber_fecthing_the_document_path_from_excel(
			String documentsheet, Integer int1) throws Exception {

		List<Map<String, String>> testdata = excelDataManager.getCachedData(documentsheet);
		System.out.println("++++File start uploading++++");

		String Columnname = "Documentpath";
		List<String> columndata = new ArrayList<String>();

		for (Map<String, String> rowdata : testdata) {
			String columnvalue = rowdata.getOrDefault(Columnname, "");
			columndata.add(columnvalue);
		}
		for (String value : columndata) {
			
			System.out.println(value);
		}
		 count=columndata.size();
		 System.out.println("Total No of Documents :"+count);
	//	DL.uploading("C:\\Users\\TWINUser-08\\Desktop\\Project Documents\\MHV 2024.rvt");
		System.out.println("=======================In copying clipboard=========================");
		Robot rb= new Robot();
		rb.delay(3000);
		
		try {
			
			for (String value : columndata) {
				
					System.out.println(value);
					System.out.println("");
					
					if (value != null && !value.isEmpty())
					{
						
					//Copy the path into clipboard
					StringSelection ss=new StringSelection(value);
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
					DL.uploadfile();
					rb.delay(6000);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					Transferable contents = clipboard.getContents(null);
		            
		            // Check if the contents are in string flavor
		            if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
		                // Retrieve the string from the clipboard
		                String clipboardText = (String) contents.getTransferData(DataFlavor.stringFlavor);
		                System.out.println("Clipboard contains: " + clipboardText);
		                System.out.println("");
		            } else {
		                System.out.println("Clipboard does not contain text.");
		            }
		            
		            //Pasting & uploading the values
					rb.keyPress(KeyEvent.VK_CONTROL);
					rb.keyPress(KeyEvent.VK_V);
					rb.delay(2000);
					
					rb.keyRelease(KeyEvent.VK_CONTROL);
					rb.keyRelease(KeyEvent.VK_V);
					rb.delay(2000);
					
					rb.keyPress(KeyEvent.VK_ENTER);
					rb.keyRelease(KeyEvent.VK_ENTER);
					System.out.println("======File start uploading====");
					DL.filestatus();
					}
					else {
			            System.err.println("Skipping empty or null value: " + value);
			        }
				}
			
		} catch (FileNotFoundException e) {
			ExceptionHandler exceptionHandler = new ExceptionHandler(driver, ExtentCucumberAdapter.getCurrentStep());
			exceptionHandler.handleException(e, "Upload files");
			throw e;
		}
		
	}
	
	@Given("Document should be uploaded")
	public void document_should_be_uploaded() {
		int actual=DL.count();
		System.out.println(actual);
		if(count==actual) {
			System.out.println("All files are Uploaded Successfully");
		}
		else {
			System.out.println("Files are Partially uploaded");
		}
		DL.Individual();
		//DL.close();
	}
	private void Folderdatas(String fieldName, String fieldValue) {

		test = ExtentCucumberAdapter.getCurrentStep();
		ExtentReports extent = new ExtentReports();
		test = extent.createTest("Test Name");
		System.out.println("Test values ======================>" + test);

		String styledTable = "<table style='color: black; border: 1px solid black; border-collapse: collapse;'>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldName + "</td></tr>"
				+ "<tr><td style='border: 1px solid black;color: black'>" + fieldValue + "</td></tr>" + "</table>";

		Allure.addAttachment("Input Data", "text/html", new ByteArrayInputStream(styledTable.getBytes()), "html");

		String[][] data = { { fieldName }, { fieldValue }, };
		Markup m = MarkupHelper.createTable(data);

		// Log the table in Extent Report
		test.log(Status.PASS, m);
	}
	
}
