package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {
	
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(name = "lastname")
	private WebElement lastnameEdit;
	
	@FindBy(name = "company")
	private WebElement companynameEdit;
	
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement saveBtnEdit;

	public WebElement getSaveBtnEdit() {
		return saveBtnEdit;
	}

	public WebElement getCompanynameEdit() {
		return companynameEdit;
	}

	public WebElement getLastnameEdit() {
		return lastnameEdit;

		
	}

}
