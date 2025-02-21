package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderTextInfoRead;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement OrganizationNameRead;
	
	@FindBy(xpath="(//td[@style='padding-bottom: 1em;'])[1]")
	private WebElement MyPreferencesButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneNoRead;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryRead;
	
	@FindBy(id="dtlview_Type")
	private WebElement typeRead;
	

	public WebElement getPhoneNoRead() {
		return phoneNoRead;
	}

	public WebElement getIndustryRead() {
		return industryRead;
	}

	public WebElement getTypeRead() {
		return typeRead;
	}

	public WebElement getphoneNoRead() {
		return phoneNoRead;
	}

	public WebElement getMyPreferencesButton() {
		return MyPreferencesButton;
	}

	public WebElement getHeaderTextInfoRead() {
		return HeaderTextInfoRead;
	}

	public WebElement getOrganizationNameRead() {
		return OrganizationNameRead;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	}


