package Testcases;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RFATestcases {

	private WebDriver driver;
	private Locators.RFALocators RFA;
	private Locators.RFILocators RFI;
	private ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setup() throws InvalidFormatException, Exception {
		excelDataManager
				.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public RFATestcases() {
		System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
		System.setProperty("webdriver.chrome.verboseLogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.RFA = new Locators.RFALocators(driver);
		this.RFI = new Locators.RFILocators(driver);
	}

	@Given("Select projectname using the sheetname {string} and rownumber {int}")
	public void select_projectname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		System.out.println("Plus button Should to be click");

		String pname = testdata.get(int1).get("Projectname");

		System.out.println(pname);

		RFA = new Locators.RFALocators(driver);
		RFA.Navigateproject();
		RFA.pname(pname);
		RFA.projectclik();
	}

	@Given("Navigate to the Project dashboard")
	public void navigate_to_the_project_dashboard() {
		System.out.println("Clicked the project successfully");
		RFA.viewMenu();
	}

	@Given("Navigate to RFA in the Action Module")
	public void navigate_to_rfa_in_the_action_module() {
		RFA.routingRFA();
		System.out.println("RFIList screen is displayed ");

	}

	@Then("Click the Add button in the screen")
	public void click_the_add_button_in_the_screen() {
		RFA.Addbtn();
	}

	@When("Clear the default code in the RFAcode field")
	public void clear_the_default_code_in_the_rf_acode_field() {
		try {

			RFA.clearcode();

		} catch (AWTException e) {
			System.out.println("Code is not cleared :" + e.getMessage());
		}
	}

	@Then("Enter the RFA code using the sheetname {string} and rownumber {int}")
	public void enter_the_rfa_code_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String code = testdata.get(int1).get("RFAcode");
		try {

			RFA.enterCode(code);

		} catch (AWTException e) {
			System.out.println("Code is Not Entered :" + e.getMessage());
		}
	}

	@Given("Enter the RFA name using the sheetname {string} and rownumber {int}")
	public void enter_the_rfa_name_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String name = testdata.get(int1).get("RFAname");

		RFA.entername(name);
	}

	@Given("Enter the RFA Description using the sheetname {string} and rownumber {int}")
	public void enter_the_rfa_description_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String description = testdata.get(int1).get("Description");

		RFA.enterdescription(description);
	}

	@Given("Enter the Start Date using the sheetname {string} and rownumber {int}")
	public void enter_the_start_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String RFAstartDate = testdata.get(int1).get("Start Date");
		String RFAstartMonth = testdata.get(int1).get("Start Month");
		String RFAstartYear = testdata.get(int1).get("Start Year");

		System.out.println(RFAstartDate);
		System.out.println(RFAstartMonth);
		System.out.println(RFAstartYear);
		Thread.sleep(1000);
		RFA.datefieldclick();
		RFA.datefieldclear();

		if (RFAstartMonth != null && RFAstartMonth.matches("\\d+\\.0")) {
			RFAstartMonth = RFAstartMonth.substring(0, RFAstartMonth.indexOf(".0"));
			System.out.println("====================Actual passing values=============");
			System.out.println("Month is :" + RFAstartMonth);
		}
		if (RFAstartDate != null && RFAstartDate.matches("\\d+\\.0")) {
			RFAstartDate = RFAstartDate.substring(0, RFAstartDate.indexOf(".0"));
			System.out.println("Date is :" + RFAstartDate);
		}

		if (RFAstartYear != null && RFAstartYear.matches("\\d+\\.0")) {
			RFAstartYear = RFAstartYear.substring(0, RFAstartYear.indexOf(".0"));
			System.out.println("Year is :" + RFAstartYear);
		}
		String formattedDate = String.format("%02d/%02d/%d", Integer.parseInt(RFAstartMonth), Integer.parseInt(RFAstartDate), Integer.parseInt(RFAstartYear));
		System.out.println(formattedDate);
		RFA.enterstartdate(formattedDate);
	}

	@Then("Enter the End Date using the sheetname {string} and rownumber {int}")
	public void enter_the_end_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String RFAendDate = testdata.get(int1).get("Due Date");
		String RFAendMonth = testdata.get(int1).get("Due Month");
		String RFAendYear = testdata.get(int1).get("Due Year");

		System.out.println(RFAendDate);
		System.out.println(RFAendMonth);
		System.out.println(RFAendYear);
		Thread.sleep(1000);
		RFA.enddatefieldclick();
		RFA.enddatefieldclear();

		if (RFAendMonth != null && RFAendMonth.matches("\\d+\\.0")) {
			RFAendMonth = RFAendMonth.substring(0, RFAendMonth.indexOf(".0"));
			System.out.println("====================Actual passing values=============");
			System.out.println("Month is :" + RFAendMonth);
		}
		if (RFAendDate != null && RFAendDate.matches("\\d+\\.0")) {
			RFAendDate = RFAendDate.substring(0, RFAendDate.indexOf(".0"));
			System.out.println("Date is :" + RFAendDate);
		}

		if (RFAendYear != null && RFAendYear.matches("\\d+\\.0")) {
			RFAendYear = RFAendYear.substring(0, RFAendYear.indexOf(".0"));
			System.out.println("Year is :" + RFAendYear);
		}
		String formattedDate = String.format("%02d/%02d/%d", Integer.parseInt(RFAendMonth), Integer.parseInt(RFAendDate), Integer.parseInt(RFAendYear));
		System.out.println(formattedDate);
		RFA.enterduedate(formattedDate);
	}

	@Then("Select Workflow from the dropdown using the sheetname {string} and rownumber {int}")
	public void select_workflow_from_the_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) {
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String workflowname = testdata.get(int1).get("Workflow");
		RFA.workflowselection(workflowname);
	}

	@Then("Select Priority from the dropdown using the sheetname {string} and rownumber {int}")
	public void select_priority_from_the_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		Thread.sleep(3000);
		RFI.scrolling(150);
		Thread.sleep(3000);
		RFA.prioritydropdownclick();
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String priority = testdata.get(int1).get("Priority");
		System.out.println(priority);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		RFA.SelectPrioritydropdown(priority);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}

	@Then("Select checklist dropdown using the sheetname {string} and rownumber {int}")
	public void select_checklist_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		Thread.sleep(3000);
		RFI.scrolling(150);
		Thread.sleep(3000);
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String Checklistname = testdata.get(int1).get("Checklist");
		System.out.println(Checklistname);
		RFA.checklistclick();
		Thread.sleep(2000);
		RFA.selectchecklist(Checklistname);

	}

	@Then("Attach file from drive the file name using the sheetname {string} and rownumber {int}")
	public void attach_file_from_drive_the_file_name_using_the_sheetname_and_rownumber(String string, Integer int1)
			throws Exception {
		Thread.sleep(3000);
		RFI.scrolling(250);
		Thread.sleep(3000);
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		String name = testdata.get(int1).get("Filename");
		System.out.println(name);
		RFA.filesearch(name);
		RFA.fileattach();
	}
	@Given("Click create button")
	public void click_create_button() {
		RFA.createClick();
	}

	@Then("RFA should be created")
	public void rfa_should_be_created() {
		
		System.out.println("RFA is Added successfully");
	}

}
