package Locators;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormLocators {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FormLocators(WebDriver driver){
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[@id=\"sidebar-nav\"]/li[4]/a")
	private WebElement project;

	@FindBy(id="grid_499977221_0_searchbar")
	private WebElement searchbar;
	
	@FindBy(id="grid_499977221_0_searchbutton")
	private WebElement searchicon;
	
	@FindBy(xpath = "//*[@id='grid_499977221_0_content_table']/tbody/tr[1]/td[4]")
	private WebElement projectclick;
	
	@FindBy(xpath="//*[@id='project-sidebar']/ul/ul/li[4]/a/i[2]")
	private WebElement Attachmentsdownarrow;
	
	@FindBy(xpath="//*[@id='Attachments-nav']/li[1]/a")
	private WebElement Formmenuclick;
	
	@FindBy(xpath="//ejs-treeview[@id='treeelement']/ul/li")
	private List<WebElement> Formlist;
	
	@FindBy(xpath="//button[@rolepermissionbutton='Form.Modify']")
	private WebElement Formaddbtn;
	
	@FindBy(xpath="//input[@id='fromDate']")
	private WebElement Fromstartdate;
	
	@FindBy(xpath="//input[@id='dueDate']")
	private WebElement Fromenddate;
	
	@FindBy(xpath="//input[@id='location']")
	private WebElement location;
	
	@FindBy(xpath="//select[@id='reviewID']")
	private WebElement workflow;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement description;
	
	@FindBy(xpath="//label[@for='work']/following-sibling::div/button")
	private WebElement addworkbtn;
	
	@FindBy(xpath="//input[@placeholder='Add Crew']")
	private WebElement crewname;
	
	@FindBy(xpath="//input[@placeholder='Add Workers']")
	private WebElement workers;
	
	@FindBy(xpath="//input[@placeholder='Add TotalHours']")
	private WebElement Totalhr;
	
	@FindBy(xpath="//textarea[@placeholder='Add WorkPerformed']")
	private WebElement workperformed;
	
	@FindBy(xpath="//div[@id='workModalwork']/descendant::div/child::div[3]/button[2]")
	private WebElement worksavebtn;
	
	@FindBy(xpath="//label[@for='material']/following-sibling::div/button")
	private WebElement addmaterialbtn;
	
	@FindBy(xpath="//input[@placeholder='Add Material']")
	private WebElement materialname;
	
	@FindBy(xpath="//input[@formcontrolname='materialQuantity']")
	private WebElement Quantity;
	
	@FindBy(xpath="//input[@placeholder='Add Unit']")
	private WebElement Unit;
	
	@FindBy(xpath="//textarea[@formcontrolname='materialComment']")
	private WebElement comment;
	
	@FindBy(xpath="//div[@id='materialModalmaterial']/descendant::div/descendant::div[3]/form/div[2]/button[2]")
	private WebElement materialsavebtn;
	
	@FindBy(xpath="//label[@for='equipment']/following-sibling::div/button")
	private WebElement addequipmentbtn;
	
	@FindBy(xpath="//input[@placeholder='Add Equipment']")
	private WebElement equipmentname;
	
	@FindBy(xpath="//input[@formcontrolname='equipmentQuantity']")
	private WebElement eqpquantity;
	
	@FindBy(xpath="//input[@formcontrolname='equipmentHoursUsed']")
	private WebElement hoursused;
	
	@FindBy(xpath="//textarea[@formcontrolname='equipmentComment']")
	private WebElement eqpcomment;
	
	@FindBy(xpath="//div[@id='equipmentModalequipment']/descendant::div[10]/button[2]")
	private WebElement equipmentsavebtn;
	
	@FindBy(xpath="//div[@class='btn-group']/div/button")
	private WebElement Noteclick;
	
	@FindBy(xpath="//input[@placeholder='Note']")
	private WebElement enternote;
	
	@FindBy(xpath="//button[@class='form-control btn btn-info']")
	private WebElement createclick;
	
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
		waits.until(ExpectedConditions.visibilityOf(Attachmentsdownarrow));
		Attachmentsdownarrow.click();
	}
	
	public void routingForm() {
		waits.until(ExpectedConditions.visibilityOf(Formmenuclick));
		Formmenuclick.click();
	}
	
	public void selectformtype(String type) throws Exception {
		selectDropdown(Formlist, type);
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
	
	public void clickadd() {
		waits.until(ExpectedConditions.visibilityOf(Formaddbtn));
		Formaddbtn.click();
	}
	
	public void selectingfromdate(String values) {
		waits.until(ExpectedConditions.visibilityOf(Fromstartdate));
		Fromstartdate.sendKeys(values);
	}
	
	public void selectingduedate(String values) {
		waits.until(ExpectedConditions.visibilityOf(Fromenddate));
		Fromenddate.sendKeys(values);
	}
	
	public void enterlocation(String loc) {
		waits.until(ExpectedConditions.visibilityOf(location));
		location.sendKeys(loc);
	}
	public void selectworkflow(String value) {
		waits.until(ExpectedConditions.visibilityOf(workflow));
		Select s= new Select(workflow);
		s.selectByVisibleText(value);
	}
	public void enterdescription(String value) {
		waits.until(ExpectedConditions.visibilityOf(description));
		description.sendKeys(value);
	}
	
	
	//Entering work details
	public void addworkbtnclick() {
		waits.until(ExpectedConditions.visibilityOf(addworkbtn));
		addworkbtn.click();
	}
	
	public void entercrew(String val) {
		waits.until(ExpectedConditions.visibilityOf(crewname));
		crewname.sendKeys(val);
	}
	public void enterworker(String val) {
		waits.until(ExpectedConditions.visibilityOf(workers));
		workers.sendKeys(val);
	}
	public void entertotalhr(String val) {
		waits.until(ExpectedConditions.visibilityOf(Totalhr));
		Totalhr.sendKeys(val);
	}
	public void enterworkperformed(String val) {
		waits.until(ExpectedConditions.visibilityOf(workperformed));
		workperformed.sendKeys(val);
	}
	public void worksave() {
		waits.until(ExpectedConditions.visibilityOf(worksavebtn));
		worksavebtn.click();
	}
	
	//Entering Material details
	public void addmaterialbtnclick() {
		waits.until(ExpectedConditions.visibilityOf(addmaterialbtn));
		addmaterialbtn.click();
	}
	public void entermaterial(String val) {
		waits.until(ExpectedConditions.visibilityOf(materialname));
		materialname.sendKeys(val);
	}
	public void enterquantity(String val) {
		waits.until(ExpectedConditions.visibilityOf(Quantity));
		Quantity.sendKeys(val);
	}
	public void enterunit(String val){
		waits.until(ExpectedConditions.visibilityOf(Unit));
		Unit.sendKeys(val);
	}
	public void entercomment(String val) {
		waits.until(ExpectedConditions.visibilityOf(comment));
		comment.sendKeys(val);
	}
	public void materialsave() {
		waits.until(ExpectedConditions.visibilityOf(materialsavebtn));
		materialsavebtn.click();
	}
	
	//Entering Equipment details
	public void addequipbtnclick() {
		waits.until(ExpectedConditions.visibilityOf(addequipmentbtn));
		addequipmentbtn.click();
	}
	public void enterequipmentname(String val) {
		waits.until(ExpectedConditions.visibilityOf(equipmentname));
		equipmentname.sendKeys(val);
	}
	
	public void entereqpquantity(String val) {
		waits.until(ExpectedConditions.visibilityOf(eqpquantity));
		eqpquantity.sendKeys(val);
	}
	public void entereqphours(String val) {
		waits.until(ExpectedConditions.visibilityOf(hoursused));
		hoursused.sendKeys(val);
	}
	public void entereqpcomment(String val) {
		waits.until(ExpectedConditions.visibilityOf(eqpcomment));
		eqpcomment.sendKeys(val);
	}
	
	public void equipmentsave() {
		waits.until(ExpectedConditions.visibilityOf(equipmentsavebtn));
		equipmentsavebtn.click();
	}
	
	public void clicknotes() {
		waits.until(ExpectedConditions.visibilityOf(Noteclick));
		Noteclick.click();
	}
	public void enternotes(String val) {
		waits.until(ExpectedConditions.visibilityOf(enternote));
		enternote.sendKeys(val);
	}
	public void clickcreate() {
		waits.until(ExpectedConditions.visibilityOf(createclick));
		createclick.click();
	}
}
