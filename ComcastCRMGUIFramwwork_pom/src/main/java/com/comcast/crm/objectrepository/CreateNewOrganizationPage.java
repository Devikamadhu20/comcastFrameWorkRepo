package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "(//input[@accesskey='S'])[1]")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement Industrydd;

	@FindBy(name = "accounttype")
	private WebElement Typedd;

	@FindBy(id = "phone")
	private WebElement phoneNoEdit;

	public WebElement getphoneNoEdit() {
		return phoneNoEdit;
	}

	public WebElement getIndustrydd() {
		return Industrydd;
	}

	public WebElement getTypedd() {
		return Typedd;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg(String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}

	public void createNewOrgWithIndustryAndtype(String orgname, String ind, String type) {
		WebDriverUtility wLib = new WebDriverUtility();
		getOrgNameEdt().sendKeys(orgname);
		wLib.select(getIndustrydd(), ind);
		wLib.select(getTypedd(), type);
		getSaveBtn().click();
	}

}
