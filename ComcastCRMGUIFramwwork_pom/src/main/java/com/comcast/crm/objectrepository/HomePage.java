package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath="(//td[@style='padding-bottom: 1em;'])[1]")
	private WebElement MyPreferencesButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadLink;

	public WebElement getLeadLink() {
		return leadLink;
	}
	
	public WebElement getOrgLink() {
		return orgLink;
	}
		
	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getCampaignlnk() {
		return campaignlnk;
	}

	public void setCampaignlnk(WebElement campaignlnk) {
		this.campaignlnk = campaignlnk;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void setMoreLink(WebElement moreLink) {
		this.moreLink = moreLink;
	}
	

	public void navigateToCampaignPage(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignlnk.click();
		
	}
	
	public void SignoutAction(WebDriver driver) {
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.mousemoveOnElement(driver, getMyPreferencesButton());
		wLib.mousemoveOnElementAndClick(driver, getSignOutLink());
	}

	public WebElement getMyPreferencesButton() {
		return MyPreferencesButton;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}
	
	

}
