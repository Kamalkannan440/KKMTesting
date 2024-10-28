package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FolderLocators {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"sidebar-nav\"]/li[4]/a")
	private WebElement project;

	public FolderLocators(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="grid_499977221_0_searchbar")
	private WebElement searchbar;
	
	@FindBy(id="grid_499977221_0_searchbutton")
	private WebElement searchicon;
	
	@FindBy(xpath = "//*[@id='grid_499977221_0_content_table']/tbody/tr[1]/td[4]")
	private WebElement projectclick;
	
	@FindBy(xpath = "//aside[@id='project-sidebar']/ul/descendant::li[3]")
	private WebElement doc;

	@FindBy(xpath = "//div[@rolepermissionbutton='Folder.Modify']/button")
	private WebElement plusbtn;

	@FindBy(xpath = "//div[@class='col-md-12 px-3']//input[@id='folderName']")
	private WebElement foldername;

	@FindBy(xpath = "//div[@class='modal-footer']//button[@type='submit']")
	private WebElement savebtn;
	
	@FindBy(xpath="//*[@id=\"treeelement_active\"]/div[2]/span/div/div[2]/button")
	private WebElement menubtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']/li[1]")
	private WebElement createbtn;
	
	@FindBy(xpath="//div[@class='col-md-12 px-3']//input[@id='folderName']")
	private WebElement subfolder;
	
	public void Navigateproject() {
		 FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(10))
	                .pollingEvery(Duration.ofSeconds(2));
		 wait.until(ExpectedConditions.elementToBeClickable(project));
		project.click();
	}

	public void pname(String name) {
		Actions act=new Actions (driver);
		wait.until(ExpectedConditions.elementToBeClickable(searchbar));
		act.click(searchbar).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchbar.sendKeys(name);
		}
	
	public void projectclik() {
		Actions act=new Actions (driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		act.click(searchicon).click().build().perform();
		projectclick.click();
		
	}
	public void navigatetodoc() {
		Actions act= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(doc));
		act.click(doc).build().perform();
	}

	public void Newfolder() {
		wait.until(ExpectedConditions.elementToBeClickable(plusbtn));
		System.out.println("Plus button is trying to be click");
		plusbtn.click();		
	}

	public void enterFoldername(String name) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
		Thread.sleep(5000);
		 System.out.println("Entering the Folder name");
		 foldername.click();
		 foldername.sendKeys(name);
		}

	public void clicksave() {
		wait.until(ExpectedConditions.elementToBeClickable(savebtn));
		savebtn.click();
	}
	public void subfolder(String name) throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(menubtn));
		menubtn.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(createbtn));
		createbtn.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(subfolder));
		subfolder.click();
		subfolder.sendKeys(name);
	}
	
}
