package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkflowLocators {
	
	//Watchers
	
	@FindBy(xpath="//ejs-multiselect[@id='multiUser']")
	private WebElement watchersclick;
	
	@FindBy(xpath="//ul[@id='multiUser_options']/li")
	private	List<WebElement> watcherslist;
	
	public void Selectwatcher(String watchername ) {
		try {
			selectDropdown(watcherslist, watchername);
		} catch (Exception e) {
			System.out.println("Watchers is not Found :"+e.getMessage());
		}
	}
	
	//Watchersgroup
	
	@FindBy(xpath="//ejs-multiselect[@id='multiUserGroup']")
	private WebElement watchersgroupclick;
	
	@FindBy(xpath="//ul[@id='multiUserGroup_options']/li")
	private List<WebElement> watchersgrouplist;
	
	public void Selectwatchersgroup(String watchersgroup) {
		try {
			selectDropdown(watchersgrouplist, watchersgroup);
		} catch (Exception e) {
			System.out.println("Watchers group list is not Found :"+e.getMessage());
		}
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
