package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateNewContactPage {
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameEdit;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDateEdit;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgButton;
	
	public WebElement getSelectOrgButton() {
		return selectOrgButton;
	}

	@FindBy(name="support_end_date")
	private WebElement endDateEdit;
	
	

	public WebElement getStartDateEdit() {
		return startDateEdit;
	}

	public WebElement getEndDateEdit() {
		return endDateEdit;
	}

	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createNewContactWithDates(String lastName, String startDate,String endDate) {
			    
	   getLastnameEdit().sendKeys(lastName);
	   getStartDateEdit().clear();
	   getStartDateEdit().sendKeys(startDate);
	   getEndDateEdit().clear();
	   getEndDateEdit().sendKeys(endDate);
       getSaveBtn().click();
	}
	

}
