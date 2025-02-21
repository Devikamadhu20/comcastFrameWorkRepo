package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewcontactBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderTextInfoRead;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameRead;
	
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createNewleadBtn;
	

	public WebElement getLeadNameRead() {
		return createNewleadBtn;
	}


	public WebElement getLastNameRead() {
		return lastNameRead;
	}


	public WebElement getHeaderTextInfoRead() {
		return HeaderTextInfoRead;
	}


	public WebElement getCreateNewcontactBtn() {
		return createNewcontactBtn;
	}
	
	

}
