package Testcases;

import java.awt.AWTException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmittalsTestcases {

	public WebDriver driver;
	public WebDriverWait wait;
	public Locators.SubmittalsLocators S;
	public Locators.RFILocators RFI;
	public ExcelDataManager excelDataManager = ExcelDataManager.getInstance();

	@Before
	public void setup() throws InvalidFormatException, Exception {
		excelDataManager
				.loadData("C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Excel\\TigerKrionDataSheet.xlsx");
	}

	public SubmittalsTestcases() {
		System.setProperty("Webdriver.chrome.logfile", "chromederiver.log");
		System.setProperty("Webdriver.chrome.verboselogging", "true");
		this.driver = CustomWebDriverManager.getDriver();
		this.S = new Locators.SubmittalsLocators(driver);
		this.RFI=new Locators.RFILocators(driver);
	}

	@Given("Click the projectname using the sheetname {string} and rownumber {int}")
	public void click_the_projectname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String pname = testdata.get(int1).get("Projectname");

		System.out.println(pname);

		S = new Locators.SubmittalsLocators(driver);
		S.Navigateproject();
		S.pname(pname);
		S.projectclik();

	}

	@Given("Navigate to Project dashboard screen")
	public void navigate_to_project_dashboard_screen() {
		S.viewMenu();
	}

	@Given("Navigate to Submittals in the Share Module")
	public void navigate_to_submittals_in_the_share_module() {
		S.submittalclick();
	}

	@Then("Click Add button on the screen")
	public void click_add_button_on_the_screen() {
		S.addbtnclick();
	}

	@Given("Click toggle button using the sheetname {string} and rownumber {int}")
	public void click_toggle_button_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		
		String reviewbtn = testdata.get(int1).get("Create as Review");
		System.out.println(reviewbtn);
		
		if(reviewbtn!=null && reviewbtn.matches("\\d+\\.0")) {
			reviewbtn=reviewbtn.substring(0,reviewbtn.indexOf(".0"));
		}
		System.out.println(reviewbtn);
		S.togglebtnclick(reviewbtn);
	}

	@When("Clear the default code in the Submittalcode field")
	public void clear_the_default_code_in_the_submittalcode_field() throws AWTException {
		S.clearcode();
	}

	@Then("Enter the Submittalcode using the sheetname {string} and rownumber {int}")
	public void enter_the_submittalcode_using_the_sheetname_and_rownumber(String string, Integer int1) throws AWTException {
		
		List<Map<String,String>> testdata=excelDataManager.getCachedData(string);
		
		String code=testdata.get(int1).get("Submittalcode");
		System.out.println(code);
		S.entersubtmlCode(code);
	}

	@Given("Enter the submittalname using the sheetname {string} and rownumber {int}")
	public void enter_the_submittalname_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String name=testdata.get(int1).get("Submittalname");
		System.out.println(name);
		S.entersubtlname(name);

	}

	@Given("Select the Spec Section dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_spec_section_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
				
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String Specsection=testdata.get(int1).get("Spec section");
		System.out.println(Specsection);
		S.clickspecsection();
		S.selectspecsection(Specsection);
	}

	@Given("Select the Sub Spec Section dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_sub_spec_section_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String subsSpecsection=testdata.get(int1).get("Sub spec section");
		System.out.println(subsSpecsection);
		S.entersubspec(subsSpecsection);
	}

	@Then("Enter the Descriptions using the sheetname {string} and rownumber {int}")
	public void enter_the_descriptions_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {	
		Thread.sleep(3000);
		RFI.scrolling(200);
		Thread.sleep(3000);
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String description=testdata.get(int1).get("Description");
		System.out.println(description);
		S.enterdescription(description);
	}

	@Then("Select the Type dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_type_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String type=testdata.get(int1).get("Type");
		System.out.println(type);
		S.typeclick();
		S.selecttype(type);
	}

	@Then("Select the Workflow dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_workflow_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String workflow=testdata.get(int1).get("Workflow");
		System.out.println(workflow);
		S.selectworkflow(workflow);
	}

	@Then("Enter Due Date using the sheetname {string} and rownumber {int}")
	public void enter_due_date_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String duedate=testdata.get(int1).get("Due Date");
		String duemonth=testdata.get(int1).get("Due Month");
		String dueyear=testdata.get(int1).get("Due Year");
		
		System.out.println(duedate);
		System.out.println(duemonth);
		System.out.println(dueyear);
		
		if(duedate != null && duedate.matches("\\d+\\.0")) {
			duedate=duedate.substring(0,duedate.indexOf(".0"));
			System.out.println("==============Actual passing values===========");
			System.out.println(duedate);
		}
		if(duemonth != null && duemonth.matches("\\d+\\.0")) {
			duemonth=duemonth.substring(0,duemonth.indexOf(".0"));
			System.out.println(duemonth);
		}
		if(dueyear != null && dueyear.matches("\\d+\\.0")) {
			dueyear=dueyear.substring(0,dueyear.indexOf(".0"));
			System.out.println(dueyear);
		}
		
		String formatteddate= String.format("%02d/%02d/%d",Integer.parseInt(duemonth),Integer.parseInt(duedate),Integer.parseInt(dueyear));
		System.out.println(formatteddate);
		S.selectduedate(formatteddate);
	}

	@Then("Select the Priority dropdown using the sheetname {string} and rownumber {int}")
	public void select_the_priority_dropdown_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		
		RFI.scrolling(200);
		List<Map<String,String>>testdata=excelDataManager.getCachedData(string);
		
		String priority=testdata.get(int1).get("Priority");
		System.out.println(priority);
		S.prioritylick();
		S.selectpriority(priority);
	}

	@Then("Enter Required Date using the sheetname {string} and rownumber {int}")
	public void enter_required_date_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String reqdate = testdata.get(int1).get("Req Date");
		String reqmonth = testdata.get(int1).get("Req Month");
		String reqyear = testdata.get(int1).get("Req Year");

		System.out.println(reqdate);
		System.out.println(reqmonth);
		System.out.println(reqyear);

		if (reqdate != null && reqdate.matches("\\d+\\.0")) {
			reqdate = reqdate.substring(0, reqdate.indexOf(".0"));
			System.out.println("==============Actual passing values===========");
			System.out.println(reqdate);
		}
		if (reqmonth != null && reqmonth.matches("\\d+\\.0")) {
			reqmonth = reqmonth.substring(0, reqmonth.indexOf(".0"));
			System.out.println(reqmonth);
		}
		if (reqyear != null && reqyear.matches("\\d+\\.0")) {
			reqyear = reqyear.substring(0, reqyear.indexOf(".0"));
			System.out.println(reqyear);
		}

		String formatteddate = String.format("%02d/%02d/%d", Integer.parseInt(reqmonth), Integer.parseInt(reqdate), Integer.parseInt(reqyear));
		System.out.println(formatteddate);
		S.selectreqdate(formatteddate);
	}

	@Then("Enter Required approval Date using the sheetname {string} and rownumber {int}")
	public void enter_required_approval_date_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String reqappdate = testdata.get(int1).get("ReqApp Date");
		String reqappmonth = testdata.get(int1).get("ReqApp Month");
		String reqappyear = testdata.get(int1).get("ReqApp Year");

		System.out.println(reqappdate);
		System.out.println(reqappmonth);
		System.out.println(reqappyear);

		if (reqappdate != null && reqappdate.matches("\\d+\\.0")) {
			reqappdate = reqappdate.substring(0, reqappdate.indexOf(".0"));
			System.out.println("==============Actual passing values===========");
			System.out.println(reqappdate);
		}
		if (reqappmonth != null && reqappmonth.matches("\\d+\\.0")) {
			reqappmonth = reqappmonth.substring(0, reqappmonth.indexOf(".0"));
			System.out.println(reqappmonth);
		}
		if (reqappyear != null && reqappyear.matches("\\d+\\.0")) {
			reqappyear = reqappyear.substring(0, reqappyear.indexOf(".0"));
			System.out.println(reqappyear);
		}

		String formatteddate = String.format("%02d/%02d/%d", Integer.parseInt(reqappmonth), Integer.parseInt(reqappdate),Integer.parseInt(reqappyear));
		System.out.println(formatteddate);
		S.selectreqappdate(formatteddate);
	}
	
	@Then("Enter Required on jobsite Date using the sheetname {string} and rownumber {int}")
	public void enter_required_on_jobsite_date_using_the_sheetname_and_rownumber(String string, Integer int1) throws InterruptedException {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);

		String reqjobsitedate = testdata.get(int1).get("Jobsite Date");
		String reqjobsitemonth = testdata.get(int1).get("Jobsite Month");
		String reqjobsiteyear = testdata.get(int1).get("Jobsite Year");

		System.out.println(reqjobsitedate);
		System.out.println(reqjobsitemonth);
		System.out.println(reqjobsiteyear);

		if (reqjobsitedate != null && reqjobsitedate.matches("\\d+\\.0")) {
			reqjobsitedate = reqjobsitedate.substring(0, reqjobsitedate.indexOf(".0"));
			System.out.println("==============Actual passing values===========");
			System.out.println(reqjobsitedate);
		}
		if (reqjobsitemonth != null && reqjobsitemonth.matches("\\d+\\.0")) {
			reqjobsitemonth = reqjobsitemonth.substring(0, reqjobsitemonth.indexOf(".0"));
			System.out.println(reqjobsitemonth);
		}
		if (reqjobsiteyear != null && reqjobsiteyear.matches("\\d+\\.0")) {
			reqjobsiteyear = reqjobsiteyear.substring(0, reqjobsiteyear.indexOf(".0"));
			System.out.println(reqjobsiteyear);
		}

		String formatteddate = String.format("%02d/%02d/%d", Integer.parseInt(reqjobsitemonth), Integer.parseInt(reqjobsitedate),Integer.parseInt(reqjobsiteyear));
		System.out.println(formatteddate);
		S.selectjobsitedate(formatteddate);
	}

	

	@Then("Enter Lead time using the sheetname {string} and rownumber {int}")
	public void enter_lead_time_using_the_sheetname_and_rownumber(String string, Integer int1) {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		
		String leadtime=testdata.get(int1).get("Lead time");
		System.out.println(leadtime);
		S.enterleadtime(leadtime);
		
	}

	@Then("Attach file name using the sheetname {string} and rownumber {int}")
	public void attach_file_name_using_the_sheetname_and_rownumber(String string, Integer int1) throws Exception {
		
		List<Map<String, String>> testdata = excelDataManager.getCachedData(string);
		
		String filename=testdata.get(int1).get("File name");
		System.out.println(filename);
		S.attachpackagebtn();
		S.clickdrive();
		S.searchfilename(filename);
		Thread.sleep(2000);
		S.checkboxclick();
		Thread.sleep(2000);
		S.clickattachfilebtn();
		
	}

	@Given("Click create button in the screen")
	public void click_create_button_in_the_screen() {
		RFI.scrolling(200);
		S.createclick();
	}

	@Then("Submittals should be created")
	public void submittals_should_be_created() {
		System.out.println("Submittals created successfully");
	}
}
