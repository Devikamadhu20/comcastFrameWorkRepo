package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id="dtlview_Organization Name")
	private WebElement OrganizationNameRead;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameRead;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement startDateRead;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement endDateRead;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement organizationRead;
	
	public WebElement getOrganizationRead() {
		return organizationRead;
	}

	public WebElement getStartDateRead() {
		return startDateRead;
	}

	public WebElement getEndDateRead() {
		return endDateRead;
	}

	public WebElement getLastNameRead() {
		return lastNameRead;
	}
	

	public WebElement getOrganizationNameRead() {
		return OrganizationNameRead;
	}

	

}
