package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class convertLeadPage {
	public convertLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 @FindBy(id="select_potential")
	 private WebElement opportunityBtn;
	 
	public WebElement getOpportunityBtn() {
		return opportunityBtn;
	}

}
