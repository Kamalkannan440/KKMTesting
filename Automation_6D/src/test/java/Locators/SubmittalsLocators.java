package Locators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v124.webauthn.WebAuthn;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmittalsLocators {

	private WebDriver driver;
	private WebDriverWait wait;

	public SubmittalsLocators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"sidebar-nav\"]/li[4]/a")
	private WebElement project;

	@FindBy(id = "grid_499977221_0_searchbar")
	private WebElement searchbar;

	@FindBy(id = "grid_499977221_0_searchbutton")
	private WebElement searchicon;

	@FindBy(xpath = "//*[@id='grid_499977221_0_content_table']/tbody/tr[1]/td[4]")
	private WebElement projectclick;

	@FindBy(xpath = "//aside[@id='project-sidebar']/ul/child::ul/li[5]/descendant::i[2]")
	private WebElement arrowdownbtnforshare;

	@FindBy(xpath = "//*[@id='Share-nav']/li[2]/a")
	private WebElement Submittalclick;

	@FindBy(xpath = "//button[@rolepermissionbutton='Submittal.Modify']")
	private WebElement addbtn;

	@FindBy(xpath = "//input[@id='createTask']")
	private WebElement togglebtn;

	@FindBy(xpath = "//input[@id='code']")
	private WebElement code;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;

	@FindBy(xpath = "//ejs-dropdownlist[@id='specId']")
	private WebElement specsection;

	@FindBy(xpath = "//ul[@id='specId_options']/li")
	private List<WebElement> specsectionlist;

	@FindBy(xpath = "//input[@id='subSpec']")
	private WebElement subspec;

	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement description;

	@FindBy(xpath = "//ejs-dropdownlist[@id='typeId']")
	private WebElement type;

	@FindBy(xpath = "//ul[@id='typeId_options']/li")
	private List<WebElement> typelist;

	@FindBy(xpath = "//select[@id='workflowStatusId']")
	private WebElement workflow;

	@FindBy(xpath = "//input[@id='endDate']")
	private WebElement enddate;

	@FindBy(xpath = "//ejs-dropdownlist[@id='priorityId']")
	private WebElement priority;

	@FindBy(xpath = "//ul[@id='priorityId_options']/li")
	private List<WebElement> prioritylist;

	@FindBy(xpath = "//input[@id='requiredDate']")
	private WebElement reqdate;

	@FindBy(xpath = "//input[@id='approvedDate']")
	private WebElement reqappdate;

	@FindBy(xpath = "//input[@id='onSiteDate']")
	private WebElement jobsitedate;

	@FindBy(xpath = "//input[@id='leadTime']")
	private WebElement leadtime;

	@FindBy(xpath = "//div[@class='btn-group']/button")
	private WebElement attachbtn;

	@FindBy(xpath = "//ul[@class='dropdown-menu show']/li[1]")
	private WebElement drivebtn;

	@FindBy(xpath = "//input[@id='_gridcontrol_searchbar']")
	private WebElement searchfield;

	@FindBy(id = "_gridcontrol_searchbutton")
	private WebElement searchiconbtn;

	@FindBy(xpath = "//*[@id='_gridcontrol_content_table']/tbody/tr[2]/td[1]")
	private WebElement checkboxclick;

	@FindBy(xpath = "//button[@class='btn btn-outline-info']")
	private WebElement fileattachbtn;

	@FindBy(xpath = "//div[@class='col-6 mt-3']/button")
	private WebElement createbtn;

	FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2));

	public void Navigateproject() {
		waits.until(ExpectedConditions.elementToBeClickable(project));
		project.click();
	}

	public void pname(String name) {
		Actions act = new Actions(driver);
		waits.until(ExpectedConditions.elementToBeClickable(searchbar));
		act.click(searchbar).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchbar.sendKeys(name);
		searchicon.click();
	}

	public void projectclik() {
		try {
			waits.until(ExpectedConditions.visibilityOf(projectclick));
			projectclick.click();
		} catch (Exception e) {
			projectclick.click();
		}
	}

	public void viewMenu() {
		waits.until(ExpectedConditions.visibilityOf(arrowdownbtnforshare));
		arrowdownbtnforshare.click();
	}

	public void submittalclick() {
		waits.until(ExpectedConditions.visibilityOf(Submittalclick));
		Submittalclick.click();
	}

	public void addbtnclick() {
		waits.until(ExpectedConditions.visibilityOf(addbtn));
		addbtn.click();
	}

	public void togglebtnclick(String val) {
		if(val.equalsIgnoreCase("0")) {
		waits.until(ExpectedConditions.visibilityOf(togglebtn));
		togglebtn.click();
		System.out.println("Creating Submittals Not as Review");
		}else if (val.equalsIgnoreCase("1")) {
			System.out.println("Creating Submittals as Review");
		} else {
			System.out.println("Given value is Invalid...");
		}
	}

	public void clearcode() throws AWTException {

		waits.until(ExpectedConditions.elementToBeClickable(code));
		code.click();
		Robot rb = new Robot();
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_CLEAR);
		rb.delay(2000);
	}

	public void entersubtmlCode(String codevalue) throws AWTException {
		
		waits.until(ExpectedConditions.elementToBeClickable(code));
		code.sendKeys(codevalue);
		wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CLEAR);
	}

	public void entersubtlname(String val) {
		waits.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(val);
	}

	public void clickspecsection() {
		waits.until(ExpectedConditions.visibilityOf(specsection));
		specsection.click();
	}

	public void selectspecsection(String val) throws Exception {
		selectDropdown(specsectionlist, val);
	}

	public void entersubspec(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(subspec));
		subspec.sendKeys(val);
	}

	public void enterdescription(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(description));
		description.sendKeys(val);
	}
	
	public void typeclick() {
		waits.until(ExpectedConditions.elementToBeClickable(type));
		type.click();
	}
	public void selecttype(String val) throws Exception {
		selectDropdown(typelist, val);
	}

	public void selectworkflow(String val) {
		Select ss = new Select(workflow);
		ss.selectByVisibleText(val);
	}

	public void selectduedate(String date) {
		waits.until(ExpectedConditions.elementToBeClickable(enddate));
		enddate.sendKeys(date);
	}
	
	public void prioritylick() {
		waits.until(ExpectedConditions.elementToBeClickable(priority));
		priority.click();
	}
	
	public void selectpriority(String val) throws Exception {
		selectDropdown(prioritylist, val);
	}

	public void selectreqdate(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(reqdate));
		reqdate.sendKeys(val);
	}

	public void selectreqappdate(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(reqappdate));
		reqappdate.sendKeys(val);
	}

	public void selectjobsitedate(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(jobsitedate));
		jobsitedate.sendKeys(val);
	}

	public void enterleadtime(String val) {
		waits.until(ExpectedConditions.elementToBeClickable(leadtime));
		leadtime.sendKeys(val);
	}

	public void attachpackagebtn() {
		waits.until(ExpectedConditions.elementToBeClickable(attachbtn));
		attachbtn.click();
	}

	public void clickdrive() {
		waits.until(ExpectedConditions.elementToBeClickable(drivebtn));
		drivebtn.click();
	}

	public void searchfilename(String val) throws Exception {
		waits.until(ExpectedConditions.elementToBeClickable(searchfield));
		searchfield.click();
		searchfield.sendKeys(val);
		Thread.sleep(3000);
		waits.until(ExpectedConditions.elementToBeClickable(searchiconbtn));
		searchiconbtn.click();
	}

	public void checkboxclick() {
		waits.until(ExpectedConditions.elementToBeClickable(checkboxclick));
		checkboxclick.click();
	}

	public void clickattachfilebtn() {
		waits.until(ExpectedConditions.elementToBeClickable(fileattachbtn));
		fileattachbtn.click();
	}

	public void createclick() {
		waits.until(ExpectedConditions.elementToBeClickable(createbtn));
		createbtn.click();
	}

	public void selectDropdown(List<WebElement> t, String comparetxt) throws Exception {
		List<WebElement> elements = t;
		Thread.sleep(2000);
		for (WebElement s : elements) {
			String txt = s.getText();
			if (txt.equalsIgnoreCase(comparetxt)) {
				s.click();
				break;
			} else {
				System.out.println("Given Option is not found in the Dropdown List");
			}
		}
		System.out.println("Given Option is Found ");
	}

}
