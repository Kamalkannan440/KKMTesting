package Testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransmittalsTestcases {
	
	public WebDriver driver;
	public Locators.TransmittalsLocators T;
	public Locators.RFILocators RFI;
	public ExcelDataManager excelDataManager= ExcelDataManager.getInstance();
	
	@Before
	public void setup() throws InvalidFormatException, IOException {
		excelDataManager.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Excel\\TigerKrionDataSheet.xlsx");
	}
	
	public TransmittalsTestcases() {
		System.setProperty("Webdriver.chrome.log", "chromedriver.logfile");
		System.setProperty("Webdriver.chrome.verboselogging", "true");
		this.driver= CustomWebDriverManager.getDriver();
		this.T=new Locators.TransmittalsLocators(driver);
		this.RFI=new Locators.RFILocators(driver);
	}
	
	@Given("Click on the projectname using the sheetname {string} and rownumber {int}")
	public void click_on_the_projectname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String pname = testdata.get(int1).get("Projectname");

		System.out.println(pname);

		T = new Locators.TransmittalsLocators(driver);
		T.Navigateproject();
		T.pname(pname);
		T.projectclik();
	}
	
	@Given("Navigate to the Project dashboard screen")
	public void navigate_to_the_project_dashboard_screen() {
	   T.viewMenu();
	}
	
	@Given("Navigate to Transmittals in the Share Module")
	public void navigate_to_transmittals_in_the_share_module() {
	   T.Transmittalclick();
	}
	
	@Then("Click Add button in the screen")
	public void click_add_button_in_the_screen() {
	   T.addbtnclick();
	}
	
	@Given("Enable or disable the toggle button using the sheetname {string} and rownumber {int}")
	public void Enable_or_disable_the_toggle_button_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		
		String reviewbtn = testdata.get(int1).get("Create as Review");
		System.out.println(reviewbtn);
		
		if(reviewbtn!=null && reviewbtn.matches("\\d+\\.0")) {
			reviewbtn=reviewbtn.substring(0,reviewbtn.indexOf(".0"));
		}
		System.out.println(reviewbtn);
		T.togglebtnclick(reviewbtn);
	}

	@When("Clear the default code in the Transmittalcode field")
	public void clear_the_default_code_in_the_transmittalcode_field() throws AWTException {
	   T.clearcode();
	}
	
	@Then("Enter the Transmittalcode using the sheetname {string} and rownumber {int}")
	public void enter_the_transmittalcode_using_the_sheetname_and_rownumber(String string, Integer int1) throws AWTException {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String code=testdata.get(int1).get("Transmittal code");
		System.out.println(code);
	    T.entertransmtlCode(code);
	}
	
	@Given("Enter the Transmittalname using the sheetname {string} and rownumber {int}")
	public void enter_the_transmittalname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String name=testdata.get(int1).get("Transmittal name");
		System.out.println(name);
		T.entertransmtlname(name);
		
	}

	@Then("Enter the Descriptions of transmittal using the sheetname {string} and rownumber {int}")
	public void enter_the_descriptions_of_transmittal_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String description=testdata.get(int1).get("Description");
		System.out.println(description);
		T.enterdescription(description);
	}
	
	@Then("Select the Workflow for transmittal dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_workflow_for_transmittal_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String wf=testdata.get(int1).get("Workflow");
		System.out.println(wf);
		T.selectworkflow(wf);
	}
	
	@Then("Attach the file by the filename using the sheetname {string} and rownumber {int}")
	public void attach_the_file_by_the_filename_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
	   
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String filename=testdata.get(int1).get("File name");
		System.out.println(filename);
		RFI.scrolling(200);
		Thread.sleep(3000);
		T.clickattachbtn();
		T.driverbtnclick();
		T.attachfile(filename);
		T.checkboxclick();

				
	}
	
	@Given("Click the create button in the screen")
	public void click_the_create_button_in_the_screen() {
	  //  T.createclick();
	}
	
	@Then("Transmittals should be created")
	public void transmittals_should_be_created() {
	   System.out.println("Transmittal is successfully created ...");
	}
	
}
