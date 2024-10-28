package Locators;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RFALocators {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public RFALocators(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"sidebar-nav\"]/li[4]/a")
	private WebElement project;

	@FindBy(id="grid_499977221_0_searchbar")
	private WebElement searchbar;
	
	@FindBy(id="grid_499977221_0_searchbutton")
	private WebElement searchicon;
	
	@FindBy(xpath = "//*[@id='grid_499977221_0_content_table']/tbody/tr[1]/td[4]")
	private WebElement projectclick;
	
	@FindBy(xpath="//*[@id=\"project-sidebar\"]/ul/ul/li[3]/a/i[2]")
	private WebElement Actiondownarrow;
	
	@FindBy(xpath="//*[@id='Actions-nav']/li[4]/a")
	private WebElement RFAmenuclick;
	
	@FindBy(xpath="//button[@class='btn btn-info float-end mx-3']")
	private WebElement Addbtn;
	
	@FindBy(xpath="//input[@id='code']")
	private WebElement RFAcode;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement RFAname;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement RFAdesc;
	
	@FindBy(xpath="//input[@id='startDate']")
	private WebElement startdate;
	
	@FindBy(xpath="//input[@id='endDate']")
	private WebElement enddate;
	
	@FindBy(xpath="//select[@id='workflowStatusId']")
	private WebElement RFAworkflow;
	
	@FindBy(xpath="//ejs-dropdownlist[@id='priorityId']")
	private WebElement RFApriorityclick;
	
	@FindBy(xpath="//ul[@id='priorityId_options']/li")
	private List<WebElement> RFAPriorityselect;
	
	@FindBy(xpath="//ejs-multiselect[@formcontrolname='checkListIds']")
	private WebElement checklistclick;
	
	@FindBy(xpath="//ul[@class='e-list-parent e-ul ']/li")
	private List<WebElement> listofchecklist;
	
	@FindBy(xpath="//div[@class='btn-group']/button")
	private WebElement Attachfilebtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']/li[1]")
	private WebElement drivebtn;
	
	@FindBy(xpath="//input[@id='_gridcontrol_searchbar']")
	private WebElement filesearchbtn;
	
	@FindBy(xpath="//span[@id='_gridcontrol_searchbutton']")
	private WebElement filesearchicon;
	
	@FindBy(xpath="//*[@id='_gridcontrol_content_table']/tbody/tr[2]/td[1]")
	private WebElement filecheckbox;
	
	@FindBy(xpath="//button[@class='btn btn-outline-info']")
	private WebElement fileattachbtn;
	
	@FindBy(xpath="//div[@class='col-sm-12 col-md-3']/descendant::div/child::div[2]")
	private WebElement Createbtn;
		
	
	FluentWait<WebDriver> waits = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2));
	
	public void Navigateproject() {
		waits.until(ExpectedConditions.elementToBeClickable(project));
		project.click();
	}
		
	public void pname(String name) {	
		Actions act=new Actions (driver);
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
		}
		catch (Exception e) {
			projectclick.click();
		}
	}
	
	public void viewMenu() {
		waits.until(ExpectedConditions.visibilityOf(Actiondownarrow));
		Actiondownarrow.click();
	}
	
	public void routingRFA() {
		waits.until(ExpectedConditions.visibilityOf(RFAmenuclick));
		RFAmenuclick.click();
	}
	
	public void Addbtn() {
		waits.until(ExpectedConditions.visibilityOf(Addbtn));
		Addbtn.click();
	}
	public void clearcode() throws AWTException {
		
		waits.until(ExpectedConditions.elementToBeClickable(RFAcode));
		RFAcode.click();
		Robot rb= new Robot();
		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_CLEAR);
		rb.delay(2000);
	}
	public void enterCode(String codevalue) throws AWTException {
		waits.until(ExpectedConditions.elementToBeClickable(RFAcode));
		RFAcode.sendKeys(codevalue);
		wait=new WebDriverWait(driver, Duration.ofMillis(3000));
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CLEAR);
	}
	public void entername(String namevalue) {
		waits.until(ExpectedConditions.elementToBeClickable(RFAname));
		RFAname.sendKeys(namevalue);
	}
	public void enterdescription(String descriptiontext) {
		waits.until(ExpectedConditions.elementToBeClickable(RFAdesc));
		RFAdesc.sendKeys(descriptiontext);
	}
	public void datefieldclick() throws Exception {
		startdate.click();
		Thread.sleep(3000);
	}
	public void datefieldclear() throws Exception {
		startdate.clear();
	}
	public void enterstartdate(String date) throws Exception {
		waits.until(ExpectedConditions.elementToBeClickable(startdate));
		startdate.sendKeys(date);
	}
	public void enddatefieldclick() throws Exception {
		enddate.click();
		Thread.sleep(3000);
	}
	public void enddatefieldclear() throws Exception {
		enddate.clear();
	}
	public void enterduedate(String date) throws Exception {
		waits.until(ExpectedConditions.elementToBeClickable(enddate));
		enddate.sendKeys(date);
	}
	public void workflowselection(String text) {
		Select ss= new Select(RFAworkflow);
		ss.selectByVisibleText(text);
	}
	
	public void checklistclick() throws Exception {
		waits.until(ExpectedConditions.elementToBeClickable(checklistclick));
		checklistclick.click();
	}
	
	public void selectchecklist(String name) throws Exception {
		selectDropdown(listofchecklist, name);
	}
	
	public void prioritydropdownclick() {
		waits.until(ExpectedConditions.elementToBeClickable(RFApriorityclick));
		RFApriorityclick.click();
	}
	
	public void SelectPrioritydropdown(String type) {
		try {
			selectDropdown(RFAPriorityselect, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void filesearch(String name) {
		Attachfilebtn.click();
		drivebtn.click();
		String s=name.trim();
		filesearchbtn.click();
		filesearchbtn.sendKeys(s);
		filesearchicon.click();
	}
	
	public void fileattach() throws Exception {
		Thread.sleep(3000);
		filecheckbox.click();
		fileattachbtn.click();
	}
	
	public void createClick() {
		Createbtn.click();
	}
	public void selectDropdown(List<WebElement>t,String comparetxt) throws Exception {
		List<WebElement> elements=t;
		Thread.sleep(2000);
		for(WebElement s:elements) {
			String txt=s.getText();
			if(txt.equalsIgnoreCase(comparetxt)) {
				s.click();
				break;	
			}
			else {
				System.out.println("Given Option is not found in the Dropdown List");
			}
		}
		System.out.println("Given Option is Found ");
	}
	
}
