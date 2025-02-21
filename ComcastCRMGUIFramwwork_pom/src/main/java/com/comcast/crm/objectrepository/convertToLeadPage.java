package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class convertToLeadPage {
	public convertToLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Convert Lead']")
	private WebElement conToLeadLink;

	public WebElement getConToLeadLink() {
		return conToLeadLink;
	}

}
